package lectures.part2oop
import playground.{Cindrella, PrinceCharming}

import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App  {

  //package members are accessible by their simple name
  val writer = new Writer("Daniel","RTJ",2018)

  //else import the package
  val princess = new Cindrella
  //--------OR----
  val princess1 = new playground.Cindrella //playground.cinderella = fully qualified name
  //packages are in hierarchy
  // matching folder section

  // package Object -- Package object can only be one per package
  // Kind of universal Constant
  sayHello
  println(SPEED_OF_LIGHT)

  //imports
  val prince = new PrinceCharming


  val d = new Date
  val sqldate = new java.sql.Date(2018,5,4)

  //defaults imports
  //java.lang = String, Object , Exception
  //Scala - Int, Nothing, Function
  //Scala.Predef - println, ???

}
