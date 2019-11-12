package com.example.invitation_codingtest.ywj_package

import java.util.*

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val k = first_multiple_input[1].toInt()

    val s = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()


    fun count (A : Array<Int> , B:Int) : Int {
        var countednumber =0
        for (i in 0 until A.size){
            if(A[i]==B)
                countednumber+=1
        }
        return  countednumber
    }



    fun nonDivisibleSubset(n :Int , K:Int, s:Array<Int>) : Int {

        val makelittle = s.map { it%k }.toTypedArray()
        var counting =0
        val countarray =Array<Int>(K){0}

        for ( i in 0 until K){
            countarray[i]=count(makelittle,i)
        }
        if (K%2==1){
            if (countarray[0]>0)
                counting+=1
            for (i in 1 until (K+1)/2){
                if(countarray[i]>countarray[K-i])
                    counting+=countarray[i]
                else
                    counting+=countarray[K-i]
            }
        }
        else {
            if (countarray[0] > 0)
                counting += 1
            if (countarray[K/2]>0)
                counting +=1
            for (i in 1 until (K/2)){
                if(countarray[i]>countarray[K-i])
                    counting+=countarray[i]
                else
                    counting+=countarray[K-i]
            }
        }
        return counting
    }


    val result = nonDivisibleSubset(n,k,s)

    println(result)
}
