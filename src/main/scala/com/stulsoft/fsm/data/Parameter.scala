/**
 * Copyright (c) 2016, Yuriy Stul. All rights reserved
 */

package com.stulsoft.fsm.data

/**
 * @author Yuriy Stul
 *
 */
abstract class Param {
	/** Returns `true` if this value is greater than x, `false` otherwise. */
	def >(x: Param): Boolean
}
case class ParamText(val textValue: String) extends Param {
	override def >(x: Param) = x match {
		case ParamText(v) => textValue > v
		case _ => false
	}
}
case class ParamDouble(val doubleValue: Double) extends Param {
	override def >(x: Param) = x match {
		case ParamDouble(v) => doubleValue > v
		case _ => false
	}
}
case class ParamInt(val intValue: Int) extends Param {
	override def >(x: Param) = x match {
		case ParamInt(v) => intValue > v
		case _ => false
	}
}
object ParamComparator {
	def compare(left: Param, operator: String, right: Param): Boolean = left match {
		case ParamText(x) => operator match {
			case "==" => left == right
			case ">" => left > right
			case _ => throw new RuntimeException(s"Unsupported operator ${operator}")
		}
		case ParamDouble(x) => operator match {
			case "==" => left == right
			case ">" => left > right
			case _ => throw new RuntimeException(s"Unsupported operator ${operator}")
		}
		case ParamInt(x) => operator match {
			case "==" => left == right
			case ">" => left > right
			case _ => throw new RuntimeException(s"Unsupported operator ${operator}")
		}
		case _ => throw new RuntimeException(s"Unsupported type ${left.getClass}")
	}
}

object Main4Parameter {
	def main(args: Array[String]): Unit = {
		println("ParamText:")
		println(ParamComparator.compare(ParamText("t1"), "==", ParamText("t1")))
		println(ParamComparator.compare(ParamText("t1"), "==", ParamText("t2")))
		println(ParamComparator.compare(ParamText("t1"), ">", ParamText("t1")))
		println(ParamComparator.compare(ParamText("t1"), ">", ParamText("t2")))

		println("\nParamDouble:")
		println(ParamComparator.compare(ParamDouble(123), "==", ParamDouble(123)))
		println(ParamComparator.compare(ParamDouble(123.01), "==", ParamDouble(123.01)))
		println(ParamComparator.compare(ParamDouble(123), "==", ParamDouble(123.00)))
		println(ParamComparator.compare(ParamDouble(123), "==", ParamDouble(321)))
		println(ParamComparator.compare(ParamDouble(123), ">", ParamDouble(123)))
		println(ParamComparator.compare(ParamDouble(123.08), ">", ParamDouble(123.01)))
		println(ParamComparator.compare(ParamDouble(543), ">", ParamDouble(123.00)))
		println(ParamComparator.compare(ParamDouble(7), ">", ParamDouble(6)))

		println("\nParamInt:")
		println(ParamComparator.compare(ParamInt(123), "==", ParamInt(123)))
		println(ParamComparator.compare(ParamInt(1234), ">", ParamInt(123)))

		println("\nMixed:")
		println(ParamComparator.compare(ParamText("1"), "==", ParamDouble(1)))
		println(ParamComparator.compare(ParamText("2"), ">", ParamDouble(1)))
		println(ParamComparator.compare(ParamDouble(2), ">", ParamText("1")))
		println(ParamComparator.compare(ParamDouble(2), ">", ParamInt(1)))
	}
}