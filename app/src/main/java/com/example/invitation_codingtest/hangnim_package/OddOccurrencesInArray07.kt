
import android.text.BoringLayout
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashMap


//xor으로 구현, 스코어 88%, 올바름 100%, 퍼포먼스 75%
fun main(args : Array<String>){
    fun solution(A: IntArray): Int {
        val checkfor = A.max()
        val container = Array(checkfor!!+1) { 0 }
        for(a in A)
        {
            container[a] = container[a].xor(1)
        }

        return container.indexOf(1)
    }


    var A = intArrayOf(9,3,9,3,9,7,9)
    val B = solution(A)
    println(B)

}