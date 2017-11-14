package com.stulsoft.fsm

import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Yuriy Stul.
  */
class AutomatonTest extends FlatSpec with Matchers {

  behavior of "AutomatonTest"
  "nextState" should "return next stage" in {
    val currentState: State = State("start")
    val expectedState: State = State("finish")
    val input1 = Input("input 1", Map("p1" -> IntParameter(1)))
    val conditions = List(TransitionCondition(paramName = "p1", compareType = CompareType.Equal, expectedValue = IntParameter(1)))
    val transitions = Vector(
      Transition(input = input1,
        priority = 100,
        sourceState = State("start"),
        destinationState = State("finish"),
        conditions = conditions,
        aggregationType = ConditionAggregationType.One))
    val nextState = Automaton.nextState(currentState, input1, transitions)
    nextState match {
      case Some(newState) =>
        newState shouldBe expectedState
      case None => fail("next state should be exist")
    }
  }
  it should "return None for non-existing transition" in {
    val currentState: State = State("start")
    val input1 = Input("input 1", Map("p1" -> IntParameter(1)))
    val conditions = List(TransitionCondition(paramName = "p1", compareType = CompareType.Equal, expectedValue = IntParameter(2)))
    val transitions = Vector(
      Transition(input = input1,
        priority = 100,
        sourceState = State("start"),
        destinationState = State("finish"),
        conditions = conditions,
        aggregationType = ConditionAggregationType.One))
    val nextState = Automaton.nextState(currentState, input1, transitions)
    nextState match {
      case Some(_) =>
        fail("next state should be NOT exist")
      case None =>
        succeed
    }
  }
}
