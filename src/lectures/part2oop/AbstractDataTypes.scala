package lectures.part2oop

object AbstractDataTypes extends App {
  // abstract : Classes which contain unimplemented or abstract fields or methods
  abstract class Animal {
    val creatureType: String

    def eat: Unit
  }
  // abstract class can not be instantiated  e.g.
  // val animal = new Animal

  class Dog extends Animal {
    override val creatureType: String = "K9"

    override def eat: Unit = println("Dog: Crunch Crunch")
  }

  //traits
  trait Carnivore{
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType = "croc"

    def eat: Unit = println("Crocodile: NomNom")

    override def eat(animal: Animal): Unit = println(s"I am croc and I'm eating ${animal.creatureType}")
  }

  val Dog = new Dog
  val Croc = new Crocodile
  Croc.eat(Dog)
 //traits vs abstract classes
  // 1 - traits do not have constructor parameters
  // 2 - Multiple traits may be inherited by the same class
  // 3 - traits = Behaviour, abstract class is a thing

}
