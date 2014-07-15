import org.scalatest._

class AdditionTests extends FlatSpec with Matchers {
  val calculator = new Calculator

  it should "be able to add two postive numbers" in {
    val input = List(Num(1.0), Num(2.0), Plus)
    val result = calculator.calculate(input)
    result should be(3.0)
  }

  it should "be able to add three postive numbers" in {
    val input = List(Num(1.0), Num(2.0), Num(3.0), Plus, Plus)
    val result = calculator.calculate(input)
    result should be(6.0)
  }

  it should "be able to add four postive numbers" in {
    val input = List(Num(1.0), Num(2.0), Num(3.0), Num(4.0), Plus, Plus, Plus)
    val result = calculator.calculate(input)
    result should be(10.0)
  }

  it should "be able to add a negative number to a positive one" in {
    val input = List(Num(-1.0), Num(2.0), Plus)
    val result = calculator.calculate(input)
    result should be(1.0)
  }

  it should "be able to add a postive number to a negative one" in {
    val input = List(Num(1.0), Num(-2.0), Plus)
    val result = calculator.calculate(input)
    result should be(-1.0)
  }
}