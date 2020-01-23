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

// Complete the highestValuePalindrome function below.
fun checkStartNinePoint(s : String) : Int
{
    var counter = 0
    val approacher = s.length / 2
    for(i in 0 until approacher)
    {
        if(s[i]== s[s.length - i - 1] && s[i] == '9')
        {
            counter++
        }
    }
    return counter
}

fun isTransAvailable(s : String, k: Int) : Int
{
    var counter = 0
    val approacher = s.length / 2
    for(i in 0 until approacher)
    {
        if(s[i] != s[s.length - i - 1])
        {
            counter++
        }
    }

    return when {
        k > counter -> 0
        k == counter -> 1
        else -> 2
    }
}

fun TransNum(s:String, k:Int):String
{
    var ss = s.toCharArray()
    val approacher = s.length / 2
    var kk = k
    for(i in 0 until approacher)
    {
        if(kk > 0)
        {
            if (s[i] != s[s.length - i - 1]) {
                if (s[i].toInt() > s[s.length - i - 1].toInt()) {
                    ss[s.length - i - 1] = ss[i]
                } else
                    ss[i] = ss[s.length - i - 1]
                kk--
            }
        }
    }
    return ss.joinToString("")
}

fun highestValuePalindrome(s: String, n: Int, k: Int): String {

    var ss = s
    var kk = k
    var nineattacher = 0
    var isthisodd = false
    var middlenum = "0"

    if(s.length.rem(2) == 1) //odd -> 가운뎃수 제외
    {
        when (s.length) {
            1 -> {
                return if(kk == 1) {
                    "9"
                } else s
            }
            2 -> {

            }
            else -> {
                isthisodd = true
                middlenum = s[(s.length / 2) + 1].toString()
                ss = ss.substring(0, (s.length / 2)) + ss.substring((s.length / 2) + 1, (s.length))
            }
        }
    }


    var checkPossiblity = 0
    var NinePoint = 0

    NinePoint = checkStartNinePoint(ss)
    ss = ss.substring(NinePoint,ss.length-NinePoint)
    while(checkPossiblity == 0 || checkPossiblity == 1 )
    {
        checkPossiblity = isTransAvailable(ss, kk)
        if(checkPossiblity == 1 || checkPossiblity == 2) break
        nineattacher++
        ss = ss.substring(1,ss.length-1)
        kk -= 2
    }

    val ninechar : StringBuilder = StringBuilder()
    if(nineattacher != 0)
    {
        for(i in 1..nineattacher)
        {
            ninechar.append("9")
        }
        val nums = ninechar.toString() + TransNum(ss, kk) + ninechar.toString()

        return if(NinePoint != 0) {
            val ninechar : StringBuilder = StringBuilder()
            for(i in 1..NinePoint) {
                ninechar.append("9")
            }
            if(isthisodd)
            {
                return nums.substring(0, nums.length/2) + middlenum + nums.substring(nums.length/2, nums.length)
            }
            else
                ninechar.toString() + nums + ninechar.toString()
        } else {

            if(isthisodd)
            {
                return nums.substring(0, nums.length/2) + middlenum + nums.substring(nums.length/2, nums.length)
            }
            else
                nums

        }


    }
    else {
        return when (checkPossiblity) {
            2 -> "-1"
            else -> {
                if(isthisodd)
                {

                    val trannum = TransNum(ss, kk)
                    val strings = trannum.substring(0, trannum.length/2) + middlenum + trannum.substring(trannum.length/2, trannum.length)
                    return if(NinePoint != 0) {
                        val ninechar : StringBuilder = StringBuilder()
                        for(i in 1..NinePoint) {
                            ninechar.append("9")
                        }
                        ninechar.toString() + strings + ninechar.toString()
                    } else {
                        strings
                    }
                }
                else
                    TransNum(ss, kk)

            }
        }
    }

}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val nk = scan.nextLine().split(" ")
    val n = nk[0].trim().toInt()
    val k = nk[1].trim().toInt()
    val s = scan.nextLine()
    val result = highestValuePalindrome(s, n, k)
    println(result)
}
