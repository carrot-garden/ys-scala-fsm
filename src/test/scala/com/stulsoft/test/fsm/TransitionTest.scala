/**
 * Copyright (c) 2016, Yuriy Stul. All rights reserved
 */

package com.stulsoft.test.fsm

import org.scalatest.Matchers
import org.scalatest.FlatSpec
import com.stulsoft.fsm.Transition
import com.stulsoft.fsm.TransitionCondition
import com.stulsoft.fsm.Input
import com.stulsoft.fsm.InputType
import com.stulsoft.fsm.InputParams
import com.stulsoft.fsm.State
import com.stulsoft.fsm.CompareType._
import com.stulsoft.fsm.ConditionAggregationType
import com.stulsoft.fsm.ParamInt
import com.stulsoft.fsm.ParamDouble

/**
 * Unit tests for Transition class
 * 
 * @author Yuriy Stul
 *
 */
class TransitionTest extends FlatSpec with Matchers {
	"A Transition" should "support equals" in {
		val it1 = InputType("it1")
		val ip1 = InputParams(Map("p1" -> ParamInt(123), "p2" -> ParamInt(321)))
		val i1 = Input(it1, ip1)
		val ss1 = State("ss1")
		val ds1 = State("ds1")
		val c1 = List(TransitionCondition("t1", Equal, ParamDouble(123.05)), TransitionCondition("t2", Less, ParamInt(17)))
		val t1 = Transition(i1, 1, ss1, ds1, c1, ConditionAggregationType.All)

		val it2 = InputType("it1")
		val ip2 = InputParams(Map("p1" -> ParamInt(123), "p2" -> ParamInt(321)))
		val i2 = Input(it2, ip2)
		val ss2 = State("ss1")
		val ds2 = State("ds1")
		val c2 = List(TransitionCondition("t1", Equal, ParamDouble(123.05)), TransitionCondition("t2", Less, ParamInt(17)))
		val t2 = Transition(i2, 1, ss2, ds2, c2, ConditionAggregationType.All)
		t1 should equal(t2)
		
		val it3 = InputType("it1")
		val ip3 = InputParams(Map("p1" -> ParamDouble(123.99), "p2" -> ParamDouble(321.01)))
		val i3 = Input(it3, ip3)
		val ss3 = State("ss1")
		val ds3 = State("ds1")
		val c3 = List(TransitionCondition("t1", Equal, ParamDouble(123.05)), TransitionCondition("t2", Less, ParamInt(17)))
		val t3 = Transition(i3, 1, ss3, ds3, c3, ConditionAggregationType.All)
		t1 should not equal t3
	}
	it  should "support hashCode" in {
		val it1 = InputType("it1")
		val ip1 = InputParams(Map("p1" -> ParamInt(123), "p2" -> ParamInt(321)))
		val i1 = Input(it1, ip1)
		val ss1 = State("ss1")
		val ds1 = State("ds1")
		val c1 = List(TransitionCondition("t1", Equal, ParamDouble(123.05)), TransitionCondition("t2", Less, ParamInt(17)))
		val t1 = Transition(i1, 1, ss1, ds1, c1, ConditionAggregationType.All)

		val it2 = InputType("it1")
		val ip2 = InputParams(Map("p1" -> ParamInt(123), "p2" -> ParamInt(321)))
		val i2 = Input(it2, ip2)
		val ss2 = State("ss1")
		val ds2 = State("ds1")
		val c2 = List(TransitionCondition("t1", Equal, ParamDouble(123.05)), TransitionCondition("t2", Less, ParamInt(17)))
		val t2 = Transition(i2, 1, ss2, ds2, c2, ConditionAggregationType.All)
		t1.hashCode should equal(t2.hashCode)
		
		val it3 = InputType("it1")
		val ip3 = InputParams(Map("p1" -> ParamDouble(123.99), "p2" -> ParamDouble(321.01)))
		val i3 = Input(it3, ip3)
		val ss3 = State("ss1")
		val ds3 = State("ds1")
		val c3 = List(TransitionCondition("t1", Equal, ParamDouble(123.05)), TransitionCondition("t2", Less, ParamInt(17)))
		val t3 = Transition(i3, 1, ss3, ds3, c3, ConditionAggregationType.All)
		t1.hashCode should not equal t3.hashCode
	}

}