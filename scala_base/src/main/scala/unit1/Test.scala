package unit1

import scala.beans.BeanProperty

class Car(val year: Int) {
  private var milesDriven: Int = 0

  def miles: Int = milesDriven

  def drive(distance: Int): Unit = {
    milesDriven += Math.abs(distance)
  }
}

class Person(var name: String, var age: Int);

class Pig(val name: String, val age: Int);

class Pizze(var size: Int, var len: String) {
  def this(size: Int) { //辅助构造器   通过辅助构造器实现不同参数的构造函数
    this(size, "")
  }
}

class Dude(@BeanProperty val firstName:String,val lastName:String){//生成javabean风格的访问器
  @BeanProperty val position:String = ""
}

object Test {


  def classTest(): Unit = {
    val car = new Car(2001);
    println(s"Car made in year ${car.year}")
    println(s"miles driven ${car.miles}")
    car.drive(10)
    println(s"miles driven ${car.miles}")

    val p = new Person("wuhg", 19)
    println(s"${p.name}--${p.age}")
    p.name = "edit"
    println(s"${p.name}--${p.age}")

    ls()

    val g = new Pig("sssss", 10)
    println(s"${g.name}--${g.age}")

  }

  def max(values: Int*): Int = {
    values(0)
  }

  def list(): Unit = {
    var list = List()

  }

  def getInfo() = {
    ("aaa", "bbb", "cccc")
  }

  def mail(mailClass: String = "first", des: String = "s"): Unit = {
    println(s" $mailClass $des")
  }

  def javaArray(): Unit = {
    val a: Int = 10
    val list = new java.util.ArrayList[String]
    list.ensureCapacity(a)
    list.add("sfsf")
    list.add("222")
    list.add("232")
    list.forEach(println)
  }

  def ls() = println("=============")

  def main(args: Array[String]): Unit = {
    val value = List(1, 2, 3, 4, 5)
    value.map(println)
    val name = "teshi"
    println(s"hello world $name")
    for (i <- 1 until 3) println(s"$i c")
    println("-------------")
    (1 to 3).foreach(println)
    println("-------")
    javaArray()
    ls
    val (a, b, c) = getInfo()
    println(s"$a $b $c")
    ls
    classTest()
  }
}
