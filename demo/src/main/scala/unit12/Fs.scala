package unit12

import java.io.{BufferedWriter, File, FileWriter, PrintWriter}
import java.sql.{Connection, DriverManager}

import scala.io.Source

/**
 * 文件读写操作
 */
object Fs {

  def using[A <: {def close(): Unit}, B](resouce: A)(f: A => B): B = try {
    f(resouce)
  } finally {
    resouce.close()
  }

  def readTextFile(fileName: String): Option[List[String]] = {

    try {
      val lines = using(io.Source.fromFile(fileName)) {
        source => (for (line <- source.getLines) yield line).toList
      }
      Some(lines)
    }
    catch {
      case e: Exception => {
        println(e)
        None
      }
    }
  }

  def test() {
    val fileName = "/src/main/scala/unit12/a.txt"
    var root = System.getProperty("user.dir")
    println(root)
    val source = Source.fromFile(root + fileName)
    for (line <- source.getLines()) {
      println(line)
    }
    source.close()
  }

  def writeFile(): Unit = {
    //printwriter
    val pw = new PrintWriter(new File("E://1.txt"))
    pw.write("hello ,world")
    pw.close()
    //filewriter
    val file = new File("E://2.txt")
    val bw = new BufferedWriter(new FileWriter(file))
    bw.write("adsfafadf,2342\n,agadsad")
    bw.close()
  }

  def test1() {
    val r = readTextFile("E:/a.txt")
    r.foreach(s => s.foreach(println))
    r.foreach(println)
  }

  def JDBC() = {
    val url = "jdbc:mysql://10.130.10.30:3306/smap_toll_20200714"
    val driver = "com.mysql.cj.jdbc.Driver"
    val user = "root"
    val password = "Navinfo1!"


    try {
      Class.forName(driver)
      val conn = DriverManager.getConnection(url, user, password)

      var sql = "select count(*) from sc_toll_rdlink_bt"
      var statement = conn.createStatement
      val rs = statement.executeQuery(sql)
      while (rs.next){
        println(rs.getInt(0))
      }
    } catch {
      case e: Exception => {
        e.printStackTrace
      }
    }
  }

  def main(args: Array[String]): Unit = {
    //    test()
//    test1()
//    writeFile()
    JDBC()
  }
}
