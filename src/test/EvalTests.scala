package test

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import calculator.Calculator
import calculator.Input
import calculator.Num
import calculator.Plus
import calculator.Subtract
import calculator.Multiply
import calculator.Divide
import calculator.Subtract
import calculator.Plus

/**
 * @author Hakan Ozbay
 * These tests are 'happy tests' (true positives) to evaluate correct application of the Reverse Polish Notation.
 * Validation/Acceptance tests are defined in the CalculatorTests class
 *
 */
class EvalTests extends FlatSpec with Matchers {
  "Eval with an empty list and inputs of one Num x" should " return x" in {
    val calculator = new Calculator()
    val inputs = List(Num(1.0))
    val result = calculator.eval(inputs)

    result should be(1.0)
  }

  "Addition with two Nums, x and y" should "return x + y" in {
    val calculator = new Calculator()

    val x = Num(1.0)
    val y = Num(2.0)
    val list = List[Input](x, y)

    val result = calculator.addition(list);

    result should be(3.0)
  }

  "Subtraction with two Nums, x and y" should "return x - y" in {
    val calculator = new Calculator()

    val x = Num(1.0)
    val y = Num(2.0)
    val list = List[Input](x, y)

    val result = calculator.subtraction(list);

    result should be(-1.0)
  }

  "Addition with three Nums: x,y,z ++" should "return x+y+z" in
    {
      val calculator = new Calculator()

      val x = Num(1.0)
      val y = Num(2.0)
      val z = Num(3.0)
      val list = List[Input](x, y, z, Plus(), Plus())

      val result = calculator.eval(list);

      result should be(6.0)
    }

  "Addition with two nums and subtraction with one: x,y,z +-" should "return x-(y+z)" in
    {
      val calculator = new Calculator()

      val x = Num(1.0)
      val y = Num(2.0)
      val z = Num(3.0)
      val list = List[Input](x, y, z, Plus(), Subtract())

      val result = calculator.eval(list);

      result should be(-4.0)
    }

  "Addition with two nums and subtraction with one in a mixed order: x,y,+,z,-" should "return (x + y) -z" in
    {
      val calculator = new Calculator()

      val x = Num(1.0)
      val y = Num(2.0)
      val z = Num(3.0)
      val list = List[Input](x, y, Plus(), z, Subtract())

      val result = calculator.eval(list);

      result should be(0.0)

    }
  
  "Multiply with two nums, Add with another and subtract with one in a mixed order: w,x,y,*,-,z,+" should "return (w - (x * y)) + z" in
  {
	  val calculator = new Calculator()
	  
	  val w = Num(1.0)
	  val x = Num(2.0)
	  val y = Num(3.0)
	  val z = Num(4.0)
	  val list = List[Input](w,x,y, Multiply(), Subtract(), z, Plus())
	  
	  val result = calculator.eval(list);
	  
	  result should be(-1.0)
	  
  }
  

  "Application of all operators: v,w,x,y,z +-*/" should "return v/(w*(x-(y+z))" in
    {
      val calculator = new Calculator()

      val v = Num(-12.0)
      val w = Num(2.0)
      val x = Num(3.0)
      val y = Num(4.0)
      val z = Num(5.0)
      val list = List[Input](v, w, x, y, z, Plus(), Subtract(), Multiply(), Divide())

      val result = calculator.eval(list);

      result should be(1.0)
    }
}