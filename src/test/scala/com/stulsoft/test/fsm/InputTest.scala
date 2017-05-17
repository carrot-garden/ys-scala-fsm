/**
 * Copyright (c) 2015, Yuriy Stul. All rights reserved
 */
 
package com.stulsoft.test.fsm

import org.scalatest.Matchers
import org.scalatest.FlatSpec
import com.stulsoft.fsm.InputType
import com.stulsoft.fsm.InputParams
import com.stulsoft.fsm.Input
import com.stulsoft.fsm.ParamInt
import com.stulsoft.fsm.ParamDouble

/**
 * Unit tests for InputTest class
 *  
 * @author Yuriy Stul
 *
 */
class InputTest extends FlatSpec with Matchers {
  "An Input" should "support equals" in {
  	val it1 = new InputType("t1")
  	val p1 = Map("p1" -> ParamInt(1), "p2" -> ParamDouble(2))
  	val ip1 = new InputParams(p1)
  	val i1 = new Input(it1, ip1)

  	val it2 = new InputType("t1")
  	val p2 = Map("p1" -> ParamInt(1), "p2" -> ParamDouble(2))
  	val ip2 = new InputParams(p2)
  	val i2 = new Input(it2, ip2)
  	
  	i1 should equal(i2)

  	val it3 = new InputType("t3")
  	val p3 = Map("p31" -> ParamInt(1), "p32" -> ParamDouble(2))
  	val ip3 = new InputParams(p3)
  	val i3 = new Input(it3, ip3)
  	
  	i1 should not equal i3
  }
  it should "support hashCode" in {
  	val it1 = new InputType("t1")
  	val p1 = Map("p11" -> ParamInt(1), "p12" -> ParamDouble(2))
  	val ip1 = new InputParams(p1)
  	val i1 = new Input(it1, ip1)

  	val it2 = new InputType("t1")
  	val p2 = Map("p11" -> ParamInt(1), "p12" -> ParamDouble(2))
  	val ip2 = new InputParams(p2)
  	val i2 = new Input(it2, ip2)
  	
  	i1.hashCode should equal (i2.hashCode)

  	val it3 = new InputType("t3")
  	val p3 = Map("p31" -> ParamInt(1), "p32" -> ParamDouble(2)) 
  	val ip3 = new InputParams(p3)
  	val i3 = new Input(it3, ip3)
  	
  	i1.hashCode should not equal i3.hashCode
  }
}