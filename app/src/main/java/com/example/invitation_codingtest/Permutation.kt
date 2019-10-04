import java.lang.Math.abs
import java.util.*
import kotlin.collections.*

var intglobal = 9999

fun comparing(t: MutableList<Int>, s: MutableList<Int>):Int
{
    var comp = 0
    for((index, ta) in t.withIndex())
        comp += abs(ta - s[index])
    return comp
}

fun permuationing(t: MutableList<Int>, s: MutableList<Int>, std_left:Int){
    var v: MutableList<Int>
    if (std_left == s.size - 1) {
        val comp = comparing(t, s)
        if(intglobal > comp)
            intglobal = comp
    }
    else {
        for ((i,_) in s.withIndex()) {
            v = swapping(s, Pair(std_left, i)).toMutableList()
            permuationing(t, v, std_left + 1)
            v = swapping(v, Pair(std_left, i)).toMutableList()
        }
    }
}

fun swapping(s: List<Int>, a : Pair<Int, Int>) : List<Int>
{
    var list_container = s.toMutableList()
    val tempor = s[a.first]
    list_container[a.first] = s[a.second]
    list_container[a.second] = tempor
    return list_container.toList()
}

// Complete the formingMagicSquare function below.
fun formingMagicSquare(s: Array<Array<Int>>): Int {

    val stacknumber = mutableMapOf(Pair(1, 0),Pair(2, 0),Pair(3, 0),Pair(4, 0),Pair(5, 0),Pair(6, 0),Pair(7, 0),Pair(8, 0),Pair(9, 0))

    for((index, sl) in s.withIndex())
    {
        for((index2, sl2) in sl.withIndex())
        {
            if(stacknumber[sl2] == null)
                stacknumber[sl2] = 0
            else
                stacknumber[sl2] = stacknumber[sl2]!! + 1
        }
    }

    /**add**/
    var minContainer = 999999

    var matchingA = mutableListOf<Pair<Int,Boolean>>()
    var matchingB = mutableListOf<Pair<Int,Boolean>>()

    var matchingA_valueonly = mutableListOf<Int>()
    var matchingB_valueonly = mutableListOf<Int>()

    //initializing
    for((getkey, getnum) in stacknumber)
    {
        if(getnum > 1)
        {
            matchingA.add(Pair(getkey, false))
            matchingA_valueonly.add(getkey)
        }
        else if(getnum == 0)
        {
            matchingB.add(Pair(getkey, false))
            matchingB_valueonly.add(getkey)
        }
    }

    permuationing(matchingA_valueonly, matchingB_valueonly, 0)


    return intglobal



}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = Array<Array<Int>>(3, { Array<Int>(3, { 0 }) })

    for (i in 0 until 3) {
        s[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    }

    val result = formingMagicSquare(s)

    println(result)
}