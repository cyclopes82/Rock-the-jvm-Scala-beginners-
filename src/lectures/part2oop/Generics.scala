package lectures.part2oop

object Generics extends App {
  // [A] denotes generic type
  class MyList[A] {
    // use the type A
  }

  val listOfInteger = new MyList[Int] // Integer list from Generic MyList
  val listOfStrings = new MyList[String] //String List from Generic MyList

  class MyMap[Key, value] // Two Generic Types

  // generic methods
  // Objects can not be type parametrised
  object MyList{
    def empty[A]:MyList[A] = ??? // How to define generic method
  }
  val emptyListOfInteger = MyList.empty[Int]

  // Variance Problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal
  // Question is if Cat extends Animal then does List[Cat] also extends List[Animal]
  // There are three possible answers
  //1. yes, List[Cat] extends List[Animal] = Covariance
  class CovariantList[+A]
  val animal :Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
    // animalList.add(new Dog) ??? HARD QUESTION because Dog is animal and hence should be part of Animal list but
    // is not a cat and hence can pollute the list of cat
    // Adding a Dog in a list of cat will make it a list of Animal

  //2. No list[Cat] and List[Animal] are two different things == INVARIANCE
  class InvariantList[A]
  // Below functionality cannot be implemented
  //val InvariantAnimalList: InvariantList[Animal] = new InvariantList[Cat]
  val InvariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  //3. Hell, No! CONTRAVARIANCE
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] =  new ContravariantList[Animal]

  class Trainer[-A]
  val trainer: Trainer[Cat] =  new Trainer[Animal]


  //Bounded Types
  class cage[A <: Animal](animal:A)  // <: means subtype of Animal >: Supertype of Animal
  val cage = new cage(new Dog)

  class Car // Below statement won't run because car is not a subtype of Animal
 // val newCage = new cage(new Car)

  class MyList1[+A]{
    // below definition gives error covariant type A occurs in contravariant position in type A of value element
    // above mentioned error is technical version of HARD question we asked earlier
    //def add(element:A): MyList1[A]= ???
    def add[B >: A](element:B):MyList1[B] = ???
    /*
    A = Cat
    B = Animal
     */
  }

  /* ------------------------ EXERCISE----------------------*/
  // 1. Expand MyList to be Generic


}
