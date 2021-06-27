package lectures.part2oop

object Objects extends App {
  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY i.e.("Static")
  // It has object & class level functionality in java can be achieved like below
  // Object can have val, var or methods
  object Person {
    // "Static" / "Class" - Level Functionality
    val N_EYES = 2
    def canFly: Boolean = false
    // Companion object generally have factory method
    //def from(mother:Person,father:Person) = new Person("Bobbie")
    def apply(mother:Person,father:Person) = new Person("Bobbie") // factory method is named generally as apply
  }

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE. Object is its own type i.e Person plus it is its only instance
  val Mary = Person
  val John = Person
  // Below statement is true because Mary and John points to the same instance of Person
  println(Mary == John)

  class Person(name:String ="John"){
    // instance level-functionality
  }
  //COMPANIONS : Class and Object with same name in same scope

  // We can create two instance of class but not of object
  val Mary1 = new Person
  val John1 = new Person
  println(Mary1 == John1)

 // val bobbie = Person.from(Mary1,John1)
 //             OR
  //val bobbie = Person.apply(Mary1,John1)
  //            OR
 val bobbie = Person(Mary1,John1)

  // Scala Applications = Scala object with
  // def main(args:Array[String]):Unit
  // because scala application needs to be turned onto jvm application whose entry point needs to be static void main with an array of strings as para
  //
}
