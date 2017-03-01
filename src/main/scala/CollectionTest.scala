import scala.collection.immutable.TreeSet

/**
  * Created by Guoqing on 2016/10/20.
  */

object CollectionTest extends App {

    override def main(args: Array[String]): Unit = {
        val x = Map("one" -> 1, "two" -> 2, "three" -> 3)
        println(x.maxBy(_._2)._1)
        val list = x.values.flatMap(x => List(x, x)).toList
        list.map(x => x * x).foreach(print)

        def inc = new PartialFunction[Any, Int] {
            override def isDefinedAt(x: Any): Boolean = x.isInstanceOf[Int] && x.asInstanceOf[Int] > 1

            override def apply(x: Any): Int = x.asInstanceOf[Int] + 1
        }
        println(list collect inc)

        list.filter(_ > 2).foreach(x => print(x + " "))
        println(list.sum)
        println(list.toBuffer += (5, 6))

        println("\n------666------\n")

        val list2 = List(1, 3, -2) :+ -4
        println(list2.sortBy(x => x * x))

        val fruit = Set("apple", "orange", "peach", "banana")
        println(fruit("apple"))

        val ordering = Ordering.fromLessThan[String](_.length <= _.length)
        println(TreeSet.empty(ordering) ++ fruit)

        val vector = (2 :: list2).toVector
        println(vector)

    }
}
