package unit1

import scala.collection._

case class Marker(val color: String) {
  println(s"Creating ${this}")

  override def toString = s"marker color $color"
}

object MarkerFactory {
  private val markers = mutable.Map(
    "red" -> Marker("red"),
    "blue" -> Marker("blue"),
    "yellow" -> Marker("yellow")
  )


  def getMarker(color: String): Marker = markers.getOrElseUpdate(color, Marker(color))
}

object Singleton {
  def main(args: Array[String]): Unit = {
    println(MarkerFactory.getMarker("red"))
    println(MarkerFactory.getMarker("red"))
    println(MarkerFactory.getMarker("blue"))
    println(MarkerFactory.getMarker("blue"))
    println(MarkerFactory getMarker "green")
  }
}



