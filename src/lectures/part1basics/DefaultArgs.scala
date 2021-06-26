package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def factorial(n: Int, acc: Int = 1): Int = {
    if (n <= 0) acc
    else factorial(n - 1, n * acc)
  }

  println(factorial(5, 1))
  println(factorial(5))

  def savePicture(format:String = "jpg",width:Int,height:Int):Unit =println("Saving Picture")

  savePicture("jpg",800,600)
  savePicture(width = 800, height = 100)

  /**
   * 1. Pass in evey leading argument
   * 2. name the argument
   */

}
