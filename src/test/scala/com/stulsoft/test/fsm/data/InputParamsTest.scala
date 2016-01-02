/**
 * Copyright (c) 2016, Yuriy Stul. All rights reserved
 */

package com.stulsoft.test.fsm.data

import org.scalatest.Matchers
import org.scalatest.FlatSpec
import com.stulsoft.fsm.data.InputParams
import com.stulsoft.fsm.data.InputParams

/**
 * Unit tests for InputParams class
 *  
 * @author Yuriy Stul
 *
 */
class InputParamsTest extends FlatSpec with Matchers {
	"An InputParamsTest" should "support equals" in {
		val ps1 = Map("p1" -> 1, "p2" -> 2)
		val ip1 = new InputParams(ps1)
		val ps2 = Map("p1" -> 1, "p2" -> 2)
		val ip2 = new InputParams(ps2)
		ip1 should equal(ip2)

		val ps3 = Map("p1" -> 11, "p2" -> 21)
		val ip3 = new InputParams(ps3)
		ip1 should not equal(ip3)
	}
	it should "support hashCode" in {
		val ps1 = Map("p1" -> 1, "p2" -> 2)
		val ip1 = new InputParams(ps1)
		val ps2 = Map("p1" -> 1, "p2" -> 2)
		val ip2 = new InputParams(ps2)
		ip1.hashCode should equal(ip2.hashCode)

		val ps3 = Map("p1" -> 11, "p2" -> 21)
		val ip3 = new InputParams(ps3)
		ip1.hashCode should not equal(ip3.hashCode)
	}
//	it should "support multiple typed values" in {
//		val ps1 = Map("pStr1" -> "str1", "pStr2" -> "str12")
//		val ip1 = new InputParams(ps1)
//		val is = ip1.params.get("pStr1").get > "123"
//		println(is)
//	}
}