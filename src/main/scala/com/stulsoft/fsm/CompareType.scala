/**
 * Copyright (c) 2016, Yuriy Stul. All rights reserved
 */

package com.stulsoft.fsm

/**
 * Specifies possible compare operations.
 *
 * @author Yuriy Stul
 *
 */
object CompareType extends Enumeration {
	type CompareType = Value
	val Less = Value("<")
	val LessEqual = Value("<=")
	val Greater = Value(">")
	val GreaterEqual = Value(">=")
	val Equal = Value("=")
	val NotEqual = Value("!=")
}