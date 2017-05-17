/**
 * Copyright (c) 2016, Yuriy Stul. All rights reserved
 */
 
package com.stulsoft.test.fsm

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import com.stulsoft.fsm.CompareType
import com.stulsoft.fsm.CompareType._
import com.stulsoft.fsm.Param
import com.stulsoft.fsm.ParamText
import com.stulsoft.fsm.ParamDouble
import com.stulsoft.fsm.ParamInt
import java.util.Calendar
import com.stulsoft.fsm.ParamDate

/**
 * Unit tests for Param class methods.
 * 
 * @author Yuriy Stul
 *
 */
class ParamTest extends FlatSpec with Matchers {
  "A Param" should "support compare operations with text" in {
  	Param.compare(ParamText("text"), Equal, ParamText("text")) shouldBe true
  	Param.compare(ParamText("text"), NotEqual, ParamText("text22")) shouldBe true
  	Param.compare(ParamText("text"), Less, ParamText("text22")) shouldBe true
  	Param.compare(ParamText("text"), LessEqual, ParamText("text22")) shouldBe true
  	Param.compare(ParamText("text"), LessEqual, ParamText("text")) shouldBe true
  	Param.compare(ParamText("text123"), Greater, ParamText("text")) shouldBe true
  	Param.compare(ParamText("text123"), GreaterEqual, ParamText("text")) shouldBe true
  	Param.compare(ParamText("text"), GreaterEqual, ParamText("text")) shouldBe true
  }
  it should "support compare operations with double" in {
  	Param.compare(ParamDouble(123.09), CompareType.withName("="), ParamDouble(123.09))
  	Param.compare(ParamDouble(123.09), CompareType.withName("!="), ParamDouble(123.0912))
  	Param.compare(ParamDouble(123.09), CompareType.withName("<"), ParamDouble(123.0912))
  	Param.compare(ParamDouble(123.09), CompareType.withName("<="), ParamDouble(123.0912))
  	Param.compare(ParamDouble(123.09), CompareType.withName("<="), ParamDouble(123.09))
  	Param.compare(ParamDouble(500.00), CompareType.withName(">"), ParamDouble(123.09))
  	Param.compare(ParamDouble(500.00), CompareType.withName(">="), ParamDouble(123.09))
  	Param.compare(ParamDouble(500.00), CompareType.withName(">="), ParamDouble(123.09))
  	Param.compare(ParamDouble(500.00), CompareType.withName(">="), ParamDouble(500))
  }
  it should "support compare operations with integer" in {
	  Param.compare(ParamInt(123), CompareType.withName("="), ParamInt(123))
	  Param.compare(ParamInt(123), CompareType.withName("!="), ParamInt(124))
	  Param.compare(ParamInt(123), CompareType.withName("<"), ParamInt(124))
	  Param.compare(ParamInt(123), CompareType.withName("<="), ParamInt(124))
	  Param.compare(ParamInt(123), CompareType.withName("<="), ParamInt(123))
	  Param.compare(ParamInt(500), CompareType.withName(">"), ParamInt(123))
	  Param.compare(ParamInt(500), CompareType.withName(">="), ParamInt(123))
	  Param.compare(ParamInt(500), CompareType.withName(">="), ParamInt(500))
  }
  it should "support compare operations with date" in {
  	val now = Calendar.getInstance.getTime
  	
  	val cBefore = Calendar.getInstance
  	cBefore.add(Calendar.DAY_OF_YEAR, -1)

  	val cAfter = Calendar.getInstance
  	cAfter.add(Calendar.DAY_OF_YEAR, 1)
  	val after = cAfter.getTime 
  	
	  Param.compare(ParamDate(now), CompareType.withName("="), ParamDate(now))
	  Param.compare(ParamDate(now), CompareType.withName("!="), ParamDate(after))
	  Param.compare(ParamDate(now), CompareType.withName("<"), ParamDate(after))
	  Param.compare(ParamDate(now), CompareType.withName("<="), ParamDate(after))
	  Param.compare(ParamDate(now), CompareType.withName("<="), ParamDate(now))
	  Param.compare(ParamDate(after), CompareType.withName(">"), ParamDate(now))
	  Param.compare(ParamDate(after), CompareType.withName(">="), ParamDate(now))
	  Param.compare(ParamDate(after), CompareType.withName(">="), ParamDate(after))
  }
}