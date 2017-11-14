package com.stulsoft.fsm

import com.stulsoft.fsm.CompareType._
import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Yuriy Stul.
  */
class TextParameterTest extends FlatSpec with Matchers {
  behavior of "ParameterText"
  ">" should "work" in {
    val p1 = TextParameter("abc")
    val p2 = TextParameter("abcd")
    p1 > p2 shouldBe false
    p2 > p1 shouldBe true
  }
  "Greater" should "work" in {
    val p1 = TextParameter("abc")
    val p2 = TextParameter("abcd")
    Parameter.compare(p1, Greater, p2) shouldBe false
    Parameter.compare(p2, Greater, p1) shouldBe true
  }
  "<" should "work" in {
    val p1 = TextParameter("abc")
    val p2 = TextParameter("abcd")
    p1 < p2 shouldBe true
    p2 < p1 shouldBe false
    Parameter.compare(p1, Less, p2) shouldBe true
    Parameter.compare(p2, Less, p1) shouldBe false
  }
  "Less" should "work" in {
    val p1 = TextParameter("abc")
    val p2 = TextParameter("abcd")
    Parameter.compare(p1, Less, p2) shouldBe true
    Parameter.compare(p2, Less, p1) shouldBe false
  }

  "==" should "work for equal" in {
    val p1 = TextParameter("abc")
    val p2 = TextParameter("abc")
    p1 == p2 shouldBe true
  }
  it should "work for non equal" in {
    val p1 = TextParameter("abcd")
    val p2 = TextParameter("abc")
    p1 == p2 shouldBe false
  }
  "Equal" should "work for equal" in {
    val p1 = TextParameter("abc")
    val p2 = TextParameter("abc")
    Parameter.compare(p1, Equal, p2) shouldBe true
  }

  "!=" should "work for equal" in {
    val p1 = TextParameter("abc")
    val p2 = TextParameter("abc")
    p1 != p2 shouldBe false
  }
  it should "work for non equal" in {
    val p1 = TextParameter("abcd")
    val p2 = TextParameter("abc")
    p1 != p2 shouldBe true
  }
  "NotEqual" should "work for equal" in {
    val p1 = TextParameter("abc")
    val p2 = TextParameter("abc")
    Parameter.compare(p1, NotEqual, p2) shouldBe false
  }
  it should "work for non equal" in {
    val p1 = TextParameter("abcd")
    val p2 = TextParameter("abc")
    Parameter.compare(p1, NotEqual, p2) shouldBe true
  }

  ">=" should "work for equal" in {
    val p1 = TextParameter("abc")
    val p2 = TextParameter("abc")
    p1 >= p2 shouldBe true
  }
  it should "work for non equal" in {
    val p1 = TextParameter("abcd")
    val p2 = TextParameter("abc")
    p1 >= p2 shouldBe true
  }
  "GreaterEqual" should "work for equal" in {
    val p1 = TextParameter("abc")
    val p2 = TextParameter("abc")
    Parameter.compare(p1, GreaterEqual, p2) shouldBe true
  }
  it should "work for non equal" in {
    val p1 = TextParameter("abcd")
    val p2 = TextParameter("abc")
    Parameter.compare(p1, GreaterEqual, p2) shouldBe true
  }

  "<=" should "work for equal" in {
    val p1 = TextParameter("abc")
    val p2 = TextParameter("abc")
    p1 <= p2 shouldBe true
  }
  it should "work for non equal" in {
    val p1 = TextParameter("abcd")
    val p2 = TextParameter("abc")
    p2 <= p1 shouldBe true
  }
  "LessEqual" should "work for equal" in {
    val p1 = TextParameter("abc")
    val p2 = TextParameter("abc")
    Parameter.compare(p1, LessEqual, p2) shouldBe true
  }
  it should "work for non equal" in {
    val p1 = TextParameter("abcd")
    val p2 = TextParameter("abc")
    Parameter.compare(p2, LessEqual, p1) shouldBe true
  }
}
