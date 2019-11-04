
fun main(args : Array<String>){

    var N = 5
    var initialMaxChecker = true
    var finalarray = Array(N){0}

    fun solution(N: Int, A: IntArray): IntArray {

        val maxCounter = N + 1
        val counters = IntArray(N)
        for (i in counters.indices) {
            counters[i] = 0
        }

        var nextMax = 0
        var curMax = 0
        for (i in A.indices) {
            val counterNumber = A[i]
            val counterIndex = counterNumber - 1

            if (counterNumber < maxCounter) {
                if (counters[counterIndex] <= curMax) {
                    counters[counterIndex] = curMax
                }
                counters[counterIndex]++
                nextMax = Math.max(nextMax, counters[counterIndex])
            } else {
                curMax = nextMax
            }
        }

        for (i in counters.indices) {
            if (counters[i] < curMax) {
                counters[i] = curMax
            }
        }

        return counters
    }


    var A = intArrayOf(3, 4, 4, 6, 1, 4, 4)
    //var A = intArrayOf(8, 5, 4, 4, 4)


    val B = solution(N,A)
    //println(B.toList())
    println(B.toList())

}