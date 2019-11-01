
import android.text.BoringLayout
import java.lang.Math.ceil
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashMap
import kotlin.math.ceil

// 태스크 스코어 40%
fun main(args : Array<String>){


    fun solution(A: IntArray): Int {
        val B = A.sorted()
        var counter = 1
        for(b in B)
        {
            if(b != counter)
                return b-1
            else counter++
        }
        return 0
    }


    println(solution(intArrayOf(2,1,3,5)))

}