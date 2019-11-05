import java.text.FieldPosition
import kotlin.collections.ArrayList
import kotlin.math.absoluteValue
import kotlin.math.max

fun main(args: Array<String>) {


    fun solution(A: IntArray): Int {
        var dp = Array<Int?>(A.size) {null}

        fun f(B:Int) : Int{
            if (B==0)
            {dp[B]=A[0]
             return dp[B]!!
            }
            else if(dp[B - 1]==null) {
                dp[B] = f(B - 1) + A[B]
                for (i in 2..6) {
                    if (B - i < 0)
                        break
                    if (dp[B - i]==null) {
                        if (dp[B - i]!! + A[B] > dp[B]!!)
                            dp[B] = f(B - i) + A[B]
                    }
                    else {
                        if (dp[B - i]!! + A[B] > dp[B]!!)
                            dp[B] = dp[B-i]!! + A[B]
                    }
                }
                return dp[B]!!
            }

                dp[B] = dp[B - 1]!! + A[B]
                for (i in 2..6) {
                    if (B - i < 0)
                        break
                    if (dp[B - i]==null) {
                        if (dp[B - i]!! + A[B] > dp[B]!!)
                            dp[B] = f(B - i) + A[B]
                    }
                    else {
                        if (dp[B - i]!! + A[B] > dp[B]!!)
                            dp[B] = dp[B-i]!! + A[B]
                    }
                }
                return dp[B]!!
        }
        return f(A.size-1)
    }


    println(solution(listOf(-1,-7,-3,-2,-7,-7,-10,-12,-3,-4).toIntArray()))
    println(solution(listOf(1,-2,0,9,-1,-2).toIntArray()))
    println(solution(listOf(-1,3).toIntArray()))

}
