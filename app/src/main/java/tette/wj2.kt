package tette



fun main(args : Array<String>){


    fun solution(A: IntArray): Int {
        var howmanytimes = 0
        var time = 0
        var timearray = IntArray(100000,{i ->i+1  })
       while (time!=A.size){
           if(A.slice(0..time).sum()==timearray.slice(0..time).sum())
               howmanytimes+=1
           time+=1
       }
        return howmanytimes
    }


    println(solution(intArrayOf(2,1,3,5,4)))

    println(solution(intArrayOf(1,3,4,2,5)))

    println(solution(intArrayOf(2,3,4,1,5)))




}