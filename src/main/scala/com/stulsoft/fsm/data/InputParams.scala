/**
 * Copyright (c) 2015, Yuriy Stul. All rights reserved
 */

package com.stulsoft.fsm.data

/**
 * Holds an input parameters.
 *
 * @author Yuriy Stul
 *
 * @param params specifies collection with values of the input parameters
 */
class InputParams(val params: Map[String, Any]) {
	require(params != null, "params could not be null")
}