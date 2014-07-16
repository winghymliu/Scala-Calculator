
package calculator

sealed abstract trait Input
case class Num(a: Double) extends Input {
  override def toString() = a.toString
}
case class Add() extends Input {
  override def toString() = "+"
}
case class Subtract() extends Input {
  override def toString() = "-"
}
case class Multiply() extends Input {
  override def toString() = "*"
}
case class Divide() extends Input {
  override def toString() = "/"
}

/**
 * @author Hakan Ozbay
 *
 * A simple arithmetic calculator for Reverse Polish Notation.
 * This is a tail-recursive solution applied to the input expression
 */
class Calculator {

  def calculate(inputs: List[Input]) = {
    eval(inputs)
  }

  def eval(inputs: List[Input]): Double = {
    inputs.last match {
      case Num(x) =>
        if (inputs.size == 1)
        x
        else
          throw new IllegalArgumentException("Operators must be provided")
      case Add() =>
        add(inputs.init)
      case Subtract() =>
        subtract(inputs.init)
      case Multiply() =>
        multiply(inputs.init)
      case Divide() =>
        divide(inputs.init)
    }
  }

  def add(list: List[Input]): Double =
    {
      list.last match {
        case Num(x) =>
          eval(list.init) + x
        case _ =>
          eval(list.take(1)) + eval(list.tail)
      }
    }

  def subtract(list: List[Input]): Double =
    {
      list.last match {
        case Num(x) =>
          eval(list.init) - x
        case _ =>
          eval(list.take(1)) - eval(list.tail)
      }
    }

  def multiply(list: List[Input]): Double =
    {
      list.last match {
        case Num(x) =>
          eval(list.init) * x
        case _ =>
          eval(list.take(1)) * eval(list.tail)
      }
    }

  def divide(list: List[Input]): Double =
    {
      list.last match {
        case Num(x) =>
          eval(list.init) / x
        case _ =>
          eval(list.take(1)) / eval(list.tail)
      }
    }

}