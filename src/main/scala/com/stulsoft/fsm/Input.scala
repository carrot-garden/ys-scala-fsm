package com.stulsoft.fsm

/** Input class
  *
  * @param name       input name
  * @param parameters map with parameters (parameter name -> parameter value)
  * @tparam T parameter type
  * @author Yuriy Stul.
  */
case class Input[T >: Parameter[Any]](name: String, parameters: Map[String, T])
