/**
  * Created by Guoqing on 2016/10/20.
  */
object ConsumerTest {

    def main(args: Array[String]): Unit = {
        val drop = new Drop()

        new Thread(new Producer(drop)).start()

        new Thread(new Consumer(drop)).start()
    }

    class Drop {
        var message = ""
        var empty = true
        var lock = new Object()

        def put(str: String) = lock.synchronized {
            await(empty == true)
            empty = false
            message = str
            lock.notifyAll()
        }

        def take(): String = lock.synchronized {
            await(empty == false)
            empty = true
            lock.notifyAll()
            return message
        }

        private def await(cond: => Boolean) = {
            while (!cond) {
                lock.wait()
            }
        }
    }

    class Producer(drop : Drop) extends Runnable {
        val importantInfo : Array[String] = Array(
            "Line 1",
            "Line 2",
            "Line 3",
            "Line 4"
        )

        override def run() : Unit = {
            importantInfo.foreach((msg) => drop.put(msg))
            drop.put("DONE")
        }
    }

    class Consumer(drop : Drop) extends Runnable {
        override def run() : Unit = {
            var message = drop.take()
            while (message != "DONE") {
                System.out.format("MESSAGE RECEIVED: %s%n", message)
                message = drop.take()
            }
        }
    }
}