package akka

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by Guoqing on 2016/10/20.
  */
object ActorTest {

    def main(args: Array[String]): Unit = {
        val system = ActorSystem("HelloSystem")
        val helloActor = system.actorOf(Props[HelloActor])
        helloActor ! "hello"
        helloActor ! "?"
    }

    class HelloActor extends Actor {
        override def receive: Receive = {
            case "hello" => println("hello world")
            case _ => println("gg")
        }
    }
}
