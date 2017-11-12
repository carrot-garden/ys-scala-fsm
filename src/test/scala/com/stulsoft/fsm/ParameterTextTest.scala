package com.stulsoft.fsm

import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Yuriy Stul.
  */
class ParameterTextTest extends FlatSpec with Matchers {
  behavior of "ParameterText"
  ">" should "work" in {
    val p1 = ParameterText("abc")
    val p2 = ParameterText("abcd")
    p1 > p2 shouldBe false
    p2 > p1 shouldBe true
  }
  "<" should "work" in {
    val p1 = ParameterText("abc")
    val p2 = ParameterText("abcd")
    p1 < p2 shouldBe true
    p2 < p1 shouldBe false
  }
  "==" should "work for equal" in {
    val p1 = ParameterText("abc")
    val p2 = ParameterText("abc")
    p1 == p2 shouldBe true
  }
  it should "work for non equal" in {
    val p1 = ParameterText("abcd")
    val p2 = ParameterText("abc")
    p1 == p2 shouldBe false
  }
  "!=" should "work for equal" in {
    val p1 = ParameterText("abc")
    val p2 = ParameterText("abc")
    p1 != p2 shouldBe false
  }
  it should "work for non equal" in {
    val p1 = ParameterText("abcd")
    val p2 = ParameterText("abc")
    p1 != p2 shouldBe true
  }
  ">=" should "work for equal" in {
    val p1 = ParameterText("abc")
    val p2 = ParameterText("abc")
    p1 >= p2 shouldBe true
  }
  it should "work for non equal" in {
    val p1 = ParameterText("abcd")
    val p2 = ParameterText("abc")
    p1 >= p2 shouldBe true
  }
  "<=" should "work for equal" in {
    val p1 = ParameterText("abc")
    val p2 = ParameterText("abc")
    p1 <= p2 shouldBe true
  }
  it should "work for non equal" in {
    val p1 = ParameterText("abcd")
    val p2 = ParameterText("abc")
    p2 <= p1 shouldBe true
  }
}
