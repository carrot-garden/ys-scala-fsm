/**
 * Copyright (c) 2015, Yuriy Stul. All rights reserved
 */
 
package com.stulsoft.fsm

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
  
}