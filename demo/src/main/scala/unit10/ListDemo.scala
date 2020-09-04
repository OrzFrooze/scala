package unit10

import scala.collection.mutable.ArrayBuffer

object ListDemo {
  def isEven(i: Int) = if (i % 2 == 0) true else false

  def test() = {
    var fruits = ArrayBuffer[String]()
    fruits.addOne("orange");
    fruits.addOne("apple");
    fruits.addOne("banana");
    fruits += "4";
    println(fruits)
    fruits -= "apple"
    println(fruits)
    fruits.foreach(i => print(i + ";"))
  }


  def unzipDemo() = {

  }

  def main(args: Array[String]): Unit = {
    //    val list = List.range(1, 10)
    //    var l2 = for {
    //      e <- list
    //      if e % 2 == 0
    //    } yield e
    //
    //    println(list, l2)
    test()
  }
}
