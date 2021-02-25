package unit13

import akka.actor._

case object ForceRestart

class LifeCycle extends Actor {
  println("entered the LifeCycle constructor")

  override def preStart() = {
    println("LifeCycle: preStart")
  }

  override def postStop(): Unit =
    println("LifeCycle: postStop")

  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    println("LifeCycle: preRestart")
    println(s"MESSAGE:${message.getOrElse("")}")
    println(s"REASON:${reason.getMessage}")
    super.preRestart(reason, message)
  }

  override def postRestart(reason: Throwable): Unit = {
    println("LifeCycle: postRestart")
    println(s"REASON:${reason.getMessage}")
    super.postRestart(reason)
  }

  override def receive: Receive = {
    case ForceRestart => throw new Exception("Boom!")
    case _ => println("LifeCycle received a message")
  }
}

object ActorLifeCycle extends App {

  val actorS = ActorSystem("LifecycleDemo")
  val cycle = actorS.actorOf(Props[LifeCycle], name = "lifecycle")
  println("-----sending a simple string message")
  cycle ! " hello"
  Thread.sleep(1000)
  println("-----make restart")
  cycle ! ForceRestart

  Thread.sleep(1000)

  println("-----stopping cycle")
  actorS.stop(cycle)

  //  actorS.shutdown
  System.exit(1)

}
