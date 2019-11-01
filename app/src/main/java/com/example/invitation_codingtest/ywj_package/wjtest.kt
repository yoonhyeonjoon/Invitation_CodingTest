import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.math.min
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*


fun main(args : Array<String>){
    fun solution(A: IntArray): Int {
        var resultof = 0
        for(a in A)
        {
            resultof = resultof xor a
        }
        return  resultof
    }


    var A = intArrayOf(9,3,9,3,9,7,9)
    val B = solution(A)
    println(B)

}
