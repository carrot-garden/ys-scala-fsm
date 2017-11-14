package com.stulsoft.fsm

import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Yuriy Stul.
  */
class StateTest extends FlatSpec with Matchers {
  behavior of "State"
  "constructor" should "prevent empty name" in {
    val s1 = State("state1")
    an[IllegalArgumentException] should be thrownBy {
      State(null)
    }
    an[IllegalArgumentException] should be thrownBy {
      State("")
    }
  }
}
