package unit1

object EnumDemo extends Enumeration {
  type EnumDemo = Value

  val CNY, GBP, INR, JPY, NOK = Value
}

object Run {
  def commentOnPricitce(input: String) = {
    if (input == "test") Some("good") else None
  }

  def compute(input:Int) = {
    if(input> 0)
      Right(math.sqrt(input))
    else
      Left("Error computing, invalid input")
  }

  def displayRes(result:Either[String,Double]):Unit = {
    println(s"Row: $result")
    result match {
      case Right(value) => println(s"result $value")
      case Left(err) => println(s"Error: $err")
    }
  }

  def optionTest() = {
    for (input <- Set("test", "hack")) {
      val comment = commentOnPricitce(input)
      val dis = comment.getOrElse("Found no comments");
      println(s"input: $input comment: $dis $comment")
    }
  }

  def main(args: Array[String]): Unit = {
    displayRes(compute(4))
    displayRes(compute(-4))
    optionTest()
    EnumDemo.values.foreach(println(_))
    println(EnumDemo.CNY, Common.Margin.BOTTOM, Common.MAGIC_NUM)

  }
}

