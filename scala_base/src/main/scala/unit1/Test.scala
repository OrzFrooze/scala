package unit1

object Test{
    def list():Unit = {
      var list = List()
      
    }
    def getInfo() ={
      ("aaa","bbb","cccc")
    }

    def javaArray():Unit ={
      val a:Int = 10
      val list = new java.util.ArrayList[String]
      list.ensureCapacity(a)
      list.add("sfsf")
      list.add("222")
      list.add("232")
      list.forEach(println)
    }
    def ls() = println("=============")
    def main(args: Array[String]): Unit = {
        val value = List(1,2,3,4,5)
        value.map(println)
        val name = "teshi"
        println(s"hello world $name")
        for(i <- 1 until 3) println(s"$i c")
        println("-------------")
        (1 to 3).foreach(println)
        println("-------")
        javaArray()
        ls
        val (a,b,c) = getInfo()
        println(s"$a $b $c")
    }
}