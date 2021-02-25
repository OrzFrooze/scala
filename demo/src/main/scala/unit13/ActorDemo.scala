package unit13

import akka.actor._

class ActorDemo extends Actor {
  override def receive: Receive = {
    case "hello" => println("this is hell")
    case _ => println("huhu?")
  }
}

object ActorDemo {

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("helloSystem")
    val actorDemo = system.actorOf(Props[ActorDemo], name = "actordemo")

    actorDemo ! "hello"
    actorDemo ! "sss"
  }
}

