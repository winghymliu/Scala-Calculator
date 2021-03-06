import org.scalatest._

class CalculatorTests extends FlatSpec with Matchers {
  val calculator = new Calculator

  "A calculator" should "just return a single number from a single number input" in {
    val input = List(Num(1.0))
    val result = calculator.calculate(input)
    result should be(1.0)
  }

  it should "throw an exception from an invalid PN to add two numbers" in {
    val input = List(Num(1.0), Plus, Num(2.0))
    intercept[StackException] {
      calculator.calculate(input)
    }
  }

  it should "throw an exception for any input with the incorrect number of operands and numbers" in {
    val input = List(Num(1.0), Num(2.0), Plus, Plus)
    intercept[StackException] {
      calculator.calculate(input)
    }
  }

}