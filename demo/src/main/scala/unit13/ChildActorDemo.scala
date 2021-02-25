package unit13

import akka.actor._

case class CreateChild(name: String)

case class Name(name: String)

class Child extends Actor {
  var name = "no name"

  override def postStop {
    println(s"The kill me ($name):${self.path}")
  }

  override def preStart(): Unit = {
    println(s"path--${self.path}")
    super.preStart()
  }

  override def receive = {
    case Name(name) => this.name = name
      println(s"child receive $name")
    case _ => println(s"Child $name got message")
  }
}

class Parent extends Actor {
  override def receive: Receive = {
    case CreateChild(name) =>
      println(s"Parent about to create Child($name) ...")
      val child = context.actorOf(Props[Child], name = s"$name")
      child ! Name(name)
    case _ => println(s"Parent got some other message")

  }
}

object ChildActorDemo extends App {
  val a = ActorSystem("ParentChild")
  val p = a.actorOf(Props[Parent], name = "parent")
  p ! CreateChild("WH")
  p ! CreateChild("sss")

  Thread.sleep(500)
  val wh = a.actorSelection("akka://ParentChild/user/parent/sss")
  wh ! PoisonPill // 发送终结信号
  Thread.sleep(5000)
  System.exit(1)
}
