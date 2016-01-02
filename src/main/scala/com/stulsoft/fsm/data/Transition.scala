/**
 * Copyright (c) 2015, Yuriy Stul. All rights reserved
 */

package com.stulsoft.fsm.data

/**
 * Holds a transition details.
 *
 * @author Yuriy Stul
 *
 * @param input specifies an input
 * @param priority specifies a priority
 * @param sourceState specifies a sourceState
 * @param destinationState specifies a destinationState
 * @param conditions specifies a conditions
 * @param aggregationType specifies type of aggregation
 */
class Transition(val input: Input, val priority: Int, val sourceState: State, val destinationState: State, val conditions: List[TransitionCondition], val aggregationType: ConditionAggregationType.Value){
	require(input != null, "input could not be null.")
	require(sourceState != null, "sourceState could not be null.")
	require(destinationState != null, "destinationState could not be null.")
	require(conditions != null, "conditions could not be null.")

	override def equals(other: Any) = other match {
		case that: Transition => this.input == that.input && this.priority == that.priority && this.sourceState == that.sourceState && this.destinationState == that.destinationState && this.conditions == that.conditions && this.aggregationType == that.aggregationType
	}

	override def hashCode = {
		val prime = 41
		var h = prime

		if (input != null) h *= prime + input.hashCode
		h *= prime + priority.hashCode
		if (sourceState != null) h *= prime + sourceState.hashCode
		if (destinationState != null) h *= prime + destinationState.hashCode
		if (conditions != null) h *= prime + conditions.hashCode
		if (aggregationType != null) h *= prime + aggregationType.hashCode

		h
	}

	override def toString = {
		s"Transition: input=$input, priority=$priority, sourceState=$sourceState, destinationState=$destinationState, conditions=$conditions, aggregationType=$aggregationType"
	}
}