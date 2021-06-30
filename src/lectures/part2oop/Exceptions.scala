package lectures.part2oop

object Exceptions extends App {
  val x: String = null
  //println(x.length)
  // Above statement will crash with NullPointerException
  //1. throwing Exceptions

  // Exceptions are also Expression
  //throw new NullPointerException // This is intentional crash of the program
 //--- val aWierdValue:String = throw new NullPointerException
  // Exceptions are of type Nothing ans hence aWierdValue can have type String etc
  // Exceptions are instance of classes, NullPointerException is a class, we are instantaiting it
  // we are throwing an exception
  // throwable classes extend the Throwable class
  // Exception and Error are major throwable subtype. Both will crash JVM
  // Exception : Denotes something wrong with program
  // Error : Something wrong with System like stackOverflow
  //---------------------------------------------------------------

  //2. How to catch Expression
  def getInt(withException:Boolean):Int ={
    if(withException) throw new RuntimeException("No Int for you!!")
    else 42
  }

  val potentialfail = try{
    // Code that might throw
     getInt(true)
  }catch {
    case e: RuntimeException =>  println("Caught Run time Exception")
    //case e: NullPointerException => println("------")
  }finally {
    // Code that will get executed no matter what
    // Optional
    // Does not influence the return
    // Use finally for side effects
    println("finally")

    // 3. How to define your own exceptions
    class MyException extends Exception
    val exception = new MyException

  //  throw exception
    // -----------------------------------EXERCISES--------------------------
    /*
    1. Crash your program with an OutOfMemoryError
    2. Crash with StackOverflow Error
    3. Pockect Calculato
          - add(x,y)
          - Subtract(x,y)
          - Multiply(x,y)
          - Divide(x,y)

          Throw
            - overflowException if add(x,y) exceeeds Int.MAX_VALUE
            - underflowException if substract(x,Y) exceeds Int.MIN_VALUE
            - MathCalculationException for division by 0
     */
    // 1. Crash your program with an OutOfMemoryError
    //  val array = Array.ofDim(Int.MaxValue)
    //2. Crash with StackOverflow Error
     def infinte:Int = 1 + infinte
     // infinte

    class OverFlowException extends RuntimeException
    class underFlowException extends RuntimeException
    class MathCalculationException extends RuntimeException("Division by zero")

    object PocketCalculator{
      def add(x:Int,y:Int) = {
        val result = x + y
        if (x > 0 && y > 0 && result < 0) throw new OverFlowException
        else if (x < 0 && y < 0 && result > 0) throw new underFlowException
        else result
      }

      def subtract (x:Int,y:Int) = {
        val result = x * y
        if (x > 0 && y > 0 && result < 0) throw new OverFlowException
        else if (x < 0 && y < 0 && result < 0) throw new underFlowException
        else result
      }

      def  multiply (x:Int,y:Int) = {
        val result = x - y
        if (x > 0 && y < 0 && result < 0) throw new OverFlowException
        else if (x < 0 && y > 0 && result > 0) throw new OverFlowException
        else if (x > 0 && y < 0 && result > 0) throw new underFlowException
        else if (x < 0 && y > 0 && result > 0) throw new underFlowException
        else result
      }

      def divide(x:Int,y:Int)={
        if(y==0) throw new MathCalculationException
        else x/y

      }


    }

    println(PocketCalculator.add(Int.MaxValue,10))

  }


}
