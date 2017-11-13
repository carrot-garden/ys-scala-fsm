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
  it should "work with params list" in {
    val params = (for {
      i <- 1 to 3
    } yield (s"p # $i", IntParameter(i))).toMap
    val inputName = "test input"
    val i = Input(inputName, params)
    i.parameters("p # 2") match {
      case IntParameter(x) => x shouldBe 2
    }
  }
}
