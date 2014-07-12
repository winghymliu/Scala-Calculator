object experiments {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
	val calculator = new Calculator()         //> calculator  : Calculator = Calculator@6da28362
	calculator.eval(List[Input](Num(1.0),Num(2.0),Plus()))
                                                  //> res0: Double = 3.0
}