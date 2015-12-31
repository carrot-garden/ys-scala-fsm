/**
 * Copyright (c) 2015, Yuriy Stul. All rights reserved
 */
 
package com.stulsoft.fsm

/**
 * Specifies a Transition 
 * @author Yuriy Stul
 *
 */
trait Transition {
  val input: Input
  val priority: Int
  val sourceState: State
  val destinationState: State
}