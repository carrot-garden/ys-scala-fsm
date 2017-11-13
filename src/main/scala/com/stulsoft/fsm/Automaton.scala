package com.stulsoft.fsm

/**
  * Finite State Machine engine - automaton.
  *
  * @author Yuriy Stul
  *
  */
object Automaton {
  /** Calculates next state.
    *
    * @param state       the current state
    * @param input       the input details
    * @param transitions collection of the possible transitions.
    * @tparam P  parameter type
    * @tparam TC transition condition type
    * @return next state (optional)
    */
  def nextState[P >: Parameter[Any], TC](state: State, input: Input[P], transitions: Vector[Transition[P, TC]]): Option[State] = {
    require(state != null, "state could not be null.")
    require(input != null, "input could not be null.")
    require(transitions != null, "transitions could not be null.")

    transitions
      .filter(transition => state.equals(transition.sourceState))
      .find(transition => {
        checkTransition(state, input, transition)
      })
      .map(transition => transition.destinationState)
  }

  /** Checks the transition.
    *
    * @param state      current state
    * @param input      the input details
    * @param transition the transition to check
    * @tparam P  parameter type
    * @tparam TC transition condition type
    * @return true, if transition is matched; otherwise - false.
    */
  private def checkTransition[P >: Parameter[Any], TC](state: State, input: Input[P], transition: Transition[P, TC]): Boolean = {
    if (state == transition.sourceState && input.name == transition.input.name) {
      transition.aggregationType match {
        case ConditionAggregationType.One =>
          transition.conditions.exists(transactionCondition =>
            checkCondition(state, input, transactionCondition))

        case ConditionAggregationType.All => transition.conditions.forall(transactionCondition =>
          checkCondition(state, input, transactionCondition))

        case ConditionAggregationType.NotOne => !transition.conditions.exists(transactionCondition =>
          checkCondition(state, input, transactionCondition))

        case ConditionAggregationType.NotAll => !transition.conditions.forall(transactionCondition =>
          checkCondition(state, input, transactionCondition))

        case _ => throw new RuntimeException(s"Unsupported condition aggregation type ${transition.aggregationType}")
      }
    } else {
      false
    }
  }

  /**
    * Check one condition.
    *
    * @param state                the current state
    * @param input                the input details
    * @param transactionCondition the condition to check
    * @return true, if the condition is matched; otherwise - false.
    */
  private def checkCondition[P >: Parameter[Any], TC](state: State, input: Input[P], transactionCondition: TransitionCondition[TC]): Boolean = {
    input.parameters.get(transactionCondition.paramName) match {
      case Some(theValue: Parameter[P]) =>
        Parameter.compare(theValue, transactionCondition.compareType, transactionCondition.expectedValue)
      case None => false
    }
  }
}
