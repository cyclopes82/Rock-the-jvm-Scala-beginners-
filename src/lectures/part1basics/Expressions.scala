package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 //EXPRESSION
  println(x)

  println(2 + 3 * 4)

  /**
   * MATH Operators as follows
   * + - / & | ^^ << >> >>> (right shift with zero extension)
   */

  println(1 == x) // Equality Expression
  // == != > >=  <=
  println(!(1 == x))
  //! && ||

  var aVariable = 3
  aVariable += 2 // Also works with -= /= *= .......Side Effects
  println(aVariable)

  // Instructions(DO) vs Expressions (VALUE)

  // IF EXPRESSION
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3 // IF EXPRESSION
  println(aConditionedValue)
  println(if (aCondition) 5 else 3)

  var i = 0
  while (i < 5) {
    println(i)
    i += 1
  }

  //NEVER WRITE THIS AGAIN.
  // EVERYTHING IN SCALA IS AN "EXPRESSION!"

  val aWierdValue = (aVariable = 2) // Gives Unit i.e. Void
  println(aWierdValue)

  // While loops also gives side effect
  val aWhile = while (i < 5) {
    println(i)
    i += 1
  }

  //side effects: println(), whiles, reassigning
  //Side effects are like imperative programming, these are still expressions but returning Unit

  //Code Block
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodBye"
  }

  /**
   * --------------------------EXERCISES--------------------------------
   */

  // 1. difference between "hello World" vs println("hello world")?
  /** Ans: "Hello World" is a value of type string i.e. String Literal while println("Hello World")
   is a expression with side effect which prints "Hello World"    */


  // 2. What is the value of below expression?
  val someValue = {
    2 < 3  }
  // Ans: true(Boolean)
  val someOtherValue = {
    if (someValue) 239 else 986
    43
  }
  //Ans: 43(Int)
}
