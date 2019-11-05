
fun main(args : Array<String>){


    fun solution(S: String): Int {

        var checkmap = mutableMapOf<Char,Boolean>()
        for(s in S)
        {
            if(checkmap[s] == null) {checkmap[s] = true}
            else if(checkmap[s] == true) {checkmap[s] = false}
            else if(checkmap[s] == false) {checkmap[s] = true}
        }

        var resultnum = 0
        for(avalue in checkmap)
        {
            if(avalue.value)
                resultnum++
        }

        return resultnum
    }



    var A = "acbcbba"
    val B = solution(A)
    println(B)

}
