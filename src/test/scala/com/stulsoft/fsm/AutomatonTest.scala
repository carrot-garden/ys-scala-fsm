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
    val input: Input[Parameter[Any]] = ???
    val transitions: Vector[Transition[Parameter[Any], Any]] = ???
    val nextState = Automaton.nextState(currentState, input, transitions)
    nextState match {
      case Some(newState) =>
        newState shouldBe expectedState
      case None => fail("next state should be exist")
    }
  }
}
