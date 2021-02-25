package demo1

import scala.beans.BeanProperty

//当类名太长的时候，可以通过type来定义别名
class PoliceOffice(val name: String)

//------------javaBean风格-----------------
//生成javaBean风格，使用get/set方法访问属性
class Dude(@BeanProperty val firstName: String, val lastName: String) {
  @BeanProperty var position: String = _
}

//-----------------------------------------

class Person(val firstName: String, val lastName: String) {
  var position: String = _

  println(s"Creating $toString")

  //辅助构造器
  def this(firstName: String, lastName: String, positionHeld: String) {
    this(firstName, lastName)
    position = positionHeld
  }

  override def toString: String = {
    s"$firstName $lastName holds $position position"
  }
}

//----------------参数化类----------------

class Message[T](val content: T) {
  override def toString: String = s"message content is $content"

  def is(value: T): Boolean = value == content
}

//--------------------------------------
object Demo1 {


  //----------------参数化类型----------------

  def echo[T1, T2](input1: T1, input2: T2) = {
    println(s"got $input1 (${input1.getClass}) $input2 (${input2.getClass})")
  }

  val msg1: Message[String] = new Message[String]("sfs")
  val ms2 = new Message(42)
  println(msg1, ms2, msg1.is("sss"), msg1.is("444"), ms2.is(2))

  //----------------------------------------


  def main(args: Array[String]): Unit = {
    val john = new Person("John", "Smith", "alasdf")
    println(john)
    val bean = new Dude("ssss", "xxxx")

    type Po = PoliceOffice

    val c = new Po("sdfsf")
    println(c.getClass)
    echo(c, "hell")
  }
}




