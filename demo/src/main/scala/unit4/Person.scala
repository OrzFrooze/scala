package unit4

case class Person(name: String, relation: String)


object Test extends App {
  val p = Person("wang", "didi")
  p match {
    case Person(n, r) => println(n, r)
  }
  println(p.name)
}