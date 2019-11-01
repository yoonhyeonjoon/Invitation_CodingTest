import java.lang.Math.abs

//38% 스코어
fun main(args : Array<String>){
    fun solution(A: IntArray): Int {

        var maxchecker = 100000000
        for(i in A.indices)
        {
            //sublist도 성능이 똑같다
            val abscheck = abs(A.take(i).sum() - A.takeLast(A.size-i).sum())
            if(maxchecker > abscheck) maxchecker = abscheck
        }

        return maxchecker
    }


    var A = intArrayOf(3,1,2,4,3)
    println(solution(A))

}