
import android.text.BoringLayout
import java.lang.StringBuilder
import java.util.*


//람다식으로 구현. 스코어 55%, 올바름 80%, 퍼포먼스 25%
fun main(args : Array<String>){

    fun solution(A: IntArray): Int {
       val checkfor = A.groupBy { it }.values
       val checkfor2 = checkfor.filter { it.size == 1 }
        return checkfor2[0][0]
    }

    var A = intArrayOf(9,3,9,3,9,7,9)
    val B = solution(A)
    println(B)

}