
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

    val queue:BasicTree<Int> = BasicTree()


}


class BasicTree_problem<T> {

    private class QueueNode<T> constructor(var data: T)
    {
        var next: QueueNode<T>? = null
    }

    fun add(item: T) {

    }

    fun remove(): T? {
        return null
    }

    fun peek(): T? {
        return null
    }

    fun isEmpty(): Boolean {       // todo
        return false
    }
}