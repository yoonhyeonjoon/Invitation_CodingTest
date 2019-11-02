
//66%
fun main(args : Array<String>){

    fun solution(A: IntArray): Int {
        val E = mutableSetOf<Int>()
        val F = A.filter { it > 0 }
        E.addAll(F)
        var returnval = 1
        val minval = E.min() ?: 0
        val maxval = E.max() ?: 0

        if (minval > 1) return 1
        else {
            for (i in returnval..maxval)
            {
                var valuefinder = false
                for (j in E)
                {
                    if (returnval + 1 == j)
                    {
                        valuefinder = true
                        returnval++
                        break
                    }
                }
                if(!valuefinder) return returnval+1
            }
        }
        return returnval
    }


    var A = intArrayOf(3,6,4)
    val B = solution(A)
    println(B)

}