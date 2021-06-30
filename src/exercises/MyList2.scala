package exercises

import scala.runtime.Nothing$

/*
  1. Generic trait MyPredicate[T] with little methods test(T) =>Boolean
  2. generic trait MyTransformer [A,B] with method transform(A) => B
  3. MyList:
        -map(transformer) => MyList
        -filter(predicate) => MyList
        -flatMap[transformer from A to MyList[B]) =>MyList[B])

      class  EvenPredicate extends MyPredicate[Int]
      class  StringToIntTransformer extends MyTransformer[String,Int]

      [1,2,3].map(n * 2) = [2,4,6]
      [1,2,3].filter(n % 2) = [2,4]
      [1,2,3].flatMap(n , n+1= [2,4,6]

 */
abstract class MyList2[+A] {
  /*
      head = first element of the list
      tail = remainder of the list
      isEmpty = is this list empty
      add(int) => new list with the element added
      toString => a String representation of the list
   */
  def head: A

  def tail: MyList2[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList2[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): MyList2[B]

  def flatMap[B](transformer: MyTransformer[A, MyList2[B]]): MyList2[B]

  def filter(predicate: MyPredicate[A]): MyList2[A]

  //Concatenation
  def ++[B >: A](list: MyList2[B]): MyList2[B]
}

// Nothing is proper substitute of anything
object Empty2 extends MyList2[Nothing] {
  def head: Nothing = throw new NoSuchElementException // Crash the Program

  def tail: MyList2[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): MyList2[B] = new Cons2(element, Empty2)

  override def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): MyList2[B] = Empty2

  def flatMap[B](transformer: MyTransformer[Nothing, MyList2[B]]): MyList2[B] = Empty2

  def filter(predicate: MyPredicate[Nothing]): MyList2[Nothing] = Empty2

  def ++[B >: Nothing](list: MyList2[B]): MyList2[B] = list
}

class Cons2[+A](h: A, t: MyList2[A]) extends MyList2[A] {
  def head: A = h

  def tail: MyList2[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyList2[B] = new Cons2(element, this)

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
  def map[B](transformer: MyTransformer[A, B]): MyList2[B] = {
    new Cons2(transformer.transform(h), t.map(transformer))
  }


  /*
    [1,2,3].filter ( n % 2 == 0)=
      [2,3].filter(n % 2 == 0) =
       new Cons(2, [3].filter(n%2 == 0))
       = new Cons(2, Empty.filter(n % 2 == 0))
       = new Cons(2,Empty)
   */
  def filter(predicate: MyPredicate[A]): MyList2[A] = {
    if (predicate.test(h)) new Cons2(h, t.filter(predicate))
    else t.filter(predicate)
  }

  /*
    [1,2] ++ [3,4 5]
      = new Cons(1, [2] ++ [3,4 5]
      = new Cons(1, new Cons( 2, Empty ++ [3,4 5]))
      = new Cons(1, new Cons(2, new Cons(3, new Cons(4,new Cons(5)))))
   */
  def ++[B >: A](list: MyList2[B]): MyList2[B] = new Cons2(h, t ++ list)

  /*
    [1,2].flatMap(n => [n,n+1]
      = [1,2] ++ [2].flatMap(n => [n,n+1]
      = [1,2] ++ [2,3]  ++ Empty.flatMap(n => [n,n+1]
      = [1,2] ++ [2,3] ++ Empty
   */

  def flatMap[B](transformer: MyTransformer[A, MyList2[B]]): MyList2[B] = {
    transformer.transform(h) ++ t.flatMap(transformer)
  }


}


trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}

object ListTest2 extends App {
  //  val listOFInteger:MyList[Int] = Empty
  //  val listOfString:MyList[String] = Empty

  val listOFInteger: MyList2[Int] = new Cons2(1, new Cons2(2, new Cons2(1, new Cons2(4, Empty2))))
  val anotherListOFInteger: MyList2[Int] = new Cons2(4, new Cons2(5, Empty2))

  val listOfString: MyList2[String] = new Cons2("Hello", new Cons2("Scala", Empty2))

  println(listOfString.toString)
  println(listOFInteger.toString)

  // This anonymous class
  println(listOFInteger.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }).toString)

  println(listOFInteger.filter(new MyPredicate[Int] {
    override def test(elem: Int): Boolean = elem % 2 == 0
  }))

  println((listOFInteger ++ anotherListOFInteger).toString)

  println(listOFInteger.flatMap(new MyTransformer[Int, MyList2[Int]] {
    override def transform(elem: Int): MyList2[Int] = new Cons2[Int](elem,new Cons2(elem + 1, Empty2))
  }).toString)
}
