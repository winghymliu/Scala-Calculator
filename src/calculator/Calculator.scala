
package calculator

sealed abstract trait Input
case class Num(a: Double) extends Input {
  override def toString() = a.toString
}
case class Plus() extends Input {
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
        x
      case Plus() =>
        addition(inputs.init)
      case Subtract() =>
        subtraction(inputs.init)
      case Multiply() =>
        multiply(inputs.init)
      case Divide() =>
        divide(inputs.init)
      case _ => throw new IllegalArgumentException("Operators must be provided")
    }
  }

  def addition(list: List[Input]): Double =
    {
      list match {
        case Num(x) :: xs =>
          x + eval(xs)
        case _ =>
          throw new IllegalArgumentException("An operand must be provided")
      }
    }

  def subtraction(list: List[Input]): Double =
    {
      list match {
        case Num(x) :: xs =>
          x - eval(xs)
        case _ =>
          throw new IllegalArgumentException("An operand must be provided")
      }
    }
  
  def multiply(list: List[Input]): Double =
    {
      list match {
        case Num(x) :: xs =>
          x * eval(xs)
        case _ =>
          throw new IllegalArgumentException("An operand must be provided")
      }
    }
  
  def divide(list: List[Input]): Double =
    {
      list match {
        case Num(x) :: xs =>
          x / eval(xs)
        case _ =>
          throw new IllegalArgumentException("An operand must be provided")
      }
    }

}