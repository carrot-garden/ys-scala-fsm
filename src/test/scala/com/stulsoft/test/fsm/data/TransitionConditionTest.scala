/**
 * Copyright (c) 2016, Yuriy Stul. All rights reserved
 */
 
package com.stulsoft.test.fsm.data

import org.scalatest.Matchers
import org.scalatest.FlatSpec
import com.stulsoft.fsm.data.TransitionCondition

/**
 * Unit tests for TransitionCondition class
 * 
 * @author Yuriy Stul
 *
 */
class TransitionConditionTest extends FlatSpec with Matchers {
  "A TransitionCondition" should "support equals" in{
  	val t1 = new TransitionCondition("t1", "op1", 123.05)
		val t2 = new TransitionCondition("t1", "op1", 123.05)
  	t1 should equal(t2)
  	
  	val t3 = new TransitionCondition("t3", "op1", 123.05)
  	t1 should not equal(t3)
  	
  	val t4 = new TransitionCondition("t1", "op4", 123.05)
  	t1 should not equal(t4)
  	
  	val t5 = new TransitionCondition("t1", "op1", 123.77)
  	t1 should not equal(t5)
  }
  it should "support hashCode" in {
  	val t1 = new TransitionCondition("t1", "op1", 123.05)
		val t2 = new TransitionCondition("t1", "op1", 123.05)
  	t1.hashCode should equal(t2.hashCode)
  	
  	val t3 = new TransitionCondition("t3", "op1", 123.05)
  	t1.hashCode should not equal(t3.hashCode)
  	
  	val t4 = new TransitionCondition("t1", "op4", 123.05)
  	t1.hashCode should not equal(t4.hashCode)
  	
  	val t5 = new TransitionCondition("t1", "op1", 123.77)
  	t1.hashCode should not equal(t5.hashCode)
  }
}