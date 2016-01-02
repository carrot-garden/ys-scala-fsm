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
	def buildTransions():List[Transition]= {
		val input = new Input(new InputType("test"), new InputParams(Map("P1" -> ParamDouble(1.0))))
		val conditions = List[TransitionCondition](new TransitionCondition("P1", CompareType.withName(">"), ParamDouble(0.5)))
		List[Transition](new Transition(input, 100, new State("start"), new State("finish"), conditions, ConditionAggregationType.All)) 
	}
	
	"An Automaton" should "support transitions - one" in {
		val transitions = buildTransions().sortBy { x => x.priority }
		val nextState = Automaton.nextState(new State("start"), new Input(new InputType("test"), new InputParams(Map("P1" -> ParamDouble(1.0)))), transitions)
		nextState should be(new State("finish"))
		
		val nextStateNull = Automaton.nextState(new State("notExisting"), new Input(new InputType("test"), new InputParams(Map("P1" -> ParamDouble(1.0)))), transitions)
		nextStateNull should be(null)
	}
}