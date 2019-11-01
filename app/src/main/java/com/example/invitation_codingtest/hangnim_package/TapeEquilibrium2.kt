import java.lang.Math.abs

//38% 스코어
fun main(args : Array<String>){
    fun solution(A: IntArray): Int {

        var a_container : Int = A[0]
        var b_container : Int = A.sum() -  A[0]
        var mincontainer = abs(a_container - b_container)
        //for(i in A.indices)
        for(i in 1 until A.size)
        {
            if(i != A.size-1) { //마지막 수는 뺀다
                a_container = a_container + A[i]
                b_container = b_container - A[i]
                val minval = abs(a_container - b_container)
                if (minval < mincontainer) {
                    mincontainer = minval
                }
            }
        }
        return mincontainer
    }


    var A = intArrayOf(-1000, 1000 )
    println(solution(A))

}