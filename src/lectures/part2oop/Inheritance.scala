package lectures.part2oop

object Inheritance extends App {

  // Scala has SINGLE CLASS INHERITANCE
  // subclass only inherits NON PRIVATE MEMBERS of super class

  class Animal {
    protected def eat = println("Animal: nomnom")

    val creatureType = "Wild"
  }

  class cat extends Animal

  val cat = new Animal {
    def crunch = {
      eat
      println("Cat: crunch crunch ")
    }
  }
  //cat.eat// Can not be called if class defination is private or protected
  cat.crunch

  // Constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  // Before defining constructor of Adult we need to call constructor of Person hence Person defination needs to be given with extends as below
  class Adult(name: String, age: Int, idCard: Int) extends Person(name, age)
  // We can use Auxilary COnstructor of Super class if needed as below
  //class Adult(name:String,age:Int, idCard:Int) extends Person(name)


  // Overriding
  class Dog(override val creatureType: String) extends Animal {
    override def eat: Unit = println("Dog: Crunch Crunch")
    //override val creatureType: String = "Domestic"
    // Above statement can be overwritten directly in constructor
  }

  //val dog = new Dog
  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  //TYPE Substitution (brod: Polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  println(unknownAnimal.creatureType) // It will use K9 i.e. overridden value
  // call goes to most overridden value

  // OVERRIDING vs OVERLOADING

  // SUPER
  // super.eat will call method from super class

  //preventing override
  // 1. user final on member
  // 2. final can be used on class and that class cannot be extended
  // 3. sealed:   Seal the class= extend class in this file, prevent extension in other files
  // Numerical and string class in scala are final

}
