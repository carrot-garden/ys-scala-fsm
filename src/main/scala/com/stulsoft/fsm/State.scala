/**
  * Copyright (c) 2015, Yuriy Stul. All rights reserved
  */

package com.stulsoft.fsm

/**
  * The state.
  *
  * @author Yuriy Stul
  * @param name the state name.
  */
class State(val name: String) {
  require(name != null && !name.isEmpty, "name could not be null or empty.")

  override def equals(other: Any): Boolean = other match {
    case that: State => this.name == that.name
    case _ => false
  }

  override def hashCode: Int = {
    13 + (13 * name.hashCode)
  }

  override def toString: String = {
    s"State: name=$name"
  }
}