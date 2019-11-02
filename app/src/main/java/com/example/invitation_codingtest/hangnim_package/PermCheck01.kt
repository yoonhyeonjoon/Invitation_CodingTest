
fun main(args : Array<String>){

    fun solution(A: IntArray): Int {

        val arr = Array<Boolean>(A.size,{false})

        for(a in A)
        {
            if(a > A.size) //크다면 예외 발생한것
                return 0
            else
                arr[a-1] = true
        }
        for(b in arr)
            if(!b) return 0

        return 1
    }


    var A = intArrayOf(4,1,3)
    val B = solution(A)
    println(B)

}