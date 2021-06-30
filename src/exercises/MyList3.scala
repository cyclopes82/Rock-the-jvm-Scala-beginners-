package exercises

import scala.runtime.Nothing$

/*
Expand MyList2 - Use case classes and case Objects

 */
abstract class MyList3[+A] {
  /*
      head = first element of the list
      tail = remainder of the list
      isEmpty = is this list empty
      add(int) => new list with the element added
      toString => a String representation of the list
   */
  def head: A
  def tail: MyList3[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList3[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
  def map[B](transformer: MyTransformer1[A, B]): MyList3[B]
  def flatMap[B](transformer: MyTransformer1[A, MyList3[B]]): MyList3[B]
  def filter(predicate: MyPredicate1[A]): MyList3[A]
  //Concatenation
  def ++[B >: A](list: MyList3[B]): MyList3[B]
}

// Nothing is proper substitute of anything
case object Empty3 extends MyList3[Nothing] {
  def head: Nothing = throw new NoSuchElementException // Crash the Program
  def tail: MyList3[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList3[B] = new Cons3(element, Empty3)
  override def printElements: String = ""
  def map[B](transformer: MyTransformer1[Nothing, B]): MyList3[B] = Empty3
  def flatMap[B](transformer: MyTransformer1[Nothing, MyList3[B]]): MyList3[B] = Empty3
  def filter(predicate: MyPredicate1[Nothing]): MyList3[Nothing] = Empty3
  def ++[B >: Nothing](list: MyList3[B]): MyList3[B] = list
}

case class Cons3[+A](h: A, t: MyList3[A]) extends MyList3[A] {
  def head: A = h
  def tail: MyList3[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList3[B] = new Cons3(element, this)
  override def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }

  /*
  [1,2,3].map(n *2)
    = new Cons(2, [2,3].map(n * 2)
    = new Cons(2, new Cons( 4, [3].map(n * 2)))
    = new Cons(2, new Cons(4, new Cons(6, Empty,map(n*2)))))
    = new Cons( 2, new Cons(4, new Cons(6, Empty))))
   */
  def map[B](transformer: MyTransformer1[A, B]): MyList3[B] = {
    new Cons3(transformer.transform(h), t.map(transformer))
  }


  /*
    [1,2,3].filter ( n % 2 == 0)=
      [2,3].filter(n % 2 == 0) =
       new Cons(2, [3].filter(n%2 == 0))
       = new Cons(2, Empty.filter(n % 2 == 0))
       = new Cons(2,Empty)
   */
  def filter(predicate: MyPredicate1[A]): MyList3[A] = {
    if (predicate.test(h)) new Cons3(h, t.filter(predicate))
    else t.filter(predicate)
  }

  /*
    [1,2] ++ [3,4 5]
      = new Cons(1, [2] ++ [3,4 5]
      = new Cons(1, new Cons( 2, Empty ++ [3,4 5]))
      = new Cons(1, new Cons(2, new Cons(3, new Cons(4,new Cons(5)))))
   */
  def ++[B >: A](list: MyList3[B]): MyList3[B] = new Cons3(h, t ++ list)

  /*
    [1,2].flatMap(n => [n,n+1]
      = [1,2] ++ [2].flatMap(n => [n,n+1]
      = [1,2] ++ [2,3]  ++ Empty.flatMap(n => [n,n+1]
      = [1,2] ++ [2,3] ++ Empty
   */

  def flatMap[B](transformer: MyTransformer1[A, MyList3[B]]): MyList3[B] = {
    transformer.transform(h) ++ t.flatMap(transformer)
  }


}


trait MyPredicate1[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer1[-A, B] {
  def transform(elem: A): B
}

object ListTest3 extends App {
  //  val listOFInteger:MyList[Int] = Empty
  //  val listOfString:MyList[String] = Empty

  val listOFInteger: MyList3[Int] = new Cons3(1, new Cons3(2, new Cons3(1, new Cons3(4, Empty3))))
  val anotherListOFInteger: MyList3[Int] = new Cons3(4, new Cons3(5, Empty3))

  val listOfString: MyList3[String] = new Cons3("Hello", new Cons3("Scala", Empty3))

  println(listOfString.toString)
  println(listOFInteger.toString)

  // This anonymous class
  println(listOFInteger.map(new MyTransformer1[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }).toString)

  println(listOFInteger.filter(new MyPredicate1[Int] {
    override def test(elem: Int): Boolean = elem % 2 == 0
  }))

  println((listOFInteger ++ anotherListOFInteger).toString)

  println(listOFInteger.flatMap(new MyTransformer1[Int, MyList3[Int]] {
    override def transform(elem: Int): MyList3[Int] = new Cons3[Int](elem,new Cons3(elem + 1, Empty3))
  }).toString)

  val ClonelistOFInteger: MyList3[Int] = new Cons3(1, new Cons3(2, new Cons3(1, new Cons3(4, Empty3))))
  println(listOFInteger == ClonelistOFInteger)
}
