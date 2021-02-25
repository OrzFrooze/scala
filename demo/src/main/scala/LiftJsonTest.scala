import net.liftweb.json._
import net.liftweb.json.JsonAST
import net.liftweb.json.JsonDSL._

import net.liftweb.json.JsonAST.JValue
import net.liftweb.json.Serialization.write
import net.liftweb.json.{compactRender, prettyRender}

case class Person(name: String, address: Address) {
  var freieds = List[Person]()
}

case class Address(city: String, state: String)

object LiftJsonTest extends App {
  val p = Person("wh", Address("bj", "zh"))
  val p2 = Person("xx", Address("wh", "zh"))

  val f = List(p, p2)

  val l = Person("sx", Address("fs", "us"))
  l.freieds = f
  var json = List(1, 2, 3, 4, 5)

//    println(prettyRender())
  println()
  println(compactRender(json))

  implicit val formats = DefaultFormats
  //    val jsonString = write(p)
  //  println(jsonString)


  //  println(compactRender(JsonAST.render(json)))
}
