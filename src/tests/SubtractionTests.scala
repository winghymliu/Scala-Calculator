import org.scalatest._

class SubtractionTests extends FlatSpec with Matchers {
  val calculator = new Calculator
  it should "be able to subtract two numbers" in {
    val input = List(Num(4.0), Num(2.0), Sub)
    val result = calculator.calculate(input)
    result should be(2.0)
  }

  it should "be able to subtract two numbers to give a negative" +
    " and another subtract to give a postive" in {
      val input = List(Num(9.0), Num(2.0), Num(11.0), Sub, Sub)
      val result = calculator.calculate(input)
      result should be(18.0)
    }
  
  it should "be able to subtract two numbers to give a postive" +
    " and another large subtract to give a negative" in {
      val input = List(Num(1.0), Num(6.0), Num(2.0), Sub, Sub)
      val result = calculator.calculate(input)
      result should be(-3.0)
    }

  it should "be able to add and subtract three numbers" in {
    val input = List(Num(10.0), Num(2.0), Num(3.0), Plus, Sub)
    val result = calculator.calculate(input)
    result should be(5.0)
  }

  it should "be able to subtract then add three numbers" in {
    val input = List(Num(6.0), Num(2.0), Num(3.0), Sub, Plus)
    val result = calculator.calculate(input)
    result should be(5.0)
  }

  it should "be able to subtract two negative numbers" in {
    val input = List(Num(-1.0), Num(-2.0), Sub)
    val result = calculator.calculate(input)
    result should be(1.0)
  }
}