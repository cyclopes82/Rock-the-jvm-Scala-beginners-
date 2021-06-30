package lectures.part2oop

object AnonymousClasses extends App {

    abstract class Animal{
      def eat: Unit
    }

  //AnonymousClass
  val funnyAnimal:Animal = new Animal {
    override def eat: Unit = println("HAHAHAHAHAH")
  }
  // Above pattern looks like it has instantiated abstract class but in actual it created AnonymousClasses$$anon$1 class
  println(funnyAnimal.getClass)
  //Its backend implementation  is
/*  class AnonymousClasses$$anon$1 extends Animal{
    override def eat: Unit = println("HAHAHAHAHAH")
    val funnyAnimal:Animal  = new AnonymousClasses$$anon$1
  }*/

  class person(name:String){
    def sayHi:Unit = println(s"Hi, my name is $name, how can I help?")
  }

  val Jim = new person("Jim") { //Give implementation of constructor
    override  def sayHi:Unit = println(s"Hi, my name is Jim. I don't want to help")
  }

  // Anonymous classes works for both abstact and non abstract classes
}
