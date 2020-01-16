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

data class alist(var alist: MutableList<Int>)

fun gridlandMetro(n: Int, m: Int, k: Int, track: Array<Array<Int>>): Int {
//    4 4 3
//    2 2 3
//    3 1 4
//    4 4 4

    var mapchecker = (1..n).map{ (1..m).map{false}.toMutableList()}.toMutableList()
    for(atrack in track)
    {
        for(i in atrack[1]..atrack[2])
           mapchecker[atrack[0]-1][i-1] = true
    }

    var counter =0
    for(amap in mapchecker)
        for(bmap in amap)
            if(!bmap) counter++

    return counter
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val nmk = scan.nextLine().split(" ")
    val n = nmk[0].trim().toInt()
    val m = nmk[1].trim().toInt()
    val k = nmk[2].trim().toInt()
    val track = Array(k) { Array(3) { 0 } }
    for (i in 0 until k) {
        track[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    }

    val result = gridlandMetro(n, m, k, track)

    println(result)
}
