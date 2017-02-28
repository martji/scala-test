/**
  * Created by Guoqing on 2016/10/20.
  */

import scala.io._

object CollectionTest {

    def main(args: Array[String]): Unit = {
        val x = Map("one" -> 1, "two" -> 2, "three" -> 3)
        println(x.maxBy(_._2)._1)

        val n = StdIn.readInt()
        val arr = new Array[Int](n)
        for (i <- 0 to n - 1) {
            arr(i) = StdIn.readInt()
        }
        println(arr.sorted.toList)
    }
}
