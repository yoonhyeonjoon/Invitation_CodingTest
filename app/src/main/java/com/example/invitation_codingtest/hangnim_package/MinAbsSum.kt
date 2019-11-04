import java.util.Collections.max
import kotlin.math.abs
import kotlin.math.max


fun main(args : Array<String>){



    fun solution(A: IntArray): Int {

        if(A.isEmpty()) return 0
        val B = A.map{ abs(it)}.sorted().reversed()
        var container = B[0]
        for(b in 1 until B.size)
        {
            container = abs(container - B[b])
        }

        return container

    }


    var A = intArrayOf(3, 3, 3, 4, 5)//, 5, 2, -2, 3)
    println(solution(A))

}