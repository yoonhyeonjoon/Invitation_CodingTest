import kotlin.collections.ArrayList
import kotlin.math.absoluteValue

fun main(args: Array<String>) {

    //81점

    fun solution(X: Int, A: IntArray): Int {
        var time=0
        var count =1
        if (A.max()!! <X || A.size<X){
            time=-1
        }
        else while (count!=X+1) {
            for (i in 0 until A.size) {
                if (A[i] == count) {
                    if (time < i) {
                        time = i
                    }
                    count += 1
                    break
                }
                else if (i==A.size-1){
                    time = -1
                    count = X+1
                    break
                }
            }

        }
        return time
    }

    println(solution(3, arrayOf(1,1,3).toIntArray()))

}
