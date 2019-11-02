

fun main(args : Array<String>){

    fun solution(A: IntArray): Int {
        val E = mutableSetOf<Int>()
        val F = A.filter { it > 0 }.sorted()
        E.addAll(F)
        var returnval = 1
        for((i,e) in E.withIndex())
        {
            if(i != e-1) {
                if(i == 0) return 1
                return e - 1
            }
            if(i == E.size-1)
            {
                returnval = e + 1
            }
        }
        return returnval
    }


    var A = intArrayOf(90, 91, 92, 93)
    val B = solution(A)
    println(B)

}