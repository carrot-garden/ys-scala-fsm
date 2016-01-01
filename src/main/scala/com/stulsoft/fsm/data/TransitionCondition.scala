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
 * @param compareType specifies a compare type
 * @param expectedValue specifies an expectedValue
 */
class TransitionCondition[D <% Ordered[D]](val paramName: String, val compareType: CompareType.Value, val expectedValue: D) {
	require(paramName != null && !paramName.isEmpty, "paramName could not be null or empty")
	require(compareType != null, "compareType could not be null or empty")
	require(expectedValue != null, "expectedValue could not be null")

	override def equals(other: Any) = other match {
		case that: TransitionCondition[D] => this.paramName == that.paramName && this.compareType == that.compareType && this.expectedValue == that.expectedValue
		case _ => false
	}

	override def hashCode = {
		var h: Int = 0
		if (paramName != null) h += 13 + (13 * paramName.hashCode)
		if (compareType != null) h += 17 + (17 * compareType.hashCode)
		if (expectedValue != null) h += 19 + (19 * expectedValue.hashCode)
		h
	}
	
	override def toString = {
		s"TransitionCondition: paramName=$paramName, compareType=$compareType, expectedValue=$expectedValue"
	}
}