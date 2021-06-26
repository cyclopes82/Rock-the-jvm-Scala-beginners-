package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  // In order to compute above function, JVM maintains a cold stack of each result
  def factorial1(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial1(n - 1)
      println("Computed factorial of " + n)
      result
    }
  }

  println(factorial1(4))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION: This is key Difference, as scala doesn't need to intermediate result
      // TAIL RECURSION : use recursive call as the LAST EXPRESSION
    }

    factHelper(n, 1)
  }

  /**
   * anotheractorial(10) = factHelper(10,1)
   * = factHelper(9, 10 * 1)
   * = factHelper(8, 9 * 10 * 1)
   * = factHelper(7, 8 * 9 * 10 * 1)
   * .
   * .
   * .
   * = factHelper(2, 3 * 4  * 5 * 6 * 7 * 8 * 9 * 10 * 1)
   * = factHelper(1, 2* 3 * 4  * 5 * 6 * 7 * 8 * 9 * 10 * 1)
   * = 2* 3 * 4  * 5 * 6 * 7 * 8 * 9 * 10 * 1
   */

  println(anotherFactorial(50))

  // WHEN YOU NEED LOOPS, USE _TAIL_RECURSION

  /**
   * --------------------------EXERCISES--------------------------------
   */
  // 1. Concatenate a string n times

  // Accumulator should have same return type as accumulator
  def concatenateTailRecursive(aString: String, n: Int): String = {
    @tailrec
    def concatenateHelper(t: Int, accumulator: String): String = {
      if (t <= 1) accumulator
      else concatenateHelper(t - 1, aString + " " + accumulator)
    }

    concatenateHelper(n, aString)
  }

  println(concatenateTailRecursive("Hello", 3))

  // OR
  @tailrec
  def anotherConcat(aString: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else anotherConcat(aString, n - 1, aString + " " + accumulator)
  }

  println(anotherConcat("Hello", 3, ""))
  // 2. isPrime function tail recursive
  def isPrime(n:Int):Boolean ={
    @tailrec
    def isPrimetailRec(t:Int,isStilPrime:Boolean):Boolean={
      if(!isStilPrime) false
      else if (t <=1) true
      else isPrimetailRec(t-1,n % t != 0 && isStilPrime)
    }
    isPrimetailRec(n/2,true)
  }
  println(isPrime(2003))
  println(isPrime(8))
  // 3. Fibonacci function as tail recursive

  def aFibonacci(n: Int): Int = {
    if (n <= 2) 1
    else aFibonacci(n - 1) + aFibonacci(n - 2)
  }

  def aFibonnaciTailRecursive(n:Int):Int = {
    def fibotailrec(i:Int, last:Int, nextToLast:Int):Int ={
      if (i >= n) last
      else fibotailrec(i + 1, last + nextToLast, last)
          }
    if (n <= 2) 1
    else fibotailrec(2,1,1)
  }
  println(aFibonnaciTailRecursive(8))

}
