
//66%
fun main(args : Array<String>){

    fun solution(N: Int, A: IntArray): IntArray {
        var arr01 = Array(N,{0})
        var basenumber = 0
        for(a in A)
        {
            if(a == N+1)  arr01 = Array(N,{basenumber})
            else {
                arr01[a-1] = arr01[a-1] + 1
                if(basenumber < arr01[a-1])
                    basenumber = arr01[a-1]
            }

        }

        return arr01.toIntArray()
    }


    var A = intArrayOf(3,4,4,6,1,4,4)
    var N = 5

    val B = solution(N,A)
    println(B.toList())

}