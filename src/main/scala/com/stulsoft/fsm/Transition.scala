package com.stulsoft.fsm

/** Holds a transition details.
  *
  * @param input            specifies an input
  * @param priority         specifies a priority
  * @param sourceState      specifies a sourceState
  * @param destinationState specifies a destinationState
  * @param conditions       specifies a conditions
  * @param aggregationType  specifies type of aggregation
  * @tparam P  parameter type
  * @author Yuriy Stul
  */
case class Transition[P >: Parameter](input: Input[P], priority: Int, sourceState: State, destinationState: State,
                                      conditions: List[TransitionCondition], aggregationType: ConditionAggregationType.Value)
