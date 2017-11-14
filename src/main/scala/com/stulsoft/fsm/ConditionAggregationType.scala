package com.stulsoft.fsm

/** Specifies a type of the transition conditions aggregation.
  *
  * @author Yuriy Stul
  */
object ConditionAggregationType extends Enumeration {
  type ConditionAggregationType = Value
  /** Transition is available, if at least one condition is true */
  val One: Value = Value
  /** Transition is available, if all conditions is true */
  val All: Value = Value
  /** Transition is available, if all conditions is false */
  val NotAll: Value = Value
  /** Transition is available, if at least one condition is false */
  val NotOne: Value = Value
}