package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"
  println(str.charAt(2)) // index start at 0
  println(str.substring(7, 11)) // (inclusive, Exclusive)
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)
  // Above all are java functions which are available in scala
  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))
  // Above are Scala Specific

  // Scala-Specific: String Interpolators

  // S- Interpolator
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and will be turning ${age + 1} years old."
  println(greeting)
  println(anotherGreeting)

  // F-Interploators
  val speed = 1.2f
  val myth = f"$name%s  can eat $speed%2.2f burgers per minute"

  println(myth)

  // RAW-Interploators
  println("This is a \n newline")
  println(raw"This is a \n newline")

  val escaped = "This is a \n newline"

  println(raw"$escaped")


}
