
fun main(args : Array<String>){

    fun solution(A: IntArray): Int {

        val onecounter = Array(A.size){0}
        var cumnumber = 0

        //initial

        if(A[A.size - 1] == 1)  onecounter[A.size - 1] = 1
        else  onecounter[A.size - 1] = 0

        for(idx in A.size - 2 downTo 0)
        {
            if(A[idx] == 1) onecounter[idx] = onecounter[idx+1] + 1
            else onecounter[idx] = onecounter[idx+1]
        }

        for(idx in A.indices)
        {
            if(cumnumber > 1000000000) return -1
            if(A[idx] == 0) cumnumber+= onecounter[idx]

        }

        if(cumnumber > 1000000000)
        {
            return -1
        }
        else return cumnumber
    }


    var A = intArrayOf(0,1,0,1,1)
    val B = solution(A)
    println(B)

}