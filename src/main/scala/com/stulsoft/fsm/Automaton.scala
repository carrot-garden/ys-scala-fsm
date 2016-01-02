/**
 * Copyright (c) 2015, Yuriy Stul. All rights reserved
 */

package com.stulsoft.fsm

/**
 * Finite State Machine engine - automaton.
 *
 * @author Yuriy Stul
 *
 */
object Automaton {
	/**
	 * Calculates next state.
	 *
	 * @param state the current state
	 * @param input the input details
	 * @param transitions collection of the possible transitions.
	 * @return next state, if it exists; otherwise - null.
	 */
	def nextState(state: State, input: Input, transitions: List[Transition]): State = {
		require(state != null, "state could not be null.")
		require(input != null, "input could not be null.")
		require(transitions != null, "transitions could not be null.")

		val optionalTransition = transitions
			.filter(transition => state.equals(transition.sourceState))
			.find(transition => { checkTransition(state, input, transition) })

		if (optionalTransition.isDefined)
			optionalTransition.get.destinationState
		else
			null
	}

	/**
	 * Checks the transition.
	 *
	 * @param state current state
	 * @param input the input details
	 * @param transition the transition to check
	 * @return true, if transition is matched; otherwise - false.
	 */
	private def checkTransition(state: State, input: Input, transition: Transition): Boolean = {
		if (state.equals(transition.sourceState) && input.inputType.equals(transition.input.inputType)) {
			transition.aggregationType match {
				case ConditionAggregationType.One => {
					transition.conditions.find { transactionCondition =>
						{
							checkCondition(state, input, transactionCondition)
						}
					}.isDefined
				}
				case ConditionAggregationType.All => {
					transition.conditions.forall { transactionCondition =>
						{
							checkCondition(state, input, transactionCondition)
						}
					}
				}
				case ConditionAggregationType.NotOne => !{
					transition.conditions.find { transactionCondition =>
						{
							checkCondition(state, input, transactionCondition)
						}
					}.isDefined
				}
				case ConditionAggregationType.NotAll => !{
					transition.conditions.forall { transactionCondition =>
						{
							checkCondition(state, input, transactionCondition)
						}
					}
				}
				case _ => throw new RuntimeException(s"Unsupported condition aggregation type ${transition.aggregationType}")
			}
		} else {
			false
		}
	}

	/**
	 * Check one condition.
	 *
	 * @param state the current state
	 * @param input the input details
	 * @param transactionCondition the condition to check
	 * @return true, if the condition is matched; otherwise - false.
	 */
	private def checkCondition(state: State, input: Input, transactionCondition: TransitionCondition): Boolean = {
		val inputParameterValue = input.inputParams.params.get(transactionCondition.paramName)

		if (inputParameterValue.isDefined) {
			val theValue = inputParameterValue.get
			Param.compare(theValue, transactionCondition.compareType, transactionCondition.expectedValue)
		} else false
	}
}