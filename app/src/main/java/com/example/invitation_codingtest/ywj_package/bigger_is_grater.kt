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
    val scan = Scanner(System.`in`)
    val firstinput = scan.nextLine().trim().toInt()

    repeat(firstinput) {
        val exchange = scan.nextLine().trim().map {
            it.toInt()}.toMutableList()

        for (n in exchange.size - 1 downTo 0) {
            if (n == 0) {
                println("no answer")
                break
            }

            else if (exchange[n] > exchange[n - 1]) {
                val exn_1 = exchange[n-1] //2
                exchange[n-1]= exchange[n]
                exchange[n]=exn_1
                for (x in n until exchange.size){
                    if (exn_1<exchange[x] && exchange[n-1]>=exchange[x]){
                        val a=exchange[x]
                        exchange[x]=exchange[n-1]
                        exchange[n-1]=a
                    }
                    if (exchange[x]-exn_1==1)
                        break
                }

                for (x in n until exchange.size){
                    for(y in x+1 until exchange.size) {
                        if (exchange[x]>exchange[y]){
                            val a=exchange[x]
                            exchange[x]=exchange[y]
                            exchange[y]=a
                        }
                    }
                }

                val result = exchange.map { it.toChar() }.toCharArray()
                println(result)
                break
            }
        }
    }
}


