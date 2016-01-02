/**
 * Copyright (c) 2016, Yuriy Stul. All rights reserved
 */

package com.stulsoft.test.fsm

import org.scalatest.Matchers
import org.scalatest.FlatSpec
import com.stulsoft.fsm._

/**
 * Unit tests for Automation class.
 *
 * @author Yuriy Stul
 *
 */
class AutomatonTest extends FlatSpec with Matchers {
	def buildTransitionsOne(): List[Transition] = {
		val input = new Input(new InputType("test"), new InputParams(Map("P1" -> ParamDouble(1.0))))
		val conditions = List[TransitionCondition](new TransitionCondition("P1", CompareType.withName(">"), ParamDouble(0.5)))
		List[Transition](new Transition(input, 100, new State("start"), new State("finish"), conditions, ConditionAggregationType.All))
	}

	def buildTransitionsOneTransitionManyConditions(): List[Transition] = {
		val input = new Input(new InputType("test"), new InputParams(Map("P1" -> ParamDouble(1.0))))
		val conditions = List[TransitionCondition](new TransitionCondition("P1", CompareType.withName(">"), ParamDouble(0.5)),
			new TransitionCondition("P2", CompareType.withName("="), ParamDouble(3.0)))
		List[Transition](new Transition(input, 100, new State("start"), new State("finish"), conditions, ConditionAggregationType.All))
	}

	def buildTransitionsOneTransitionManyConditionsOne(): List[Transition] = {
		val input = new Input(new InputType("test"), new InputParams(Map("P1" -> ParamDouble(1.0))))
		val conditions = List[TransitionCondition](new TransitionCondition("P1", CompareType.withName(">"), ParamDouble(0.5)),
			new TransitionCondition("P2", CompareType.withName("="), ParamDouble(3.0)))
		List[Transition](new Transition(input, 100, new State("start"), new State("finish"), conditions, ConditionAggregationType.One))
	}
	
	def buildTransitionsOneTransitionManyConditionsNotOne(): List[Transition] = {
			val input = new Input(new InputType("test"), new InputParams(Map("P1" -> ParamDouble(1.0))))
					val conditions = List[TransitionCondition](new TransitionCondition("P1", CompareType.withName(">"), ParamDouble(0.5)),
							new TransitionCondition("P2", CompareType.withName("="), ParamDouble(3.0)))
					List[Transition](new Transition(input, 100, new State("start"), new State("finish"), conditions, ConditionAggregationType.NotOne))
	}

	def buildTransitionsTwo(): List[Transition] = {
		val input = new Input(new InputType("test"), new InputParams(Map("P1" -> ParamDouble(1.0))))
		val conditionsOne = List[TransitionCondition](new TransitionCondition("P1", CompareType.withName(">"), ParamDouble(0.5)))
		val conditionsTwo = List[TransitionCondition](new TransitionCondition("P2", CompareType.withName("<"), ParamInt(3)))
		List[Transition](new Transition(input, 100, new State("start"), new State("finish"), conditionsOne, ConditionAggregationType.All),
			new Transition(input, 10, new State("start"), new State("finish10"), conditionsTwo, ConditionAggregationType.All))
	}

	"An Automaton" should "support transitions - one" in {
		val transitions = buildTransitionsOne().sortBy { x => x.priority }
		val nextState = Automaton.nextState(new State("start"), new Input(new InputType("test"), new InputParams(Map("P1" -> ParamDouble(1.0)))), transitions)
		nextState should be(new State("finish"))

		val nextStateNull = Automaton.nextState(new State("notExisting"), new Input(new InputType("test"), new InputParams(Map("P1" -> ParamDouble(1.0)))), transitions)
		nextStateNull should be(null)
	}
	it should "support priorities" in {
		val transitions = buildTransitionsTwo().sortBy { x => x.priority }
		val nextState = Automaton.nextState(new State("start"), new Input(new InputType("test"), new InputParams(Map("P2" -> ParamInt(2)))), transitions)
		nextState should be(new State("finish10"))
	}
	it should "support aggregation type all" in {
		val transitions = buildTransitionsOneTransitionManyConditions().sortBy { x => x.priority }
		val nextStateFault = Automaton.nextState(new State("start"), new Input(new InputType("test"), new InputParams(Map("P1" -> ParamDouble(2)))), transitions)
		nextStateFault should be(null)

		val nextStateSuccess = Automaton.nextState(new State("start"), new Input(new InputType("test"), new InputParams(Map("P1" -> ParamDouble(2), "P2" -> ParamDouble(3.0)))), transitions)
		nextStateSuccess should be(new State("finish"))

		val nextStateFault2 = Automaton.nextState(new State("start"), new Input(new InputType("test"), new InputParams(Map("P1" -> ParamDouble(2), "P2" -> ParamDouble(3.0001)))), transitions)
		nextStateFault2 should be(null)
	}
	it should "support aggregation type one" in {
		val transitions = buildTransitionsOneTransitionManyConditionsOne().sortBy { x => x.priority }
		val nextStateSuccess1 = Automaton.nextState(new State("start"), new Input(new InputType("test"), new InputParams(Map("P1" -> ParamDouble(2)))), transitions)
		nextStateSuccess1 should be(new State("finish"))

		val nextStateSuccess2 = Automaton.nextState(new State("start"), new Input(new InputType("test"), new InputParams(Map("P1" -> ParamDouble(2), "P2" -> ParamDouble(3.0)))), transitions)
		nextStateSuccess2 should be(new State("finish"))

		val nextStateSuccess3 = Automaton.nextState(new State("start"), new Input(new InputType("test"), new InputParams(Map("P1" -> ParamDouble(2), "P2" -> ParamDouble(3.0001)))), transitions)
		nextStateSuccess3 should be(new State("finish"))
	}
	it should "support aggregation type notOne" in {
		val transitions = buildTransitionsOneTransitionManyConditionsNotOne().sortBy { x => x.priority }
		val nextStateFault1 = Automaton.nextState(new State("start"), new Input(new InputType("test"), new InputParams(Map("P1" -> ParamDouble(2)))), transitions)
				nextStateFault1 should be(null)
				
				val nextStateFault2 = Automaton.nextState(new State("start"), new Input(new InputType("test"), new InputParams(Map("P1" -> ParamDouble(2), "P2" -> ParamDouble(3.0)))), transitions)
				nextStateFault2 should be(null)
				
				val nextStateFault3 = Automaton.nextState(new State("start"), new Input(new InputType("test"), new InputParams(Map("P1" -> ParamDouble(2), "P2" -> ParamDouble(3.0001)))), transitions)
				nextStateFault3 should be(null)
	}
}