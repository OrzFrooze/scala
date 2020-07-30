package unit6

class PrivateObject {
  private[this] val name = 2
  private var length =11

  def getName = {
    this.name
  }
}

object PrivateObject {
  private[this] val age = 12
  private var length = 14

  def getName(foo: PrivateObject) = {
    println(foo)
  }

  def getAge = this.age

  def main(args: Array[String]): Unit = {
    val c = new PrivateObject
    PrivateObject.length =15
    println(c.getName, PrivateObject.getAge,PrivateObject.length,c.length)

    echo(1,2,"sdf",Array())
    echo(Margin.BOTTOM)
  }
}