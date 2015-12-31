/**
 * Copyright (c) 2015, Yuriy Stul. All rights reserved
 */

package com.stulsoft.fsm

/**
 * Holds an input parameters.
 *
 * @author Yuriy Stul
 *
 * @param params specifies collection with values of the input parameters
 * @param aggregationType specifies type of aggregation
 */
class InputParams(val params: Map[String, Any], val aggregationType: ConditionAggregationType.Value) {
	require(params != null, "params could not be null")
}