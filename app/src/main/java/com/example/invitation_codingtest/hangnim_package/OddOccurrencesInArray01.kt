
import android.text.BoringLayout
import java.lang.StringBuilder
import java.util.*


//map으로 구현, 스코어 77%, 올바름 100%, 퍼포먼스 50%
fun main(args : Array<String>){

    var checkmap = mutableMapOf<Int,Boolean>()

    fun solution(A: IntArray): Int {
        for(i in A)
        {
            if(checkmap[i] == null)
                checkmap.put(i, false)
            else if(checkmap[i] == true)
                checkmap.put(i, false)
            else if(checkmap[i] == false)
                checkmap.put(i, true)
        }

        for((key,value) in checkmap) {
            if (value == false) {
                return key
                break
            }
        }
        return 0
    }


    var A = intArrayOf(9,3,9,3,9,7,9)
    val B = solution(A)
    println(B)

}