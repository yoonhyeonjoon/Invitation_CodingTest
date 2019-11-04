import java.util.Collections.max
import kotlin.math.max


fun main(args : Array<String>){


    fun solution(A: IntArray): Int {
        val store = IntArray(A.size)
        store[0] = A[0]
        for (i in 1 until A.size) {
            store[i] = store[i - 1]
            for (minus in 2..6) {
                if (i >= minus) {
                    store[i] = max(store[i], store[i - minus])
                } else {
                    break
                }
            }
            store[i] += A[i]
        }
        return store[A.size - 1]
    }


    var A = intArrayOf(1,-2,0,9,-1,-2)
    println(solution(A))

}