/**
 * Copyright (c) 2015, Yuriy Stul. All rights reserved
 */
 
package com.stulsoft.fsm

/**
 * Specifies an input type.
 * 
 * @author Yuriy Stul
 * 
 * @param name specifies the input type
 *
 */
class InputType(val name: String) {
  override def equals(other: Any) = other match {
  	case that: InputType => this.name == that.name
  	case _ => false
  }
  
  override def hashCode = 41 * (41 + name.hashCode)
  
  override def toString = name
}