package unit12

import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}

@SerialVersionUID(100L)
class Person(var name: String, val age: Int) extends Serializable {
  override def toString: String = s"$name--$age"
}

/**
 * 序列化demo
 */
object SerialDemo {

  def main(args: Array[String]): Unit = {
    val p = new Person("wh", 12)

    val oss = new ObjectOutputStream(new FileOutputStream("persion"))
    oss.writeObject(p)
    oss.close();

    val ois = new ObjectInputStream(new FileInputStream("persion"))
    val pp = ois.readObject().asInstanceOf[Person]
    ois.close()
    println(pp)

  }
}
