
import android.text.BoringLayout
import java.lang.StringBuilder
import java.util.*


//람다식으로 구현. 스코어 55%, 올바름 80%, 퍼포먼스 25% => [시퀀스를 써도 별로 변화가 없음] groupby에서 속도가 결정나는듯, 이것도 역시 마찬가지다
fun main(args : Array<String>){

    fun solution(A: IntArray): Int {

        //    val checkfor = A.sorted().groupBy { it }.values.asSequence().filter { it.size == 1 }.toList() 이 식도 동일한 퍼포먼스
       val checkfor = A.groupBy { it }.values

        for(i in checkfor)
        {
            if(i.size == 1)
            {
                return i[0]
                break
            }

        }
        return 0
        //return checkfor[0][0]
    }

    var A = intArrayOf(9,3,9,3,9,7,9)
    val B = solution(A)
    println(B)

}