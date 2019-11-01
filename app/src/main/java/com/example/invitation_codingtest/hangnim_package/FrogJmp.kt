
import android.text.BoringLayout
import java.lang.Math.ceil
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashMap
import kotlin.math.ceil

// 태스크 스코어 100% 올바름 100% 성능
fun main(args : Array<String>){


    fun solution(X: Int, Y: Int, D: Int): Int {
        var cal = (Y - X) / D //float을 쓰면 알고리즘이 느려짐
        if(cal*D + X != Y) //차라리 이런 연산을 통한 계산이 더 빠름
            return cal+1
        return cal
    }

    println(solution(10,85,30))

}