/**
 * Copyright (c) 2015, Yuriy Stul. All rights reserved
 */

package com.stulsoft.test.fsm

import org.scalatest.Matchers
import org.scalatest.FlatSpec
import com.stulsoft.fsm.InputType

/**
 * Unit tests for InputType class.
 *
 * @author Yuriy Stul
 *
 */
class InputTypeTest extends FlatSpec with Matchers {
	"A InputType" should "support equals" in {
		val i1 = InputType("t1")
		val i2 = InputType("t1")
		i1 should equal(i2)
	}
	it should "support ==" in {
		val i1 = InputType("t1")
		val i2 = InputType("t1")

		(i1 == i2) shouldBe true
	}
	it should "support hashCode" in {
		val i1 = InputType("t1")
		val i2 = InputType("t1")
		i1.hashCode should equal(i2.hashCode)
		val i3 = InputType("t3")
		i1.hashCode should not equal i3.hashCode
	}
	it should "support toString" in {
		val i1 = InputType("t1")
		i1.toString should equal("InputType(t1)")
	}
}