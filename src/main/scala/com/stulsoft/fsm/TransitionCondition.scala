package com.stulsoft.fsm

/** Holds a transition condition.
  *
  * @param paramName     specifies a parameter name in the [[Parameter]]
  * @param compareType   specifies a compare type
  * @param expectedValue specifies an expectedValue
  * @author Yuriy Stul
  */
case class TransitionCondition(paramName: String, compareType: CompareType.Value, expectedValue: Parameter) {
  require(paramName != null && !paramName.isEmpty, "paramName could not be null or empty")
  require(null != expectedValue, "expectedValue could not be null")
}