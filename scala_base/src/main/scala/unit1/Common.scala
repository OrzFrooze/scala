package unit1

package object Common {
  def echo(any: Any*) = {
    any.foreach(e => println(e.getClass, e))
  }

  val MAGIC_NUM = 12

  object Margin extends Enumeration {
    type Margin = Value
    val TOP, BOTTOM, LEFT, RIGHT = Value
  }

  // type definition
  type MutableMap[K, V] = scala.collection.mutable.Map[K, V]
  val mutableMap = scala.collection.mutable.Map

}