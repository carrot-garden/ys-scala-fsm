package com.stulsoft.fsm

import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Yuriy Stul.
  */
class InputTest extends FlatSpec with Matchers {
  behavior of "ParameterText"
  "constructor" should "support different type of parameters" in {
   val i = Input("test input", Map("p1"->TextParameter("abc"), "p2"->IntParameter(1)))
    i should exist
  }
}
