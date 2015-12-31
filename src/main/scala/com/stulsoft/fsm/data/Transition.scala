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
class Transition(val input: Input, val priority: Int, val sourceState: State, val destinationState: State, val conditions: List[TransitionCondition], val aggregationType: ConditionAggregationType.Value) {
	require(input != null, "input could not be null.")
	require(sourceState != null, "sourceState could not be null.")
	require(destinationState != null, "destinationState could not be null.")
	require(conditions != null, "conditions could not be null.")
}