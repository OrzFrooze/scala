package unit10

object MapDemo {

  def test() = {
    val m = Map("fname" -> "wu", "lname" -> "hu")
    m.foreach(x => print(s"${x._1}->${x._2}"))
  }

  def main(args: Array[String]): Unit = {
    test();
  }
}
