import java.lang.Integer.min

fun main(args : Array<String>){

    fun processor(S: String, pidx: Int, qidx: Int) : Int
    {
        var minval = 4
        var sval = 4
        for(idx in pidx..qidx) {
            when (S[idx]) {
                'A' -> {
                    sval = 1
                }
                'C' -> {
                    sval = 2
                }
                'G' -> {
                    sval = 3
                }
                'T' -> {
                    sval = 4
                }
            }
            minval = min(sval, minval)
        }
        return minval
    }


    fun solution(S: String, P: IntArray, Q: IntArray): IntArray {


        val mutaarr = Array(P.size){0}
        for(idx in P.indices)
        {
            mutaarr[idx] =  processor(S, P[idx], Q[idx])
        }
        return mutaarr.toIntArray()
    }

    var S = "AC" //CAGCCTA
    var P = intArrayOf(0,0,1)
    var Q = intArrayOf(0,1,1)
    val B = solution(S,P,Q)
    println(B.toList())

}