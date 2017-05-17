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
		val it1 = new InputType("it1")
		val ip1 = new InputParams(Map("p1" -> ParamInt(123), "p2" -> ParamInt(321)))
		val i1 = new Input(it1, ip1)
		val ss1 = new State("ss1")
		val ds1 = new State("ds1")
		val c1 = List(new TransitionCondition("t1", Equal, ParamDouble(123.05)), new TransitionCondition("t2", Less, ParamInt(17)))
		val t1 = new Transition(i1, 1, ss1, ds1, c1, ConditionAggregationType.All)

		val it2 = new InputType("it1")
		val ip2 = new InputParams(Map("p1" -> ParamInt(123), "p2" -> ParamInt(321)))
		val i2 = new Input(it2, ip2)
		val ss2 = new State("ss1")
		val ds2 = new State("ds1")
		val c2 = List(new TransitionCondition("t1", Equal, ParamDouble(123.05)), new TransitionCondition("t2", Less, ParamInt(17)))
		val t2 = new Transition(i2, 1, ss2, ds2, c2, ConditionAggregationType.All)
		t1 should equal(t2)
		
		val it3 = new InputType("it1")
		val ip3 = new InputParams(Map("p1" -> ParamDouble(123.99), "p2" -> ParamDouble(321.01)))
		val i3 = new Input(it3, ip3)
		val ss3 = new State("ss1")
		val ds3 = new State("ds1")
		val c3 = List(new TransitionCondition("t1", Equal, ParamDouble(123.05)), new TransitionCondition("t2", Less, ParamInt(17)))
		val t3 = new Transition(i3, 1, ss3, ds3, c3, ConditionAggregationType.All)
		t1 should not equal t3
	}
	it  should "support hashCode" in {
		val it1 = new InputType("it1")
		val ip1 = new InputParams(Map("p1" -> ParamInt(123), "p2" -> ParamInt(321)))
		val i1 = new Input(it1, ip1)
		val ss1 = new State("ss1")
		val ds1 = new State("ds1")
		val c1 = List(new TransitionCondition("t1", Equal, ParamDouble(123.05)), new TransitionCondition("t2", Less, ParamInt(17)))
		val t1 = new Transition(i1, 1, ss1, ds1, c1, ConditionAggregationType.All)

		val it2 = new InputType("it1")
		val ip2 = new InputParams(Map("p1" -> ParamInt(123), "p2" -> ParamInt(321)))
		val i2 = new Input(it2, ip2)
		val ss2 = new State("ss1")
		val ds2 = new State("ds1")
		val c2 = List(new TransitionCondition("t1", Equal, ParamDouble(123.05)), new TransitionCondition("t2", Less, ParamInt(17)))
		val t2 = new Transition(i2, 1, ss2, ds2, c2, ConditionAggregationType.All)
		t1.hashCode should equal(t2.hashCode)
		
		val it3 = new InputType("it1")
		val ip3 = new InputParams(Map("p1" -> ParamDouble(123.99), "p2" -> ParamDouble(321.01)))
		val i3 = new Input(it3, ip3)
		val ss3 = new State("ss1")
		val ds3 = new State("ds1")
		val c3 = List(new TransitionCondition("t1", Equal, ParamDouble(123.05)), new TransitionCondition("t2", Less, ParamInt(17)))
		val t3 = new Transition(i3, 1, ss3, ds3, c3, ConditionAggregationType.All)
		t1.hashCode should not equal t3.hashCode
	}

}