package com.stulsoft.fsm

/** Specifies possible compare operations.
  *
  * @author Yuriy Stul.
  */
object CompareType extends Enumeration {
  type CompareType = Value
  val Less: Value = Value("<")
  val LessEqual: Value = Value("<=")
  val Greater: Value = Value(">")
  val GreaterEqual: Value = Value(">=")
  val Equal: Value = Value("=")
  val NotEqual: Value = Value("!=")
}
