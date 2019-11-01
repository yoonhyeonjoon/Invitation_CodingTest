
import java.lang.StringBuilder
import java.util.*


val binarylink = StringBuilder()
var lengthCounter = 0
var maxchecker = 0
var checknum = 0
fun divider(N: Int)
{
    if(N != 0)
    {
        val quotient = N/2
        val remain = N%2
        if(remain == 1)
        {
            if(maxchecker < lengthCounter) maxchecker = lengthCounter
            lengthCounter = 0
            checknum = 1
        }
        else
        {
            if(checknum == 1)
            lengthCounter++
        }
        binarylink.append(remain)
        divider(quotient)
    }
}

fun main(args : Array<String>){

    val getlist = Scanner(System.`in`)
    val getint = getlist.nextLine().toInt()
    val getbinarynum = divider(getint)

    println(maxchecker)
}