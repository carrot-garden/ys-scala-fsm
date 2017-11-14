package com.stulsoft.fsm

import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Yuriy Stul.
  */
class IntParameterTest extends FlatSpec with Matchers {
  behavior of "ParameterText"
  ">" should "work" in {
    val p1 = IntParameter(1)
    val p2 = IntParameter(2)
    p1 > p2 shouldBe false
    p2 > p1 shouldBe true
  }
  "<" should "work" in {
    val p1 = IntParameter(1)
    val p2 = IntParameter(2)
    p1 < p2 shouldBe true
    p2 < p1 shouldBe false
  }
  "==" should "work for equal" in {
    val p1 = IntParameter(1)
    val p2 = IntParameter(1)
    p1 == p2 shouldBe true
  }
  it should "work for non equal" in {
    val p1 = IntParameter(2)
    val p2 = IntParameter(1)
    p1 == p2 shouldBe false
  }
  "!=" should "work for equal" in {
    val p1 = IntParameter(1)
    val p2 = IntParameter(1)
    p1 != p2 shouldBe false
  }
  it should "work for non equal" in {
    val p1 = IntParameter(2)
    val p2 = IntParameter(1)
    p1 != p2 shouldBe true
  }
  ">=" should "work for equal" in {
    val p1 = IntParameter(1)
    val p2 = IntParameter(1)
    p1 >= p2 shouldBe true
  }
  it should "work for non equal" in {
    val p1 = IntParameter(2)
    val p2 = IntParameter(1)
    p1 >= p2 shouldBe true
  }
  "<=" should "work for equal" in {
    val p1 = IntParameter(1)
    val p2 = IntParameter(1)
    p1 <= p2 shouldBe true
  }
  it should "work for non equal" in {
    val p1 = IntParameter(2)
    val p2 = IntParameter(1)
    p2 <= p1 shouldBe true
  }
}
