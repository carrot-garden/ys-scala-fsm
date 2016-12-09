/**
  * Copyright (c) 2015, Yuriy Stul. All rights reserved
  */

package com.stulsoft.fsm

/**
  * Specifies an input type.
  *
  * @author Yuriy Stul
  * @param name specifies the input type
  *
  */
class InputType(val name: String) {
  override def equals(other: Any): Boolean = other match {
    case that: InputType => this.name == that.name
    case _ => false
  }

  override def hashCode: Int = 41 * (41 + name.hashCode)

  override def toString: String = name
}