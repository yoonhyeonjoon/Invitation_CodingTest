
fun main(args : Array<String>){


    fun solution(A: IntArray): Int {

        val andarr = Array<Int>(A.size){1}
        val checkarr = Array<Int>(A.size){0}
        var resultcounter = 0
        var sw1 : Int
        var maxturnbulb = 0
        for(idx in A.indices)
        {
            val posidx = A[idx]-1
            maxturnbulb = Math.max(maxturnbulb, posidx)
            sw1 = 0
            checkarr[posidx] = 1
            for(idx2 in 0..maxturnbulb)
            {
                if(andarr[idx2] * checkarr[idx2] == 0) {
                    sw1 = 1
                    break
                }
            }
            if(sw1 == 0)
            {
                resultcounter++
            }
        }
        return resultcounter
    }


    var A = intArrayOf(6,1,3,4,2,5)
    val B = solution(A)
    println(B)

}