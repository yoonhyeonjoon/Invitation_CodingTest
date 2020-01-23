
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

    val queue:SimpleLinkedList<Int> = SimpleLinkedList()
    queue.add(1)
    queue.add(2)
    queue.add(3)
    queue.add(4)
    queue.add(5)
    queue.remove()
    queue.peek()

}


class SimpleLinkedList<T> {

    private var first: QueueNode<T>? = null
    private var tail: QueueNode<T>? = null
    private class QueueNode<T> constructor(var data: T)
    {
        var next: QueueNode<T>? = null
    }

    fun add(item: T) {
        val newnode = QueueNode(item)
        if(first == null) {
            first = newnode
            tail = first
        }
        else
        {
            tail?.next = newnode
            tail= tail?.next
        }
    }

    fun remove(): T? {
        val data = first?.data
        first = first?.next
        return data
    }

    fun peek(): T? {
        return null
    }

    fun isEmpty(): Boolean {       // todo
        return false
    }
}