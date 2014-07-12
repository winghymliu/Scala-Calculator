
sealed abstract trait Input
case class Num(a: Double ) extends Input
case class Plus() extends Input

class Calculator {
	
	def calculate(inputs : List[Input]) = {
		eval(inputs)
	}
	
	def eval(inputs: List[Input]) : Double ={
	  inputs.last match
	  {
	  	case Num(x) => 
	  	  x
	  	case Plus() =>
	  	  eval(addition(inputs.init))
	  	case _ => throw new Exception() 
	  }
	}
	
	def addition(list:List[Input]) : List[Input] =
	{	
		val added = list.foldLeft(0.0)((sum,value) => sum + getNumber(value))
		List(Num(added));
	} 
	
	def getNumber(input:Input) : Double =
	{
	 input match
	 {
	   case Num(x) => x
	   case _ => throw new Exception
	 }
	}
	
	
	
	
}