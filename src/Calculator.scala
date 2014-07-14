import scala.collection.immutable.Stack

sealed abstract trait Input
case class Num(a: Double) extends Input {
  override def toString = a.toString
}
case object Plus extends Input {
  override def toString = "+"
}

class UnknownTokenException(message: String = null) extends RuntimeException(message)
class StackException(message: String = null) extends RuntimeException(message)

class Calculator {
	
	def calculate(inputs : List[Input]) = {
	  	 
	  if (inputs.length == 1){
	    inputs.head match {
	    	case Num(x) => x	    	  
	    	case _ => throw new Exception()	    	  
	    } 	        	      
	  } else {
	    val stack = new Stack[Double]();
		eval(stack, inputs)
	  }	     		
	}
	
	def eval(stack: Stack[Double], inputs: List[Input]) : Double ={
	  inputs match
	  {
	    case Nil => 
	      stack.head
	  	case Num(x) :: xs => 
	  	  eval(stack.push(x), xs)
	  	case Plus :: xs =>
	  	  eval(addition(stack), xs)
	  	case _ => throw new UnknownTokenException("Invalid RPN inputs") 
	  }
	}
	
	def addition(stack:Stack[Double]) : Stack[Double] ={
		if(stack.length < 2)
		  throw new StackException("Insufficient arguments in the stack to do addition")
	  
		val (left, newStack1) = stack.pop2
	    val (right, newStack2) = newStack1.pop2
	    val res = left + right
	    newStack2.push(res)
	} 
}