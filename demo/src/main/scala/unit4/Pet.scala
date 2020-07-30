package unit4

abstract class Pet(name: String) {
  val greeting: String;
  var age: Int;

  def action: String;

  def sayHello {
    println(greeting)
  }

  override def toString: String = s"I say $greeting, and I'am $age"
}

class Dog(name: String) extends Pet(name) {
  val action = "yaoayo"
  override val greeting: String = "Woof"
  override var age: Int = 2;
}

class Cat(name: String) extends Pet(name) {
  val action = "naonao"
  override val greeting: String = "Mo mo"
  override var age: Int = 12
}


object AbstractFieldsDemo extends App {
  val dog = new Dog("Dog")
  val cat = new Cat("cat")
  dog.sayHello
  cat.sayHello
  println(dog.action)
  println(cat.action)
  println(dog)
  println(cat)
}