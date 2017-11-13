package com.stulsoft.fsm

import org.scalatest.{FlatSpec, Matchers}

/** Unit tests for Input class
  *
  * @author Yuriy Stul.
  */
class InputTest extends FlatSpec with Matchers {
  behavior of "ParameterText"
  "constructor" should "support different type of parameters" in {
    val inputName = "test input"
    val i = Input(inputName, Map("p1" -> TextParameter("abc"), "p2" -> IntParameter(1)))
    i.name shouldBe inputName
    i.parameters("p1") match {
      case TextParameter(x) => x == "abc" shouldBe true
    }
  }
}
