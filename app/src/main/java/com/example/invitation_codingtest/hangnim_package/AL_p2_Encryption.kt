import java.lang.Math.sqrt
import java.lang.StringBuilder
import java.util.*
import kotlin.math.sqrt

//hackerrank.com/challenges/encryption/problem

fun main(args: Array<String>)
{
    val scannerfun = Scanner(System.`in`)
    val contextline = scannerfun.nextLine().trim()
    val lengthbox = sqrt(contextline.length.toFloat())
    var row = 0; var col = 0
    when (lengthbox - lengthbox.toInt())
    {
        0.toFloat() -> {row = lengthbox.toInt(); col = lengthbox.toInt()} //case of integer
        else -> {row = lengthbox.toInt(); col = lengthbox.toInt() + 1} //not integer
    }
    if(row * col < contextline.length)
        row++

    var chunkedset = contextline.chunked(col)
    var temperset2 = ""
    if(chunkedset[chunkedset.lastIndex].length != col)
    {
        val temperset = chunkedset[chunkedset.lastIndex].toCharArray()
        var remained = col - chunkedset[chunkedset.lastIndex].length
        val blankset = " ".repeat(remained)
        temperset2 =  (temperset + blankset.toCharArray()).joinToString("")
    }
    else
        temperset2 = chunkedset[chunkedset.lastIndex]

    val stringset = StringBuilder()
    for(x in 0 until col)
    {
        for(y in 0 until row)
        {
            if(y == row - 1) {
                if(temperset2[x] != ' ')
                stringset.append(temperset2[x])
            }
            else{
                stringset.append(chunkedset[y][x])
            }

        }
        stringset.append(" ")
    }
    println(stringset.toString())

}