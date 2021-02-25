package unit13

import akka.actor._

class Kenny extends Actor {
  println(s"${self.path}")

  override def receive: Receive = {
    case _ => println("kenny received a message")
  }
}

class ParentD extends Actor {
  val kenny: ActorRef = context.actorOf(Props[Kenny], name = "Kenny")
  context.watch(kenny)

  override def receive: Receive = {
    case Terminated(kenny) => println("OMG, they killed Kenny")
    case _ => println("Parent received a message")
  }
}

object MonitorActor extends App {
  val sys = ActorSystem("DeathWatchTest")
  val p = sys.actorOf(Props[ParentD], name = "Parent")
  val kenny = sys.actorSelection("akka://DeathWatchTest/user/Parent/Kenny")
  kenny ! PoisonPill

  Thread.sleep(5000)
  println("calling system.shotdown")

  System.exit(1)
}
