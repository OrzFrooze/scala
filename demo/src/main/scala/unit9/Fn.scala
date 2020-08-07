package unit9

import scala.collection.mutable.ArrayBuffer

object Fn {

  def main(args: Array[String]): Unit = {
    val x = List.range(1, 10)
    val even = x.filter((a: Int) => a % 2 == 0)
    val olo = x.filter(_ % 2 == 1)
    println(even, olo)
    //    x.foreach(println)

    var vector = Vector(1, 2, 3, 4, 5)
    println(vector.sum)
    println(vector.filter(_ < 3))
    println(vector.map(_ * 2), vector)
    println(vector.take(2),vector)

    vector = vector :+ 2
    println(vector,4)
    var a = new ArrayBuffer[Int]()
      a += 4
    a+= 5
     a ++= List(9,10)
    a+= (2,4,5,6)

    a --= Array(4)
    a.append(4)
    a.insert(0,23)
    a.prepend(2)

    println(a)
  }
}
