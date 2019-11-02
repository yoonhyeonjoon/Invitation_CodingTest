import kotlin.collections.ArrayList
import kotlin.math.absoluteValue

fun main(args: Array<String>) {

    fun solution(A: IntArray): Int {
        val max = A.sum()
        var result = (max-2*A[0]).absoluteValue
        for (i in 1 until  A.size-1){
            var b=A.slice(0..i).sum()
           if (result>(max-2*b).absoluteValue){
               result = (max-2*b).absoluteValue
           }
        }
        return result
    }




    println(solution(arrayOf(3,1,2,4,3).toIntArray()))


}
