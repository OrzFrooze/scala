package unit12

import scala.collection.mutable.ArrayBuffer
import io.Source

object FileDemo {

  def using[A <: {def close(): Unit}, B](resource: A)(f: A => B): B =
    try {
      f(resource)
    } finally {
      resource.close()
    }

  def readCSVDemo2() = {

    val rows = ArrayBuffer[Array[String]]()

    using(io.Source.fromFile("./import.csv")) { source =>
      for (line <- source.getLines) {
        rows += line.split(",").map(_.trim)
      }
    }

    //    for (row <- rows) {
    //      println(s"${row(0)}---${row(1)}")
    //    }

    var mm = collection.mutable.Map[Int, String]()

    using(io.Source.fromFile("./import.csv")) { source =>
      for ((line, count) <- source.getLines.zipWithIndex) {
        mm += (count -> line)
      }
    }
    for ((k, v) <- mm) {
      println(s"$k--$v")
    }
  }

  def readCSVdemo() = {
    val bufferedSource = io.Source.fromFile("./import.csv")
    //    for (line <- bufferedSource.getLines()) {
    //      val cols = line.split(",").map(_.trim())
    //      println(s"${cols(0)}---${cols(1)}")
    //    }
    //去掉首行
    for (line <- bufferedSource.getLines().drop(1)) {
      val Array(col1, col2) = line.split(",").map(_.trim())
      println(s"$col1---$col2")

    }
    bufferedSource.close()
  }

  //将字符串伪装为文件
  def readStringAsFile(str: String) {
    val s = Source.fromString(str)
    printLines(s)
  }


  def printLines(source: Source) {
    for (line <- source.getLines()) {
      println(line)
    }
  }



  def main(args: Array[String]) = {
    println(System.getProperty("user.dir"))
    //    readCSVdemo()
//    readCSVDemo2
    readStringAsFile("asdlkfajdf/adsg;jakgja/asgd")
  }
}
