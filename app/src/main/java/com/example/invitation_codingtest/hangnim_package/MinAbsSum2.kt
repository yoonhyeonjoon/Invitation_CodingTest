import java.util.*

fun main(args : Array<String>){


        fun solution(a: IntArray): Int {
            val n = a.size
            if (n == 0) {return 0}
            val abs = IntArray(n)
            var max = Integer.MIN_VALUE
            var sum = 0
            for (i in 0 until n) {
                val v = Math.abs(a[i])
                abs[i] = v
                max = Math.max(max, v)
                sum = sum + v
            }
            val counts = IntArray(max + 1)
            for (i in 0 until n) {
                val v = abs[i]
                counts[v] = counts[v] + 1
            }
            val dp = IntArray(sum + 1)
            Arrays.fill(dp, -1)
            dp[0] = 0
            for (i in 1..max) {
                val count = counts[i]
                if (count > 0) {
                    for (j in 0..sum) {
                        if (dp[j] >= 0) {
                            dp[j] = count
                        } else if (j >= i && dp[j - i] > 0) {
                            dp[j] = dp[j - i] - 1
                        }
                    }
                }
            }
            var result = sum
            var i = 0
            val limit = sum / 2 + 1
            while (i < limit) {
                if (dp[i] >= 0) {
                    result = Math.min(result, sum - 2 * i)
                }
                i++
            }
            return result
        }


    var A = intArrayOf(3, 3, 3, 4, 5)//, 5, 2, -2, 3)
    println(solution(A))

}