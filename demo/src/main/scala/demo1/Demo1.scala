package demo1

class Person(val firstName: String, val lastName: String) {
  var position: String = _

  println(s"Creating $toString")

  def this(firstName: String, lastName: String, positionHeld: String) {
    this(firstName, lastName)
    position = positionHeld
  }

  override def toString: String = {
    s"$firstName $lastName holds $position position"
  }
}

object Demo1 {
  def main(args: Array[String]): Unit = {
    val john = new Person("John", "Smith", "alasdf")
    println(john)
  }
}


