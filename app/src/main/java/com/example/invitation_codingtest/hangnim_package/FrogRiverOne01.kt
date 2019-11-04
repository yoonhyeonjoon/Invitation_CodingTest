
//100%
fun main(args : Array<String>){

    fun solution(X: Int, A: IntArray): Int {
    var result = -1
    val arrcontainer = Array(X, { false })
        var counterX = 0
        var totalcounter = 0
        for (a in A) {

            if (a > X) continue
            else if(!arrcontainer[a-1])
            {
                arrcontainer[a-1] = true
                counterX++
            }

            if(counterX == X) {
                result = totalcounter
                break
            }
            totalcounter++
        }

        return result
    }

    var A = intArrayOf(1,3,1,4,2,3,5,4)
    var X = 3

    val B = solution(X,A)
    println(B)

}