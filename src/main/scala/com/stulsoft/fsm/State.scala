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
case class State(name: String) {
  require(name != null && !name.isEmpty, "name could not be null or empty.")
}