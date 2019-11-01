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


fun main(args: Array<String>) {
    var makearray = mutableListOf<Int>()
    val scan =Scanner(System.`in`)
    val n = scan.nextInt()

    for (i in 0 until n){
        val element = scan.nextInt()
        makearray.add(element)
    }

    fun solution (array : IntArray ):Int {
        var file = array.sorted()
        var result = 0
        for (i in 0 until file.size-2 step 2)
        {
            if(file[i]!=file[i+1]) {
                result = file[i]
                break
            }
            else result = file[i+2]
        }
        return result
    }
    println(solution(makearray.toIntArray()))
}

