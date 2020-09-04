package unit10

import scala.collection.mutable.Queue

object ForDemo {
  def forList() = {
    val s = Array("a", "b", "c", "d")
    for (a <- s) {
      print(a.toUpperCase + ",")
    }
    println("\n----")

    for (i <- 0 until s.size) {
      print(s(i).toUpperCase + ",")
    }
    println("\n----")
    for ((e, v) <- s.zipWithIndex) {
      print(s"${e}->${v},")
    }
    println("\n----")
    for ((e, v) <- s.view.zipWithIndex) {
      print(s"${e}->${v},")
    }
    println("\n----")
    for ((e, v) <- s.view.zip(Stream from 1)) {
      print(s"${e}->${v},")
    }
  }

  /**
   * 有返回值的for循环
   */
  def forYield() = {
    val arr = Array("a", "b", "c", "d", "e")
    val n = for (s <- arr) yield {
      val k = s.toUpperCase
      k
    }

    n.foreach(print)
  }

  def flattmap() = {
    val v = Array(1, 2, 3, 4, 5, 6)
    val c = v.flatMap(i => {
      val r = i + "$"
      r
    })
    //    c.foreach(c)
    println(v)
  }

  def takeWhileDemo(): Unit = {
    val a = List(1, 2, 3, 4, 4, 5, 5, 6)
    val b = a.takeWhile(_ < 5)
    //    println(b[true])
  }

  def groupByDemo(): Unit = {
    val list = List(131, 2, 14, 235, 13, 21, 53, 363)
    val a = list.groupBy(_ > 100)

    println(a, a(true), a(false))
    val b = list.partition(_ > 100)
    val (aa, bb) = list.partition(_ > 100)
    println(b)
    println(aa, bb)

    val c = list.span(_ < 100)

    println(c)
    val d = list.splitAt(3)
    println(d)
  }

  def unzipDeom() = {
    val list = List(("a", "b"), ("c", "d"), ("e", "f"));
    val (a, b) = list.unzip
    println(a, b)
  }

  def zipDemo() = {
    val women = List("Kim", "Julia", "fuck", "life")
    val men = List("Al", "Terry", "3")
    val list = women zip men;
    println(list)
  }

  //返回一个值
  def reduceDemo() = {
    val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val b = arr.reduceLeft((a, b) => a + b)
    val c = arr.reduceLeft(_ min _)
    val d = arr.reduceRight(_ max _)
    val e = arr.reduceLeft((a, b) => {
      var c = 0;
      if (a > b) c = a else c = b
      c
    })
    println(b, c, d, e, 333)
  }

  //接受一个初始值
  def foldDemo() = {
    var a = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
    var b = a.foldLeft(20)(_ + _)
    println(b)
  }

  //返回一个序列
  def scanDemo() = {
    var a = Array(1, 2, 3, 4, 5)
    var b = a.scanLeft(10)((a, b) => {
      val r = a * b;
      r
    })
    println(b.mkString(","))
    //    b.foreach(println)
  }

  def diffDemo() = {
    val a = Array(1, 2, 3, 4, 11, 12, 4, 3)
    val b = Array(6, 5, 7, 3, 8)
    val c = a.toSet diff b.toSet
    println(c)
  }

  def sortWithDemo() = {
    var a = List("banana", "pear", "apple").sortWith((a, b) => {
      a.length > b.length
    })
    println(a)
  }


  def main(args: Array[String]) = {
    //    forList();
    //    println("\n----")
    //    forYield();
    //    flattmap()
    //    takeWhileDemo();
    //    groupByDemo
    //    unzipDeom
    //    zipDemo
    //    reduceDemo
    //    foldDemo
    scanDemo
    //    diffDemo
    sortWithDemo
    teex
    QueueDemo
  }

  def teex() = {
    println("sfsdfsf")
  }

  def QueueDemo() = {
    var ints = Queue[Int]()
    var k = None
    val q = Queue(1, 2, 3, 4, 5, 6)
    println(q.dequeue())

  }

}
