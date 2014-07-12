import org.scalatest._

class CalculatorTests extends FlatSpec with Matchers {
  val calculator = new Calculator

  "A calculator" should "just return 0.0 from an empty expression" in {
    val result = calculator.calculate(List.empty)
    result should be(0.0)
  }

  "A calculator" should "just return a single number from a single number input" in {
    val input = List(Num(1.0))
    val result = calculator.calculate(input)
    result should be(1.0)
  }

  "A calculator" should "throw exception from multiple numbers without an operator" in {
    val input = List(Num(1.0), Num(2.0))
    intercept[IllegalArgumentException] {
      calculator.calculate(input)
    }
  }

  "A calculator" should "be able to add two positive numbers" in {
    val input = List(Num(1.0), (Num(2.0)), Plus())
    val result = calculator.calculate(input)
    result should be(3.0)
  }

  "A calculator" should "throw exception from more than 2 numbers just one plus operator" in {
    val input = List(Num(1.0), Num(2.0), Num(3.0), Plus())
    intercept[IllegalArgumentException] {
      calculator.calculate(input)
    }
  }

  "A calculator" should "return 130.0 for '19.0 62.0 49.0 + +'" in {
    val input = List(Num(19.0), Num(62.0), Num(49.0), Plus(), Plus())
    val result = calculator.calculate(input)
    result should be(130.0)
  }

  /*
  it should "throw an exception from an invalid PN to add two numbers" in {
	  val input = List(Num(1.0), Plus(), Num(2.0)) 
	  intercept[IndexOutOfBoundsException]{
	    calculator.calculate(input)
	  }
  }
  
  it should "throw an exception for any input with the incorrect number of operands and numbers" in {
	  val input = List(Num(1.0), Num(2.0), Plus(), Plus()) 
	  intercept[IndexOutOfBoundsException]{
		  calculator.calculate(input)
	  }
  }
  
  it should "throw an exception for any input that doesn't just have numbers and ops" in {
	  val input = List(Num('a'), Num(2.0), Plus()) 
	  intercept[IndexOutOfBoundsException]{
		  calculator.calculate(input)
	  }
  }
  * */

}