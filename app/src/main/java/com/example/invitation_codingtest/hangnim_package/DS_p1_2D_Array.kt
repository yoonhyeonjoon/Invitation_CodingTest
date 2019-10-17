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

// Complete the hourglassSum function below.
fun hourglassSum(arr: Array<Array<Int>>): Int {
    var maxcontainer = -81
    //squaring


    for((yindex,y) in arr.withIndex())
    {
        for((xindex, x) in y.withIndex()) //for((yindex, yy) in grid.withIndex())
        {

            // 1 2 3
            // 4 5 6
            // 7 8 9
            if(y.size - xindex > 2 && (arr.size - yindex > 2)) //오버플로우 이하일때만 동작
            {
                var orderer = 1
                var sumcontainer = 0
                for(yy in yindex..yindex+2)
                {
                    for(xx in xindex..xindex+2)
                    {
                        when(orderer)
                        {
                            1,2,3,5,7,8 -> {
                                sumcontainer += arr[yy][xx]
                                orderer++
                            }
                            9->{
                                sumcontainer += arr[yy][xx]
                                orderer = 1 //re-init
                            }
                            else -> {
                                orderer++ //do nothing
                            }
                        }
                    }
                }
                if(maxcontainer < sumcontainer)  maxcontainer = sumcontainer
            }

        }
    }

 return maxcontainer
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

    for (i in 0 until 6) {
        arr[i] = scan.nextLine()
            .split(" ")
            .map{ it.trim().toInt()}
            .toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}
