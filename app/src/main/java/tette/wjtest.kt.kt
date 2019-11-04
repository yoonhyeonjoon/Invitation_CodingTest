import kotlin.collections.ArrayList
import kotlin.math.absoluteValue
import kotlin.math.max

fun main(args: Array<String>) {

    fun solution(A: IntArray): Int {
        var dp = IntArray(A.size)
        dp[0] = A[0]

        for (i in 1..6) {
            if(A.size<=i)
                break
            dp[i] = dp[0] + A[i]
            for (j in 1 until i) {
                if (dp[i] < dp[j] + A[i]) {
                    dp[i] = dp[j] + A[i]
                }
            }
        }
        if (A.size <= 6) {
            return dp[A.size-1]
        } else for (i in 7 until A.size) {
            dp[i] = dp[i - 1] + A[i]
            for (j in 2..6) {
                if (dp[i] < dp[i - j] + A[i]) {
                    dp[i] = dp[i - j] + A[i]
                }
            }

        }
        return dp[A.size-1]
    }





    println(solution(listOf(1,-2,0,9,-1,-2).toIntArray()))

}
