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
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'nonDivisibleSubset' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER k
 *  2. INTEGER_ARRAY s
 */

fun nonDivisibleSubset(k: Int, S: Array<Int>): Int {

    val remcontainer = Array<Int>(k){0}
    var resultcontainer = 0

    for(idx in S.indices)
    {
        val arem = S[idx].rem(k)
        remcontainer[arem]++
    }

    when(k.rem(2))
    {
        0 ->{ //middle value consider as 1
            // N = 0
            if(remcontainer[0] != 0)  resultcontainer++
            // 0 < N < k/2
            for(jj in 1 until k/2)
            {
                resultcontainer += Math.max(remcontainer[k - jj], remcontainer[jj])
            }
            // N = k/2
            resultcontainer++
        }
        1 ->{ //odd
                // N = 0
                if(remcontainer[0] != 0)  resultcontainer++
                // 0 < N < k/2
                for(jj in 1 until k/2 + 1)
                {
                    resultcontainer += Math.max(remcontainer[k - jj], remcontainer[jj])
                }
        }
    }

    return resultcontainer
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")
    val n = first_multiple_input[0].toInt()
    val k = first_multiple_input[1].toInt()
    val s = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    val result = nonDivisibleSubset(k, s)
    println(result)
}
