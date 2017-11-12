package com.stulsoft.fsm

/**
  * @author Yuriy Stul.
  */
trait Parameter[T] {
  /**
    * Returns `true` if this value is greater than x, `false` otherwise
    *
    * @param x parameter to compare with
    * @return `true` if this value is greater than x, `false` otherwise
    */
  def >(x: Parameter[T]): Boolean

  /**
    * Returns `true` if this value is less than x, `false` otherwise
    *
    * @param x parameter to compare with
    * @return `true` if this value is less than x, `false` otherwise
    */
  def <(x: Parameter[T]): Boolean

  /**
    * Returns `true` if this value is not equal to x, `false` otherwise
    *
    * @param x parameter to compare with
    * @return `true` if this value is not equal to x, `false` otherwise
    */
  def !=(x: Parameter[T]): Boolean = ! ==(x)

  /**
    * Returns `true` if this value is greater or equal to x, `false` otherwise
    *
    * @param x parameter to compare with
    * @return `true` if this value is greater or equal to x, `false` otherwise
    */
  def >=(x: Parameter[T]): Boolean = >(x) || ==(x)

  /**
    * Returns `true` if this value is equal to x, `false` otherwise
    *
    * @param x parameter to compare with
    * @return `true` if this value is equal to x, `false` otherwise
    */
  def ==(x: Parameter[T]): Boolean = ! <(x) && ! >(x)

  /**
    * Returns `true` if this value is less or equal to x, `false` otherwise
    *
    * @param x parameter to compare with
    * @return `true` if this value is less or equal to x, `false` otherwise
    */
  def <=(x: Parameter[T]): Boolean = <(x) || ==(x)
}

/**
  * Parameter class implementation for text.
  *
  * @param textValue the parameter value
  */
case class ParameterText(textValue: String) extends Parameter[String] {
  /**
    * Returns `true` if this value is greater than x, `false` otherwise
    *
    * @param x parameter to compare with
    * @return `true` if this value is greater than x, `false` otherwise
    */
  override def >(x: Parameter[String]): Boolean = x match {
    case ParameterText(v) => textValue > v
  }


  /**
    * Returns `true` if this value is less than x, `false` otherwise
    *
    * @param x parameter to compare with
    * @return `true` if this value is less than x, `false` otherwise
    */
  override def <(x: Parameter[String]): Boolean = x match {
    case ParameterText(v) => textValue < v
  }
}
