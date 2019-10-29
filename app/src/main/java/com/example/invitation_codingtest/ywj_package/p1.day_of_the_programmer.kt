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

fun main(args: Array<String>) {
    val year = readLine()!!.trim().toInt()

    fun dayOfProgrammer (year: Int) : String{

        var date = arrayListOf<String>("00","00","${year}")
        if(year < 1918){
            date = if (year.rem(4) == 0)
                arrayListOf<String>("12","09","${year}")
            else
                arrayListOf<String>("13","09","${year}")
        }
        else if (year == 1918) {
            date = arrayListOf<String>("26","09","${year}")
        }
        else {
            if (year.rem(400)==0){
                date = arrayListOf<String>("12","09","${year}")
            }
            else if (year.rem(4)==0 && year.rem(100)!=0){
                date = arrayListOf<String>("12","09","${year}")
            }
            else
                date = arrayListOf<String>("13","09","${year}")

        }

        val datefix = date.joinToString (".")

        return datefix
    }
    val result = dayOfProgrammer(year)

    println(result)
}

