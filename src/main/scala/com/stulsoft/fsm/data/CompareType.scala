/**
 * Copyright (c) 2016, Yuriy Stul. All rights reserved
 */

package com.stulsoft.fsm.data

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

/*********************************************************
object Main4ExperimentsWithCompareType {
	def main(args: Array[String]): Unit = {
		println("==>main")
		println(s"CompareType.values=${CompareType.values}")
		val ct1 = CompareType.withName(">")
		println(s"ct1 = $ct1")
		val ct2 = CompareType.GreaterEqual
		println(s"ct2 = $ct2")

		val ct3 = CompareType.Less
		println(matcher(ct3))

		def matcher(c: CompareType.Value) = c match {
			case CompareType.Less => "less"
			case _ => "FAULT"
		}
		
		println("<==main")
	}
}
******************************************************/