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
        fail("next state should NOT exist")
      case None =>
        succeed
    }
  }
  it should "work with aggregation - success" in {
    val currentState: State = State("start")
    val expectedState: State = State("finish")
    val input1 = Input("input 1", Map("p1" -> IntParameter(1), "p2" -> TextParameter("test")))
    val conditions = List(
      TransitionCondition(paramName = "p1", compareType = CompareType.Equal, expectedValue = IntParameter(1)),
      TransitionCondition(paramName = "p2", compareType = CompareType.Equal, expectedValue = TextParameter("test"))
    )
    val transitions = Vector(
      Transition(input = input1,
        priority = 100,
        sourceState = State("start"),
        destinationState = State("finish"),
        conditions = conditions,
        aggregationType = ConditionAggregationType.All))
    val nextState = Automaton.nextState(currentState, input1, transitions)
    nextState match {
      case Some(newState) =>
        newState shouldBe expectedState
      case None => fail("next state should be exist")
    }
  }
  it should "work with aggregation - failure" in {
    val currentState: State = State("start")
    val input1 = Input("input 1", Map("p1" -> IntParameter(1), "p2" -> TextParameter("testERROR")))
    val conditions = List(
      TransitionCondition(paramName = "p1", compareType = CompareType.Equal, expectedValue = IntParameter(1)),
      TransitionCondition(paramName = "p2", compareType = CompareType.Equal, expectedValue = TextParameter("test"))
    )
    val transitions = Vector(
      Transition(input = input1,
        priority = 100,
        sourceState = State("start"),
        destinationState = State("finish"),
        conditions = conditions,
        aggregationType = ConditionAggregationType.All))
    val nextState = Automaton.nextState(currentState, input1, transitions)
    nextState match {
      case Some(_) =>
        fail("next state should NOT exist")
      case None =>
        succeed
    }
  }
  it should "work with non-existing input - failure" in {
    val currentState: State = State("start")
    val input1 = Input("input 1", Map("p1" -> IntParameter(1), "p2" -> TextParameter("test")))
    val input2 = Input("input 2", Map("p1" -> IntParameter(1), "p2" -> TextParameter("test")))
    val conditions = List(
      TransitionCondition(paramName = "p1", compareType = CompareType.Equal, expectedValue = IntParameter(1)),
      TransitionCondition(paramName = "p2", compareType = CompareType.Equal, expectedValue = TextParameter("test"))
    )
    val transitions = Vector(
      Transition(input = input1,
        priority = 100,
        sourceState = State("start"),
        destinationState = State("finish"),
        conditions = conditions,
        aggregationType = ConditionAggregationType.All))
    val nextState = Automaton.nextState(currentState, input2, transitions)
    nextState match {
      case Some(_) =>
        fail("next state should NOT exist")
      case None =>
        succeed
    }
  }
  it should "work with list of transitions input - success" in {
    val currentState: State = State("start")
    val expectedState: State = State("finish2")
    val input1 = Input("input 1", Map("p1" -> IntParameter(1), "p2" -> TextParameter("test1")))
    val input2 = Input("input 2", Map("p1" -> IntParameter(2), "p2" -> TextParameter("test2")))
    val conditions1 = List(
      TransitionCondition(paramName = "p1", compareType = CompareType.Equal, expectedValue = IntParameter(1)),
      TransitionCondition(paramName = "p2", compareType = CompareType.Equal, expectedValue = TextParameter("test1"))
    )
    val conditions2 = List(
      TransitionCondition(paramName = "p1", compareType = CompareType.Equal, expectedValue = IntParameter(2)),
      TransitionCondition(paramName = "p2", compareType = CompareType.Equal, expectedValue = TextParameter("test2"))
    )
    val transitions = Vector(
      Transition(input = input1,
        priority = 100,
        sourceState = State("start"),
        destinationState = State("finish1"),
        conditions = conditions1,
        aggregationType = ConditionAggregationType.All),
      Transition(input = input2,
        priority = 100,
        sourceState = State("start"),
        destinationState = State("finish2"),
        conditions = conditions2,
        aggregationType = ConditionAggregationType.All)
    )
    val nextState = Automaton.nextState(currentState, input2, transitions)
    nextState match {
      case Some(x: State) =>
        x shouldBe expectedState
      case None =>
        fail("next state should be exist")
    }
  }
}
