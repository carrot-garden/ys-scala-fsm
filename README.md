# ys-scala-fsm
Scala Finite State Machine (FSM) 

## State Model
Collection of _Transition_ defines state model.

Each transition defines:
- source state
- destination state
- input (type and parameters)
- collection of conditions - TransitionCondition
- type of aggregation (all, one, etc.)
- priority

Each _TransitionCondition_ defines:
- parameter name
- compare type ("<", "=", ">", etc.)
- expected value

Parameter may be:
- Text
- Double
- Integer
- Date
