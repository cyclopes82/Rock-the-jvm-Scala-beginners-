package lectures.part2oop

import java.io.Writer

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person) //lectures.part2oop.Person@7f416310
  println(person.age)
  println(person.x)
  println(person.greet("Daniel"))
  println(person.greet())
  //println(person.name) // This gives error as name is not val i.e. not a field

  //---------------EXERCISE---------------
  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)
  println(author.fullname)
  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter)) // author != imposter

  // Counter Exercise
  val counter = new Counter
  counter.print
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(5).print

}

//class definitions can sit at top level code
//Class: Organizes data and behavior(Code)
//instance : Concrete realization  in memory that is actual memory spaces that conform to the code and data structure that class defines
// Constructor
// Without val, name and age are class parameters but not member i.e. Class parameters are not Field
class Person(name: String, val age: Int) {
  //body : With every instancilization class body gets evaluated and hence println(1 + 3 ) will run with every new instance
  val x = 2 // These are Field
  println(1 + 3)

  //method

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name ")

  // OVERLOADING
  def greet(): Unit = println(s"Hi, I am $name")

  //Multiple Constructors OR Overloading Constructor
  def this(name: String) = this(name, 0) // Calling primary constructor

  def this() = this("John Doe")
  //Implementation of Auxiliary Constructor can only be another Constructor an nothing else
  // ***** THIS CAN BE EASILY SOLVED BY PROVIDING DEFAULT VALUES IN CONSTRUCTOR like below
  // class Person(name:String = "John D",val age:Int = 2)
}
//------------------ EXERCISES -------------------------

/**
 * Novel and a Writer
 * Writer: first Name, surname, year
 * - method fullname
 * Novel: name, year of release, author
 * - authorAge
 * - isWrittenBy(author)
 * - Copy (new year of release = new instance of Novel)
 *
 */
class Writer(firstname: String, surname: String, val year: Int) {
  def fullname = firstname + " " + surname
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge = year - author.year

  def isWrittenBy(author: Writer) = author == this.author

  def copy(newYear: Int) = new Novel(name, newYear, author)


}

/*
  Counter Class
    - received an Int value
    - method current Count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount
 */

class Counter(val count : Int = 0) {
  def inc ={
    println("incrementing")
    new Counter(count + 1) //immutability
      }
 // def inc(n: Int) = new Counter(count + n)
  // use below implementation alternatively
  def inc(n:Int):Counter = {
    if (n <= 0) this
    else inc.inc(n-1)
  }

  def dec = {
    println("Decrementing")
    new Counter(count - 1)
  }
  //def dec(n: Int) = new Counter(count - n)
  // USe below implementation alternatively
  def dec(n:Int):Counter ={
    if (n <= 0) this
    else dec.dec(n-1)
  }

  def print = println(count)

}

