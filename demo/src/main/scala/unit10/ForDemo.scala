package unit10

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

  def main(args: Array[String]) = {
    //    forList();
    //    println("\n----")
    //    forYield();
    //    flattmap()
    //    takeWhileDemo();
    groupByDemo
  }
}
