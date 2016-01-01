/**
 * Copyright (c) 2015, Yuriy Stul. All rights reserved
 */

package com.stulsoft.fsm.data

/**
 * Holds a transition condition.
 *
 * @author Yuriy Stul
 *
 * @param paramName specifies a parameter name in the [[InputParams]]
 * @param operator specifies an operator
 * @param expectedValue specifies an expectedValue
 */
class TransitionCondition(val paramName: String, val operator: String, val expectedValue: Any) {
	require(paramName != null && !paramName.isEmpty, "paramName could not be null or empty")
	require(operator != null && !paramName.isEmpty, "operator could not be null or empty")
	require(expectedValue != null, "expectedValue could not be null")

	override def equals(other: Any) = other match {
		case that: TransitionCondition => this.paramName == that.paramName && this.operator == that.operator && this.expectedValue == that.expectedValue
		case _ => false
	}

	override def hashCode = {
		var h: Int = 0
		if (paramName != null) h += 13 + (13 * paramName.hashCode)
		if (operator != null) h += 17 + (17 * operator.hashCode)
		if (expectedValue != null) h += 19 + (19 * expectedValue.hashCode)
		h
	}
	
	override def toString = {
		s"TransitionCondition: paramName=$paramName, operator=$operator, expectedValue=$expectedValue"
	}
}