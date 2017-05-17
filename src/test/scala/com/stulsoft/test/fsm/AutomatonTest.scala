/**
  * Copyright (c) 2016, Yuriy Stul. All rights reserved
  */

package com.stulsoft.test.fsm

import com.stulsoft.fsm._
import org.scalatest.{FlatSpec, Matchers}

/**
  * Unit tests for Automaton class.
  *
  * @author Yuriy Stul
  *
  */
class AutomatonTest extends FlatSpec with Matchers {
  def buildTransitionsOne(): List[Transition] = {
    val input = Input(InputType("test"), InputParams(Map("P1" -> ParamDouble(1.0))))
    val conditions = List[TransitionCondition](TransitionCondition("P1", CompareType.withName(">"), ParamDouble(0.5)))
    List[Transition](Transition(input, 100, State("start"), State("finish"), conditions, ConditionAggregationType.All))
  }

  def buildTransitionsOneTransitionManyConditions(): List[Transition] = {
    val input = Input(InputType("test"), InputParams(Map("P1" -> ParamDouble(1.0))))
    val conditions = List[TransitionCondition](TransitionCondition("P1", CompareType.withName(">"), ParamDouble(0.5)),
      TransitionCondition("P2", CompareType.withName("="), ParamDouble(3.0)))
    List[Transition](Transition(input, 100, State("start"), State("finish"), conditions, ConditionAggregationType.All))
  }

  def buildTransitionsOneTransitionManyConditionsOne(): List[Transition] = {
    val input = Input(InputType("test"), InputParams(Map("P1" -> ParamDouble(1.0))))
    val conditions = List[TransitionCondition](TransitionCondition("P1", CompareType.withName(">"), ParamDouble(0.5)),
      TransitionCondition("P2", CompareType.withName("="), ParamDouble(3.0)))
    List[Transition](Transition(input, 100, State("start"), State("finish"), conditions, ConditionAggregationType.One))
  }

  def buildTransitionsOneTransitionManyConditionsNotOne(): List[Transition] = {
    val input = Input(InputType("test"), InputParams(Map("P1" -> ParamDouble(1.0))))
    val conditions = List[TransitionCondition](TransitionCondition("P1", CompareType.withName(">"), ParamDouble(0.5)),
      TransitionCondition("P2", CompareType.withName("="), ParamDouble(3.0)))
    List[Transition](Transition(input, 100, State("start"), State("finish"), conditions, ConditionAggregationType.NotOne))
  }

  def buildTransitionsTwo(): List[Transition] = {
    val input = Input(InputType("test"), InputParams(Map("P1" -> ParamDouble(1.0))))
    val conditionsOne = List[TransitionCondition](TransitionCondition("P1", CompareType.withName(">"), ParamDouble(0.5)))
    val conditionsTwo = List[TransitionCondition](TransitionCondition("P2", CompareType.withName("<"), ParamInt(3)))
    List[Transition](Transition(input, 100, State("start"), State("finish"), conditionsOne, ConditionAggregationType.All),
      Transition(input, 10, State("start"), State("finish10"), conditionsTwo, ConditionAggregationType.All))
  }

  "An Automaton" should "support transitions - one" in {
    val transitions = buildTransitionsOne().sortBy { x => x.priority }
    val nextState = Automaton
      .nextState(State("start"), Input(InputType("test"), InputParams(Map("P1" -> ParamDouble(1.0)))), transitions)
    nextState.isDefined shouldBe true
    nextState.get should be(State("finish"))
    nextState.getOrElse(None) should be(State("finish"))

    val nextStateNone = Automaton
      .nextState(State("notExisting"), Input(InputType("test"), InputParams(Map("P1" -> ParamDouble(1.0)))), transitions)
    nextStateNone.isDefined shouldBe false
    nextStateNone.getOrElse(None) should be(None)

    val nextStateNone2 = Automaton
      .nextState(State("start"), Input(InputType("NONtest"), InputParams(Map("P1" -> ParamDouble(1.0)))), transitions)
    nextStateNone2.isDefined shouldBe false
    nextStateNone2.getOrElse(None) should be(None)
  }

  it should "support priorities" in {
    val transitions = buildTransitionsTwo().sortBy { x => x.priority }
    val nextState = Automaton
      .nextState(State("start"), Input(InputType("test"), InputParams(Map("P2" -> ParamInt(2)))), transitions)
    nextState should be(Some(State("finish10")))
  }

  it should "support aggregation type all" in {
    val transitions = buildTransitionsOneTransitionManyConditions().sortBy { x => x.priority }
    val nextStateFault = Automaton
      .nextState(State("start"), Input(InputType("test"), InputParams(Map("P1" -> ParamDouble(2)))), transitions)
    nextStateFault should be(None)

    val nextStateSuccess = Automaton
      .nextState(State("start"), Input(InputType("test"), InputParams(Map("P1" -> ParamDouble(2), "P2" -> ParamDouble(3.0)))), transitions)
    nextStateSuccess should be(Some(State("finish")))

    val nextStateFault2 = Automaton
      .nextState(State("start"), Input(InputType("test"), InputParams(Map("P1" -> ParamDouble(2), "P2" -> ParamDouble(3.0001)))), transitions)
    nextStateFault2.isDefined shouldBe false
  }

  it should "support aggregation type one" in {
    val transitions = buildTransitionsOneTransitionManyConditionsOne().sortBy { x => x.priority }
    val nextStateSuccess1 = Automaton
      .nextState(State("start"), Input(InputType("test"), InputParams(Map("P1" -> ParamDouble(2)))), transitions)
    nextStateSuccess1 should be(Some(State("finish")))

    val nextStateSuccess2 = Automaton
      .nextState(State("start"), Input(InputType("test"), InputParams(Map("P1" -> ParamDouble(2), "P2" -> ParamDouble(3.0)))), transitions)
    nextStateSuccess2 should be(Some(State("finish")))

    val nextStateSuccess3 = Automaton
      .nextState(State("start"), Input(InputType("test"), InputParams(Map("P1" -> ParamDouble(2), "P2" -> ParamDouble(3.0001)))), transitions)
    nextStateSuccess3 should be(Some(State("finish")))
  }

  it should "support aggregation type notOne" in {
    val transitions = buildTransitionsOneTransitionManyConditionsNotOne().sortBy { x => x.priority }
    val nextStateFault1 = Automaton
      .nextState(State("start"), Input(InputType("test"), InputParams(Map("P1" -> ParamDouble(2)))), transitions)
    nextStateFault1.isDefined shouldBe false

    val nextStateFault2 = Automaton
      .nextState(State("start"), Input(InputType("test"), InputParams(Map("P1" -> ParamDouble(2), "P2" -> ParamDouble(3.0)))), transitions)
    nextStateFault2.isDefined shouldBe false

    val nextStateFault3 = Automaton
      .nextState(State("start"), Input(InputType("test"), InputParams(Map("P1" -> ParamDouble(2), "P2" -> ParamDouble(3.0001)))), transitions)
    nextStateFault3.isDefined shouldBe false
  }
}