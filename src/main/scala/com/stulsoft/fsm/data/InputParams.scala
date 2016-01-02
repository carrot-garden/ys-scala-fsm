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
class InputParams(val params: Map[String, Param]) {
	require(params != null, "params could not be null")

	override def equals(other: Any): Boolean = other match {
		case that: InputParams => this.params == that.params
		case _ => false
	}
	
	override def hashCode = {
		var h = 0
		if (params != null) h += 13 + (13 * params.hashCode)
		h
	}
	
	override def toString = {
		s"InputParams: param=$params"
	}
}