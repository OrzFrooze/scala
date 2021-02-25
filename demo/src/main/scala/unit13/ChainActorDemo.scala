package unit13

import akka.actor._
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration
import scala.concurrent.duration.Duration
import scala.language.postfixOps

case object AskNameMessage

class TestActor extends Actor {
  override def receive: Receive = {
    case AskNameMessage =>
      sender ! "Fred"
    case _ => println("that was unexpected.")
  }
}

object ChainActorDemo extends App {
  val system = ActorSystem("AskTestSystem")
  val myActor = system.actorOf(Props[TestActor], name = "myActor")
  //this is one way to "ask" another actor for information
  implicit val timeout: Timeout = Timeout(Duration(5000, "millis"))

  val future = myActor ? AskNameMessage
  val result = Await.result(future, timeout.duration).asInstanceOf[String]
  println(result)
  // a slightly different way to ask another actor for information

  val future2: Future[String] = ask(myActor, AskNameMessage).mapTo[String]
  val result2 = Await.result(future2, Duration(1000, "millis"))
  println(result2)

  System.exit(1)
}
