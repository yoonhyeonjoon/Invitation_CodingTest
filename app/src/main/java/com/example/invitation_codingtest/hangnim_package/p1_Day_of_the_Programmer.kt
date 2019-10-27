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

//256일자를 찾으라.
//1700 - 1917 Julian calendar 4로 나눠 떨어지면 <29일>, 아니면 <28일>
//1918  Mixed  calendar
//1919 -2700 Gregorian calendar 100으로 나눠떨어지면 안됨, 400으로 나누어떨어짐, 4로 나누어 떨어짐이면 <29일>
//31 15 31 30 31 30 31 30  --- 30 31
//  256 - 229

//    27
// 1 2  3  4  5  6  7  8  => 214 + 2월수 + 9월 남은 날 = 256

fun yooncal_jul(year : Int) = year.rem(4) == 0
fun yooncal_gre(year : Int) = (year.rem(4) == 0 &&  year.rem(100) != 0) ||  (year.rem(400) == 0)
fun remainday(days : Int) : Int = 256 - (214 + days) - 1
fun dateGen(year:Int, remainday:Int) {
    println( String.format("%02d.09.%d",remainday,year))
}

fun main(args: Array<String>) {
    val year = readLine()!!.trim().toInt()

    when(year)
    {
        in 1700..1917 -> {
            when (yooncal_jul(year))
            {
                true  -> { dateGen(year,remainday(29)) }
                false -> { dateGen(year,remainday(28)) }
            }
        }
        1918 -> { //+13
            println( String.format("26.09.1918"))
        }
        in 1919..2700 -> {
            when (yooncal_gre(year))
            {
                true  -> { dateGen(year,remainday(29)) }
                false -> { dateGen(year,remainday(28)) }
            }
        }
    }







}
