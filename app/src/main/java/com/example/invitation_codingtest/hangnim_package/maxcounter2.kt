import java.util.*

//100%
fun main(args : Array<String>){

    var N = 5
    var initialMaxChecker = true
    var finalarray = Array(N){0}

    fun basenumberfinder(standardnumber : Int, A: IntArray) : Int
    {
        //val acon = Array(A.size){0}
        var standardnumber_change = standardnumber
        val hashes = mutableMapOf<Int,Int>()
        var maxvalue = 0
        for(i in standardnumber downTo 0)
        {
            if(i == 0) //마지막에 도달시
            {
                if(hashes[0] == null) hashes[0] = 1
                else  hashes[0] =  hashes[0]!! + 1
                maxvalue =  hashes.maxBy { it.value }!!.value
                standardnumber_change = 0

                //맥스를 안만난경우 수를 그대로 반납
                if(initialMaxChecker) {
                    for((key,value) in hashes)
                    {
                        finalarray[key] = value
                    }
                }
                break
            }
            val aa = A[i]
            if(aa == N+1) //맥스+1를 처음 만난경우/ 2번째이상 만난경우/ 안만난경우
            {
                if(initialMaxChecker){ //처음 만난 경우
                    initialMaxChecker = false
                    for((key,value) in hashes)
                    {
                        finalarray[key] = value
                    }
                }
                else{ //2번쨰 이상만난경우
                    maxvalue = hashes.maxBy { it.value }!!.value
                }
                standardnumber_change = i
                break
            }
            else {
                if(hashes[aa-1] == null) hashes[aa-1] = 1
                else  hashes[aa-1] =  hashes[aa-1]!! + 1
            }
        }

        when (standardnumber_change) {
            0 -> return maxvalue
            else ->  return (maxvalue+basenumberfinder(standardnumber_change-1, A))
        }
    }

    fun solution(N: Int, A: IntArray): IntArray {

        val checker = basenumberfinder(A.size - 1, A)
        return finalarray.map { it + checker }.toIntArray()
    }

    //var A = intArrayOf(3,4,4,6,1,4,4)
    var A = intArrayOf(8, 5, 4, 4, 4)


    val B = solution(N,A)
    //println(B.toList())
    println(0)

}