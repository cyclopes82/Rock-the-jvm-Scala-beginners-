package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  // Like everything in scala, Calling a function is also an Expression
  println(aFunction("Hello", 3))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction)

  // WHEN YOU NEED LOOPS, USE RECURSION
  // Define return type of function on case of recursion function
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("Hello ", 3))

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  // AUXILIARY FUNCTION : Function inside a function
  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  /**
   * --------------------------EXERCISES--------------------------------
   */
  // 1. A greeting function(name,age) => "Hi, my name is $name and I am $age years old"
  def greeting(name: String, age: Int): String = {
    s"Hi, my name is $name and I am $age years old."
  }

  println(greeting("Pratik", 3))

  // 2. Factorial Function 1 * 2 * 3 .. * n
  def aFactorial(n: Int): Int = {
    if (n <= 0) 1
    else n * aFactorial(n - 1)
  }

  println(aFactorial(5))


  // 3. A Fibonacci Function : f(1) = 1, f(2)= 1 & f(n) = f(n-1) + f(n-2)
  def aFibonacci(n: Int): Int = {
    if (n <= 2) 1
    else aFibonacci(n - 1) + aFibonacci(n - 2)
  }

  println(aFibonacci(4))

  // 4. Tests if number is Prime
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    }

    isPrimeUntil(n / 2)
  }
  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))
}
