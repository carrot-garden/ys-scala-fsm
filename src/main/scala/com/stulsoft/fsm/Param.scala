/**
 * Copyright (c) 2016, Yuriy Stul. All rights reserved
 */

package com.stulsoft.fsm

import java.util.Date
import java.util.Calendar

import com.stulsoft.fsm.CompareType._

/**
 * Trait parameter class.
 *
 * Declares compare types.
 *
 * @author Yuriy Stul
 *
 */
trait Param {
	/** Returns `true` if this value is greater than x, `false` otherwise. */
	def >(x: Param): Boolean
	/** Returns `true` if this value is less than x, `false` otherwise. */
	def <(x: Param): Boolean
}

/**
 * Parameter class implementation for text.
 *
 * @author Yuriy Stul
 */
case class ParamText(val textValue: String) extends Param {
	/**
	 * Implements operator > for ParamText See [[Param.>]]
	 */
	override def >(x: Param) = x match {
		case ParamText(v) => textValue > v
		case _ => throw new RuntimeException(s"Could not compare with ${x.getClass}")
	}

	/**
	 * Implements operator < for ParamText See [[Param.<]]
	 */
	override def <(x: Param) = x match {
		case ParamText(v) => textValue < v
		case _ => throw new RuntimeException(s"Could not compare with ${x.getClass}")
	}
}

/**
 * Parameter class implementation for double.
 *
 * @author Yuriy Stul
 */
case class ParamDouble(val doubleValue: Double) extends Param {

	/**
	 * Implements operator > for ParamDouble See [[Param.>]]
	 */
	override def >(x: Param) = x match {
		case ParamDouble(v) => doubleValue > v
		case _ => throw new RuntimeException(s"Could not compare with ${x.getClass}")
	}

	/**
	 * Implements operator < for ParamDouble See [[Param.<]]
	 */
	override def <(x: Param) = x match {
		case ParamDouble(v) => doubleValue < v
		case _ => throw new RuntimeException(s"Could not compare with ${x.getClass}")
	}
}

/**
 * Parameter class implementation for integer.
 *
 * @author Yuriy Stul
 */
case class ParamInt(val intValue: Int) extends Param {

	/**
	 * Implements operator > for ParamInt See [[Param.>]]
	 */
	override def >(x: Param) = x match {
		case ParamInt(v) => intValue > v
		case _ => throw new RuntimeException(s"Could not compare with ${x.getClass}")
	}

	/**
	 * Implements operator < for ParamInt See [[Param.<]]
	 */
	override def <(x: Param) = x match {
		case ParamInt(v) => intValue < v
		case _ => throw new RuntimeException(s"Could not compare with ${x.getClass}")
	}
}

/**
 * Parameter class implementation for date.
 *
 * @author Yuriy Stul
 */
case class ParamDate(val dateValue: Date) extends Param {

	/**
	 * Implements operator > for ParamDate See [[Param.>]]
	 */
	override def >(x: Param) = x match {
		case ParamDate(v) => dateValue.after(v)
		case _ => throw new RuntimeException(s"Could not compare with ${x.getClass}")
	}

	/**
	 * Implements operator < for ParamDate See [[Param.<]]
	 */
	override def <(x: Param) = x match {
		case ParamDate(v) => dateValue.before(v)
		case _ => throw new RuntimeException(s"Could not compare with ${x.getClass}")
	}
}

/**
 * Parameter utilities.
 *
 * @author Yuriy Stul
 */

object Param {

	/**
	 * Compares left with right.
	 *
	 * @param left the left part of comparing
	 * @param compareType specifies the comparing type
	 * @param right the right part of comparing
	 * @return true, if expression is true, false otherwise
	 */
	def compare(left: Param, compareType: CompareType.Value, right: Param): Boolean = {
		if (left.getClass != right.getClass) {
			throw new RuntimeException(s"Could not compare ${left.getClass} with ${right.getClass}")
		}

		compareType match {
			case Equal => left == right
			case NotEqual => !(left == right)
			case Greater => left > right
			case GreaterEqual => !(left < right)
			case Less => left < right
			case LessEqual => !(left > right)
			case _ => throw new RuntimeException(s"Unsupported compare type ${compareType}")
		}
	}
}