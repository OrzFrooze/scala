package unit1

import scala.collection.mutable


class Markerr private (val color:String){
  println(s"Create ${this}")

  override def toString = s"marker color $color"
}

object Markerr {
  private val markers = mutable.Map(
    "red"->new Markerr("red"),
    "blue"-> new Markerr("blue"),
    "yellow"-> new Markerr("yellow")
  )

  def getMarker(color:String):Markerr = {
    markers.getOrElseUpdate(color,new Markerr(color))
  }
}

object StandaloneObj extends App{


  val m = Markerr.getMarker("blue")
  val n = Markerr.getMarker("blue")
  println(m==n)
  println(Markerr.getMarker("blue"))
  println(Markerr.getMarker("blue"))
}