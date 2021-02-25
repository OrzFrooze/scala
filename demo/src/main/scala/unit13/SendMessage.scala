package unit13

import akka.actor._

case object PingMessage

case object PongMessage

case object StartMessage

case object StopMessage


class Ping(pong: ActorRef) extends Actor {
  var count = 0

  def incrementAndPrint: Unit = {
    count += 1
    println("ping")
  }

  override def receive: Receive = {
    case StartMessage =>
      incrementAndPrint
      pong ! PingMessage

    case PongMessage =>
      incrementAndPrint
      if (count > 99) {
        sender ! StopMessage
        println("ping stopped")
        context.stop(self)
      } else {
        sender ! PingMessage
      }
    case _ => println("Ping got something unexpected.")
  }
}

class Pong extends Actor {
  override def receive: Receive = {

    case PingMessage =>
      println("pong")
      sender ! PongMessage
    case StopMessage =>
      println("pong stopped!")
      context.stop(self)
    case _ => println("Pong got something unexpected.")
  }
}

object SendMessage extends App {
  val actorSystem = ActorSystem("PingPongSystem")
  val pong = actorSystem.actorOf(Props[Pong], name = "pong")
  val ping = actorSystem.actorOf(Props(new Ping(pong)), name = "ping")
  ping ! StartMessage
}
