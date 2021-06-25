package lectures.part1basics

object ValuesVariableTypes extends App {
  val x: Int = 42
  println(x)

  //VALS ARE IMMUTABLE.
  //COMPILER can infer types

  val aString: String = "Hello"; // ; are not necessary

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4612
  val aLong: Long = 525555555555L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  //Variable
  var aVariable: Int = 4
  aVariable = 5 //Side Effects



}
