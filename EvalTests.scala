import org.scalatest._
import scala.collection.immutable.Stack

class EvalTests extends FlatSpec with Matchers {
	"Eval with an empty stack and inputs of one Num x" should " return x" in {
	  val calculator = new Calculator()
	  val inputs = List(Num(1.0))
	  val list = Nil
	  val result = calculator.eval(list, inputs)
	  
	  result should be (1.0)
	}
	
	"Addition with two Nums, x and y" should "return x + y" in {
	  val calculator = new Calculator()
	  
	  val x = 1.0
	  val y = 2.0
	  val list = List[Double](x,y)
	  
	  val resultList = calculator.addition(list);
	  val additionResult = resultList(0)
	  
	  additionResult should be (3.0)
	}
}