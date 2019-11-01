
import android.text.BoringLayout
import java.lang.Math.ceil
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashMap
import kotlin.math.ceil

// 태스크 스코어 80%
fun main(args : Array<String>){


    fun solution(A: IntArray): Int {
        val arrbox = Array<Int>(A.size+2,{0})
        for(b in A)
        {
            arrbox[b] = 1
        }
        for((idx, ar) in arrbox.withIndex())
        {
            if(ar == 0 && idx != 0) return idx
        }
        return 0
    }


    println(solution(intArrayOf(2,1,3,5)))

}