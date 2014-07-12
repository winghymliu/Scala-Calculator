import scala.collection.immutable.Stack

sealed abstract trait Input
case class Num(a: Double) extends Input {
  override def toString() = a.toString
}
case class Plus() extends Input {
  override def toString() = "+"
}

class Calculator {

  def calculate(expr: Stack[Input]): Double = {
    def evalSubExpr(expr: Stack[Input]): (Double, Stack[Input]) = {
      expr.top match {
        case Num(n) =>
          (n, expr.pop)
        case Plus() =>
          val input2 = evalSubExpr(expr.pop)
          val input1 = evalSubExpr(input2._2)
          (input1._1 + input2._1, input1._2)
      }
    }
    if (expr.isEmpty)
      0.0
    else {
      val res = evalSubExpr(expr)
      require(res._2.isEmpty)
      res._1
    }
  }
}