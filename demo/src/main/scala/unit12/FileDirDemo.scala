package unit12

import java.io.File

import scala.sys.process.Process
import scala.sys.process

object FileDirDemo {


  def getFileList(path: String): List[File] = {
    val dir = new File(path)
    if (dir.exists() && dir.isDirectory) {
      dir.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }

  def getListOfFies(dir: File, extension: List[String]): List[File] = {
    dir.listFiles().filter(_.isFile).toList.filter(file => {
      extension.exists(file.getName.endsWith(_))
    })
  }

  def getListOfSubDirectories(dir: File): List[String] = {
    dir.listFiles().filter(_.isDirectory).map(_.getName).toList
  }


  def main(args: Array[String]): Unit = {
    //    val v = getFileList("e://a.txt")
    //    val v = getListOfFies(new File("E://"), List("txt", "rar"))
    val v = getListOfSubDirectories(new File("E://"))
    println(v)
    val process = Process("dir E://").lazyLines
    process.foreach(println)
  }
}
