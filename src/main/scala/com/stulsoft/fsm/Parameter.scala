package com.stulsoft.fsm

import com.stulsoft.fsm.CompareType._

/**
  * @author Yuriy Stul.
  */
trait Parameter[T] {
  /**
    * Returns ''true'' if this value is greater than x, ''false'' otherwise
    *
    * @param x parameter to compare with
    * @return ''true'' if this value is greater than x, ''false'' otherwise
    */
  def >(x: Parameter[T]): Boolean

  /**
    * Returns ''true'' if this value is less than x, ''false'' otherwise
    *
    * @param x parameter to compare with
    * @return ''true'' if this value is less than x, ''false'' otherwise
    */
  def <(x: Parameter[T]): Boolean

  /**
    * Returns ''true'' if this value is not equal to x, ''false'' otherwise
    *
    * @param x parameter to compare with
    * @return ''true'' if this value is not equal to x, ''false'' otherwise
    */
  def !=(x: Parameter[T]): Boolean = ! ==(x)

  /**
    * Returns ''true'' if this value is equal to x, ''false'' otherwise
    *
    * @param x parameter to compare with
    * @return ''true'' if this value is equal to x, ''false'' otherwise
    */
  def ==(x: Parameter[T]): Boolean = ! <(x) && ! >(x)

  /**
    * Returns ''true'' if this value is greater or equal to x, ''false'' otherwise
    *
    * @param x parameter to compare with
    * @return ''true'' if this value is greater or equal to x, ''false'' otherwise
    */
  def >=(x: Parameter[T]): Boolean = >(x) || ==(x)

  /**
    * Returns ''true'' if this value is less or equal to x, ''false'' otherwise
    *
    * @param x parameter to compare with
    * @return ''true'' if this value is less or equal to x, ''false'' otherwise
    */
  def <=(x: Parameter[T]): Boolean = <(x) || ==(x)
}

/**
  * Parameter class implementation for text.
  *
  * @param textValue the parameter value
  */
case class TextParameter(textValue: String) extends Parameter[String] {
  require(textValue != null, "textValue could not be null.")

  /**
    * Returns ''true'' if this value is greater than x, ''false'' otherwise
    *
    * @param x parameter to compare with
    * @return ''true'' if this value is greater than x, ''false'' otherwise
    */
  override def >(x: Parameter[String]): Boolean = x match {
    case TextParameter(v) => textValue > v
  }


  /**
    * Returns ''true'' if this value is less than x, ''false'' otherwise
    *
    * @param x parameter to compare with
    * @return ''true'' if this value is less than x, ''false'' otherwise
    */
  override def <(x: Parameter[String]): Boolean = x match {
    case TextParameter(v) => textValue < v
  }
}

/**
  * Parameter class implementation for text.
  *
  * @param intValue the parameter value
  */
case class IntParameter(intValue: Int) extends Parameter[Int] {
  /**
    * Returns ''true'' if this value is greater than x, ''false'' otherwise
    *
    * @param x parameter to compare with
    * @return ''true'' if this value is greater than x, ''false'' otherwise
    */
  override def >(x: Parameter[Int]): Boolean = x match {
    case IntParameter(v) => intValue > v
  }


  /**
    * Returns ''true'' if this value is less than x, ''false'' otherwise
    *
    * @param x parameter to compare with
    * @return ''true'' if this value is less than x, ''false'' otherwise
    */
  override def <(x: Parameter[Int]): Boolean = x match {
    case IntParameter(v) => intValue < v
  }
}

object Parameter {
  def compare[T](left: Parameter[T], compareType: CompareType, right: Parameter[T]): Boolean = {
    require(null != left, "left could not be null")
    require(compareType != null, "compareType could not be null")
    require(null != right, "right could not be null")
    compareType match {
      case Equal => left == right
      case NotEqual => !(left == right)
      case Greater => left > right
      case GreaterEqual => !(left < right)
      case Less => left < right
      case LessEqual => !(left > right)
      case _ => throw new RuntimeException(s"Unsupported compare type $compareType")
    }
  }
}
