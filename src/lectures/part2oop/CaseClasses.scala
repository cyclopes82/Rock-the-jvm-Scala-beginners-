package lectures.part2oop

object CaseClasses extends App{

  /*
      equals, hashcode, toString
   */

  case class Person(name:String,age:Int)

  /*
  1. Class parameters are promoted to fields
   */
  val jim = new Person("Jim",34)
  println(jim.name)
  /*
  2. Sensilble to String
   */
  println(jim.toString)
  println(jim) //println(instance) = println(instance.toString)// Syntactic sugar

  /*
  3. equals and hasCode implemented OOTB. USeful while working with Collection
   */
  val jim2 = new Person("Jim",34)
  println(jim == jim2)
  /*
  4. Case Classes have handy Copy Method
   */
  val jim3 = jim.copy()
  val jim4 = jim.copy(age = 45)

  /*
  5. CCs have companion Objects
   */
  val thePerson = Person
  val mary = Person("Mary",23)

  /*
   6. CCs are Serializable
   */
  /*
  7. CSs have extractor Pattern = CCs can be used in PATTERN MATCHING
   */

  // Case Objects are same as case classes except it doesn't have companion Object as it is an object
  case object UnitedKingdom{
    def name:String = "The UK of GB and NI"
  }

  //---------------------------------Exercise-------------
  /*
        Expand MyList2 - Use case classes and case Objects
   */


}
