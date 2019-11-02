
//66%
fun main(args : Array<String>){

    fun solution(A: IntArray): Int {

        val arr = Array(A.size+1){false}
        for(a in A)
        {
            if(a > 0) arr[a] = true
        }
        for((idx,ar) in arr.withIndex())
        {
            if(!ar)
            {
                return idx
            }
        }

        return 1
    }


    var A = intArrayOf(3,6,4)
    val B = solution(A)
    println(B)

}