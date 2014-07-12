object experiments {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(64); 
  println("Welcome to the Scala worksheet");$skip(38); 
  
	val calculator = new Calculator();System.out.println("""calculator  : Calculator = """ + $show(calculator ));$skip(56); val res$0 = 
	calculator.eval(List[Input](Num(1.0),Num(2.0),Plus()));System.out.println("""res0: Double = """ + $show(res$0))}
}
