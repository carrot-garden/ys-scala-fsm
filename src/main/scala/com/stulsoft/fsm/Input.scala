/**
 * Copyright (c) 2015, Yuriy Stul. All rights reserved
 */
 
package com.stulsoft.fsm

/**
 * Specifies an input.
 * 
 * @author Yuriy Stul
 *
 */
trait Input{
  val inputType: InputType
  val inputParams: InputParams
}