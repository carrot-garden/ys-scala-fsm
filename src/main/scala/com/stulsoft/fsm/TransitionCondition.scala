/**
  * Copyright (c) 2015, Yuriy Stul. All rights reserved
  */

package com.stulsoft.fsm

/**
  * Holds a transition condition.
  *
  * @author Yuriy Stul
  * @param paramName     specifies a parameter name in the [[InputParams]]
  * @param compareType   specifies a compare type
  * @param expectedValue specifies an expectedValue
  */
case class TransitionCondition(paramName: String, compareType: CompareType.Value, expectedValue: Param) {
  require(paramName != null && !paramName.isEmpty, "paramName could not be null or empty")
  require(compareType != null, "compareType could not be null or empty")
  require(expectedValue != null, "expectedValue could not be null")
}