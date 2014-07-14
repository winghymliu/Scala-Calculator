package test

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import calculator.Calculator
import calculator.Num
import calculator.Plus
import java.util.NoSuchElementException

/**
 * @author Hakan Ozbay
 * 
 * Validation/Acceptance tests for ensuring correct behaviour 
 * based on the expression formats, inputs and number of operators vs operands 
 * 
 */
class CalculatorTests extends FlatSpec with Matchers {
  val calculator = new Calculator

  "A calculator" should "just return a single number from a single number input" in {
    val input = List(Num(1.0))
    val result = calculator.calculate(input)
    result should be(1.0)
  }

  it should "throw an argument exception for an expresion that only has an operator " in {
    val input = List(Plus())
    intercept[IllegalArgumentException] {
      calculator.calculate(input)
    }
  }

  it should "throw an element exception for any input with the incorrect number of operators and numbers" in {
    val input = List(Num(1.0), Num(2.0), Plus(), Plus())
    intercept[NoSuchElementException] {
      calculator.calculate(input)
    }
  }

  it should "throw an argument exception for providing more operators than operands" in {
    val input = List(Num(1.0), Plus(), Plus())
    intercept[IllegalArgumentException] {
      calculator.calculate(input)
    }
  }

  it should "throw an argument exception for any inner expressions that aren't declared correctly" in {
    val input = List(Plus(), Num(2.0), Plus())
    intercept[IllegalArgumentException] {
      calculator.calculate(input)
    }
  }

  /*  
 *  I found the expression declaration format which gives a false positive - i.e. 
 *  these tests passes when it actually shouldn't. Code to be refactored to accomodate this. 
 *   
 *  it should "throw an argument exception for invalid expression" in {
	  val input = List(Num(1.0), Plus(), Num(2.0), Plus()) 
			  intercept[IllegalArgumentException]{
		  calculator.calculate(input)
	  }
	  
	it should "throw an argument exception for invalid order" in {
	  val input = List(Num(1.0), Plus(), Num(2.0)) 
	  intercept[IllegalArgumentException]{
	  calculator.calculate(input)
	  }
  }
  } */

}