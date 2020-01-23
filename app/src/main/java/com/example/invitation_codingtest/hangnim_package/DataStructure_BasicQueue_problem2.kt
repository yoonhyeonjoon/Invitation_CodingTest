import java.io.*
import java.util.*


/*
A queue implements FIFO (first-in first-out) ordering.
It uses the operations:
  add(item): Add an item to the end of the list.
  remove ( ): Remove the first item in the list.
  peek(): Return the top of the queue.
  isEmpty ( ) : Return true if and only if the queue is empty.
*/

fun main(args: Array<String>) {

    val queue:SimpleQueue2<Int> = SimpleQueue2()
    queue.add(1)
    queue.add(2)
    queue.add(3)
    queue.add(4)
    queue.add(5)
    queue.add(6)
    queue.remove()
    queue.remove()
    queue.remove()
    queue.remove()
    queue.remove()
}

class SimpleQueue2<T> {

    var totalQueue:QueueNode2<T>? = null
    var endQueue:QueueNode2<T>?   = null

    class QueueNode2<T>(var data: T)
    {
        var next: QueueNode2<T>? = null
    }

    fun add(item: T) { // todo

        val newqueue = QueueNode2(item)
        if(totalQueue == null)
        {
            totalQueue = newqueue
            endQueue = newqueue
        }
        else
        {
            endQueue?.next = newqueue
            endQueue = newqueue
        }
    }

    fun remove() { // todo

        println(totalQueue?.data)

        if(totalQueue?.data != null)
        totalQueue = totalQueue?.next

        //return null
    }

    fun peek(): T? { // todo
        return null
    }

    fun isEmpty(): Boolean {       // todo
        return true
    }
}