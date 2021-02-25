package unit13

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object FutureDemo extends App {
  implicit val baseTime = System.currentTimeMillis()

  val f = Future {
    Thread.sleep(500)
    1 + 1
  }
  val result = Await.result(f, Duration(2000, "millis"))
  println(result)
  Thread.sleep(1000)
}
