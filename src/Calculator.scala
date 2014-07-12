import scala.collection.immutable.Stack

sealed abstract trait Input
case class Num(a: Double ) extends Input
case class Plus() extends Input

class Calculator {
	
	def calculate(inputs : List[Input]) = {
		val stack = new Stack[Double]();
		eval(stack, inputs)
	}
	
	def eval(stack: Stack[Double], inputs: List[Input]) : Double ={
	  inputs match
	  {
	    case Nil => 
	      stack.head
	  	case Num(x) :: xs => 
	  	  eval(stack.push(x), xs)
	  	case Plus() :: xs =>
	  	  eval(addition(stack), xs)
	  	case _ => throw new Exception() 
	  }
	}
	
	def addition(stack:Stack[Double]) : Stack[Double] ={
		val (left, newStack1) = stack.pop2
	    val (right, newStack2) = newStack1.pop2
	    val res = left + right
	    newStack2.push(res)
	} 
}