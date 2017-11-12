package com.stulsoft.fsm

/**
  * @author Yuriy Stul.
  */
case class Input[T:Parameter](name: String, parameters: Map[String, T])
