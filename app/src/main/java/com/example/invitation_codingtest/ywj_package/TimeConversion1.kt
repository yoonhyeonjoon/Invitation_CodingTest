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
 * Complete the simpleArraySum function below.
 */
fun timeConversion(s: String): String {

    var a= s.split(":")

    var b = a[2].substring(2)
    var c = a[2].substring(0,2)

    val wj_formatter = DecimalFormat("00")

    var hour = a[0].toInt()
    var hour2 = wj_formatter.format(hour)
    if (b.equals("PM") ) {
        if(hour.equals(12)){
            hour=12
        }
        else hour += 12
        return "${hour}:${a[1]}:${c}"
    }


    else
        when(hour) {
            12 -> hour2 = "00"
            else -> hour2 = hour2
        }
    return  "${hour2}:${a[1]}:${c}"

}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = timeConversion(s)

    println(result)
}

