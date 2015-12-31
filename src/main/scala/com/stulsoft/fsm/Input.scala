/**
 * Copyright (c) 2015, Yuriy Stul. All rights reserved
 */

package com.stulsoft.fsm

/**
 * Holds an input data.
 *
 * @author Yuriy Stul
 *
 * @param inputType specifies an input type
 * @param inputParams specifies an input parameters.
 *
 */
class Input(val inputType: InputType, val inputParams: InputParams) {
	require(inputType != null, "inputType could not be null.")
	require(inputParams != null, "inputParams could not be null.")
}