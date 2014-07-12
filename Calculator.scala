
sealed abstract trait Input
case class Num(a: Double ) extends Input
case class Plus() extends Input

class Calculator {
	
	def calculate(inputs : List[Input]) = {
		val list = Nil;
		eval(list, inputs)
	}
	
	def eval(list: List[Double], inputs: List[Input]) : Double ={
	  inputs match
	  {
	    case Nil => 
	      list.head
	  	case Num(x) :: xs => 
	  	  eval(list.+:(x), xs)
	  	case Plus() :: xs =>
	  	  eval(addition(list), xs)
	  	case _ => throw new Exception() 
	  }
	}
	
	def addition(list:List[Double]) : List[Double] ={
		List(list.foldRight(0.0)((sum,value) => sum + value));
	} 
}