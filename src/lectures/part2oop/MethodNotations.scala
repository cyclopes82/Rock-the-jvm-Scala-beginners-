package lectures.part2oop

object MethodNotations extends App {

  //Creating a class inside a Object otherwise it will create a conflict with Person class
  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(Movie: String): Boolean = Movie == favoriteMovie

    //def hangOutWith(person:Person) = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person) = s"${this.name} is hanging out with ${person.name}" // Permissive method name

    def unary_! : String = s"$name, what the heck?"

    def isAlive: Boolean = true

    def apply() = s"Hi, my name is $name and I like $favoriteMovie"

    //--------------EXERCISE 1---------------------------
    def +(Nickname: String) = new Person(s"$name ($Nickname)", favoriteMovie)

    //--------------EXERCISE 2----------------------------
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    //--------------EXERCISE 3--------------------------
    def learns(skill: String) = s"$name learns $skill"

    def learnsScala = learns("Scala")

    //--------------EXERCISE 4 -------------------------
    def apply(n: Int) = s"$name watched $favoriteMovie $n times"
  }

  // Infix Notation = Syntactic Sugar
  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  // Infix Notation = Operator Notation
  println(mary likes "Inception") // Equivalent


  //"Operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom) //mary.+(tom)//println(mary hangOutWith tom)

  //ALL OPERATORS IN SCALA ARE METHODS.
  println(1 + 2)
  println(1.+(2))


  //PREFIX NOTATION
  val x = -1 //equivalent with  1.unary_-
  val y = 1.unary_- // - Operators are actually unary methods
  //unary_ prefix only works with - + ~ !
  println(!mary) // Call Unary methods unary_!
  println(mary.unary_!)

  //POSTFIX NOTATION : Only applicable for methods which do not have any parameters
  // POSTFIX notation is rarely used
  println(mary.isAlive)
  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary()) // Can call mary as is if it function because of apply method

  //---------------EXERCISE---------------
  /*
    1. Overload the + Operator
      may + "the rockstar" => new person "Mary (the rockstar)"

    2. Add an age to the Person class
      Add a unary + Operator => new person with the age + 1
      + mary => mary with the age incrementor

    3. Add a "learns" method in the person Class => Mary learns Scala
       Add a learnsScala methods, calls learns method with "Scala"
       Use it in postfix notation

     4. Overload the apply method
        mary.apply(2) => "Mary watched Inception 2 times "

   */

  //1.
  println((mary + "The Rockstar") ())
  //2.
  println((+mary).age)
  //3.
  println(mary learnsScala) //mary.learnsScala
  //4.
  println(mary(2))
}
