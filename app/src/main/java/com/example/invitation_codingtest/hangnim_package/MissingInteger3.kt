//100%
fun main(args : Array<String>){

    fun solution(A: IntArray): Int {

        var maxcheck = 0
        for(a in A)
        {
            if(a > 0 && maxcheck < a) maxcheck = a
        }
        if(maxcheck == 0) return 1

        val arr = Array(maxcheck+1){false}
        for(idx in A.indices)
        {
            val Aval = A[idx]
            if(Aval > 0) arr[Aval] = true
        }
        for((idx,ar) in arr.withIndex())
        {
            if(!ar && idx != 0)
            {
                return idx
            }
        }
        return arr.size
    }
    //var A = intArrayOf(1, 3, 6, 4, 1, 2)
    var A = intArrayOf(-1,-2, 1,2, 3)
    val B = solution(A)
    println(B)

}