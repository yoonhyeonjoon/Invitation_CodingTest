package com.example.invitation_codingtest.hangnim_package

import java.io.*
import java.util.*


fun main(args: Array<String>) {

   //example
    val circularqueue:CircularQueue<Int> = CircularQueue()

}


private class CircularQueue<T> {

    private class QueueNode<T> constructor(var data: T)
    {
        var next: QueueNode<T>? = null
    }

    fun add(item: T) { // todo

    }

    fun remove(): T? { // todo
        return null
    }

    fun peek(): T? { // todo
        return null
    }

    fun isEmpty(): Boolean {       // todo
        return true
    }
}