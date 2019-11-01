
import android.text.BoringLayout
import java.lang.StringBuilder
import java.util.*


//람다식으로 구현. 스코어 66%, 올바름 100%, 퍼포먼스 25% => [시퀀스를 써도 별로 변화가 없음] groupby에서 속도가 결정나는듯
fun main(args : Array<String>){

    fun solution(A: IntArray): Int {
       val checkfor = A.sorted() //.groupBy { it }.values.asSequence().filter { it.size == 1 }.toList()

        var int_container = 0
        var bool_container = 1 //시작은 1로
        for(i in checkfor)
        {
            if(int_container != i) { //값이 같지 않다면, 다음차수
                if(bool_container == 0) //이전 불리안 값이 단지 1이라면 단 하나의 수이므로 브레이크
                    break
                bool_container = 0 //불리안 초기화
                int_container = i
            }
            else //값이 같다면 반복되는 값의 수
            {
                when(bool_container) {
                 0->  bool_container = 1
                 1->  bool_container = 0 //핑퐁
                }
            }
        }
       return int_container
    }

    var A = intArrayOf(9,3,9,3,9,7,9)
    val B = solution(A)
    println(B)

}