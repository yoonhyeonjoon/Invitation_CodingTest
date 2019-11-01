import kotlin.collections.ArrayList

fun main(args: Array<String>) {

    fun solution(A: ArrayList<Int>, K: Int): IntArray{
        if ((K%A.size==0) or (A.size==0))
            return A.toIntArray()

        else {
            val n=K%A.size
            val arraya = A.slice(0 until A.size-n)
            val arrayb = A.slice(A.size-n until A.size)
            val result = arrayb + arraya
            return result.toIntArray()
        }
    }

 //                                         7 6 1 1 2 6 6 3 8 9
    val A = arrayListOf<Int>(3,8,9,7,6,1,1,2,6,6)
    val K = 13
    println(solution(A,K).toList())


}
/* fun solution(A: IntArray, K: Int): IntArray{
        if ((K%A.size==0) or (A.size==0))
            return A
        else if (K%(A.size)>A.size-(K%A.size)){
            val n=K%A.size
            val arraya = A.slice(A.size-n until  A.size)
            val arrayb = A.slice(0 until  A.size-n)
            val result = arraya + arrayb
            return result.toIntArray()
        }
        else {
            val n=K%A.size
            val arraya = A.slice(0 until A.size-n)
            val arrayb = A.slice(A.size-n until A.size)
            val result = arrayb + arraya
            return result.toIntArray()
        }
    }*/
