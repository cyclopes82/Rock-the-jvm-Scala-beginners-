package lectures.part1basics

object CBNvsCBV extends App {
  /**
   * In call by Value function, parameter is evaluated first and evaluated value is passed to the function
   *
   */
  def callByValue(x: Long): Unit = {
    println("System Time is :" + x) //152865174504600
    println("System Time is :" + x) //152865174504600
  }

  callByValue(System.nanoTime())

  /**
   * In call by Name function, parameter is evaluated when it is used so in below example to system time is different
   * on two occasions because it has been called twice   *
   */

  def callByName(x: => Long): Unit = {
    println("System Time is :" + x) //System.nanoTime())
    println("System Time is :" + x) //System.nanoTime())
  }

  callByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()

  def printFirst(x: Int, y: Int) = println(x)
  //printFirst(infinite(),1) // Gives Stack overflow Error
  println(1, infinite()) // Doesn't give an error, as infinite() is never called


}
