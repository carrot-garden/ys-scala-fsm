/**
 * Copyright (c) 2015, Yuriy Stul. All rights reserved
 */

package com.stulsoft.fsm.data

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
	
	override def equals(other: Any) = other match {
		case that: Input => this.inputType == that.inputType && this.inputParams == that.inputParams
		case _ => false
	}
	
	override def hashCode = {
		var h:Int = 0
		if (inputType != null) h += 13 + (13 * inputType.hashCode)
		if (inputParams != null) h += 17 + (17 * inputParams.hashCode)
		h
	}
	
	override def toString:String = {
		s"Input: inputType=$inputType, inputParams=$inputParams" 
	}
}