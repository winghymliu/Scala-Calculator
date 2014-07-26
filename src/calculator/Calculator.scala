
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
class Calculator() {
  
  def calculate(inputs:List[Input]) = {
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
  
  def add(expr:List[Input]) = operator(expr,_+_)
  def subtract(expr:List[Input]) = operator(expr,_-_)
  def multiply(expr:List[Input]) = operator(expr,_*_)
  def divide(expr:List[Input]) = operator(expr,_/_)

  
  def operator (expr: List[Input], function : (Double,Double) => Double): Double = 
  {
    expr.last match
    {
       case Num(x) => function(eval(expr.init),x)
       case _ => function (eval(expr.take(1)), eval(expr.tail))
    }
  }
  
  

}