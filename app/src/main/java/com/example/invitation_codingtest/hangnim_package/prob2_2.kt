
fun main(args : Array<String>){


    fun solution(A: IntArray): Int {

        val andarr = Array<Int>(A.size){1}
        val checkarr = Array<Int>(A.size){0}

        var anum = 0.toBigInteger()
        for(a in A)
        {
            anum = (1 shl a-1).toBigInteger() or anum
        }
        return 0
    }

    var A = intArrayOf(1000, 300,9,6,1,3,4,2,5)
    val B = solution(A)
    println(B)

}