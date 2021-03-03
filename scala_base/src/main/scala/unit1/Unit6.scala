package unit1

class Equipment(val routine: Int => Int) {
  def simulate(input: Int): Int = {
    println("Runing simulation")
    routine(input)
  }
}

/**
 * 函数值和闭包
 */
object Unit6 {
  def calc(range: Int, codeBlock: (Int, Int) => Int): Int = {
    var r = 0
    for (i <- 1 to range by 2) {
      r += codeBlock(i, i + 1)
    }
    r
  }

  def inject(arr: Array[Int], initial: Int, opreation: (Int, Int) => Int): Int = {
    var carryOver = initial
    arr.foreach(e => carryOver = opreation(carryOver, e))
    carryOver
  }


  def inject2(arr: Array[Int], initial: Int)(opreation: (Int, Int) => Int): Int = {
    var carryOver = initial
    arr.foreach(e => carryOver = opreation(carryOver, e))
    carryOver
  }

  def totalResultOverRange(number: Int, codeBlock: Int => Int): Int = {
    var r = 0
    for (i <- 1 to number) {
      r += codeBlock(i)
    }
    r
  }

  def sum(i: Int): Int = {
    math.abs(i)
  }

  //无参数
  def printValue(fn: () => Int): Unit = {
    println(s"fn values is ${fn()}")
  }


  def test(): Unit = {
    val a = calc(2, (i, j) => {
      i * j
    })
    val r = totalResultOverRange(10, sum)
    val c = totalResultOverRange(5, i => {
      if (i % 2 == 0) 1 else i;
    })

    val arr = Array(2, 3, 4, 5, 6)
    val aa = inject(arr, 1, (a, b) => a + b)
    val max = inject(arr, Integer.MIN_VALUE, (a, b) => Math.max(a, b))
    val min = inject2(arr, Integer.MAX_VALUE) { (a, b) => Math.min(a, b) }
    val b = (0 /: arr) {
      _ + _
    }

    printValue(() => 23)
    println(a, r, c, aa, max, min, b)
  }


  def main(args: Array[String]): Unit = {
    test

    val a = new Equipment({ input => println(s"calc with $input"); input })
    val b = new Equipment({ input => println(s"calc with $input"); input })
    a.simulate(4)
    b.simulate(6)
  }
}
