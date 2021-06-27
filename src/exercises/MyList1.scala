package exercises

abstract class MyList {
  /*
      head = first element of the list
      tail = remainder of the list
      isEmpty = is this list empty
      add(int) => new list with the element added
      toString => a String representation of the list
   */
  def head:Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element:Int):MyList
  def printElements:String
  override def toString: String = "[" + printElements + "]"
  }

object Empty extends MyList{
  def head:Int = throw new NoSuchElementException // Crash the Program
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element:Int):MyList = new Cons(element,Empty)
  override def printElements: String = ""
}

class Cons(h:Int, t: MyList) extends MyList{
  def head:Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element:Int):MyList = new Cons(element,this)

  override def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }
}

object ListTest extends App{
  val list = new Cons(1, Empty)
  println(list.head)
  println(list.tail.isEmpty)
  println(list.isEmpty)
  println(list.add(2).head)

  val list1 = new Cons(1, new Cons(2, new Cons(3, new Cons(4, Empty))))
  println(list1.tail.head)
  println(list1.printElements)


}