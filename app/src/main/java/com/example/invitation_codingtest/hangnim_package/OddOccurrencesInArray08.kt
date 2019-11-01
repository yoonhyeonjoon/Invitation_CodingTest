
import android.text.BoringLayout
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashMap



fun main(args : Array<String>){
    fun solution(A: IntArray): Int {
    var resultof = 0
        for(a in A)
        {
            resultof = resultof xor a
        }
        return  resultof
    }


    var A = intArrayOf(9,3,9,3,9,7,9)
    val B = solution(A)
    println(B)

}