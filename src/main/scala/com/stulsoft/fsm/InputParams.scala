/**
  * Copyright (c) 2015, Yuriy Stul. All rights reserved
  */

package com.stulsoft.fsm

/**
  * Holds an input parameters.
  *
  * @author Yuriy Stul
  * @param params specifies collection with values of the input parameters
  */
case class InputParams(params: Map[String, Param]) {
  require(params != null, "params could not be null")
}