package com.stulsoft.fsm

/**
  * @author Yuriy Stul.
  */

/** The state
  *
  * @param name the state name
  * @author Yuriy Stul.
  */
case class State(name: String) {
  require(name != null && name.nonEmpty, "name could not be null or empty.")
}
