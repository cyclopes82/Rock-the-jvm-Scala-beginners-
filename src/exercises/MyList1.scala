package exercises

import scala.runtime.Nothing$

abstract class MyList1[+A] {
  /*
      head = first element of the list
      tail = remainder of the list
      isEmpty = is this list empty
      add(int) => new list with the element added
      toString => a String representation of the list
   */
  def head:A
  def tail: MyList1[A]
  def isEmpty: Boolean
  def add[B>:A](element:B):MyList1[B]
  def printElements:String
  override def toString: String = "[" + printElements + "]"
  }

// Nothing is proper substitute of anything
object Empty1 extends MyList1[Nothing]{
  def head:Nothing = throw new NoSuchElementException // Crash the Program
  def tail: MyList1[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add [B >: Nothing](element:B):MyList1[B] = new Cons1(element,Empty1)
  override def printElements: String = ""
}

class Cons1[+A](h:A, t: MyList1[A]) extends MyList1[A]{
  def head:A = h
  def tail: MyList1[A] = t
  def isEmpty: Boolean = false
  def add[B>:A](element:B):MyList1[B] = new Cons1(element,this)

  override def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }
}

object ListTest1 extends App{
//  val listOFInteger:MyList[Int] = Empty
//  val listOfString:MyList[String] = Empty

 val listOFInteger:MyList1[Int] = new Cons1(1, new Cons1(2, new Cons1(1,new Cons1(4,Empty1))))
 val listOfString:MyList1[String] = new Cons1("Hello", new Cons1("Scala",Empty1))

  println(listOfString.toString)
  println(listOFInteger.toString)
}
