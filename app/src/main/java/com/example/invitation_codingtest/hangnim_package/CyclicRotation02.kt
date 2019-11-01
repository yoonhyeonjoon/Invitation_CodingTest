
import android.text.BoringLayout
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashMap

// 태스크 스코어 50% 올바름 50% 성능 : 평가안됨
fun main(args : Array<String>){

    fun solution(A: IntArray, K: Int): IntArray {
        val size = A.size
        val B = Array(size,{0})
        for(i in 0 until K)
        {
           B[i]  = A[size - K + i]
        }
        for(i in K until size)
        {
            B[i] = A[i - K]
        }

        return B.toIntArray()
    }

    var A = intArrayOf(3, 8, 9, 7, 6)
    var K = 3

    val B = solution(A,K)
    println(B)

}