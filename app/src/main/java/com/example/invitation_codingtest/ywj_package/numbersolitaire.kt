import kotlin.collections.ArrayList
import kotlin.math.absoluteValue
import kotlin.math.max

fun main(args: Array<String>) {

    fun solution(A: IntArray): Int {
        var dp = IntArray(A.size)
        dp[0] = A[0]

        //0~7사이의 값을 미리 정해줌
        for (i in 1..6) {
            if(A.size<=i)   // A의 사이즈가 6이하일때 그이상의 값이 들어가지못하게 브레이크
                break
            dp[i] = dp[0] + A[i]
            for (j in 1 until i) {
                if (dp[i] < dp[j] + A[i]) {
                    dp[i] = dp[j] + A[i]
                }
            }
        }
        //A가 6이하일때 결과값 도출하게
        if (A.size <= 6) {
            return dp[A.size-1]
        }
        // A의 사이즈가 클경우 그 이상의 경우에 대해 점화식 연결해줌
        else for (i in 7 until A.size) {
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
