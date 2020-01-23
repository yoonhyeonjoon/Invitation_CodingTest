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

// Complete the gridSearch function below.


fun rowChecker(obj_rownum : Int, rownum : Int, colnum : Int, obj : String, target : String, G: Array<String>, P: Array<String>) : String
{
    val targetROI = target.substring(colnum, colnum + obj.length)
    if(obj == targetROI) //일치시 다음라인
    {
        if(P.size == obj_rownum + 1) //일치 라인이 끝다 다다른 경우, 일치 대상을 찾은 것이며 여기서 탈출한다.
        {
            return "YES"
        }
        else
        {
         val checkval = rowChecker(obj_rownum + 1, rownum + 1, colnum, P[obj_rownum + 1], G[rownum + 1], G, P)
            return checkval
        }

    }
    else
        return "NO"

}

fun gridSearch(G: Array<String>, P: Array<String>): String {

    var rownum = 0
    for(g in G)
    {
        var colnum = 0
        for(rc in g)
        {
            if(rc == P[0][0]) //첫글자가 일치할경우 비교 시작.
            {
                if((g.length + 1 - colnum - P[0].length) > 0 && g.substring(colnum, colnum+P[0].length) == P[0])
                {
                    // 첫열은 찾은 상태이며 여기서 문자열 비교를 한다.
                    val valuechecker = rowChecker(0, rownum, colnum, P[0], G[rownum], G, P)
                    if(valuechecker == "YES")
                        return valuechecker
                }
            }
            colnum++
        }
        rownum++
    }
    return "NO"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val RC = scan.nextLine().split(" ")
        val R = RC[0].trim().toInt()
        val C = RC[1].trim().toInt()
        val G = Array<String>(R, { "" })
        for (i in 0 until R) {
            val GItem = scan.nextLine()
            G[i] = GItem
        }

        val rc = scan.nextLine().split(" ")
        val r = rc[0].trim().toInt()
        val c = rc[1].trim().toInt()
        val P = Array<String>(r, { "" })
        for (i in 0 until r) {
            val PItem = scan.nextLine()
            P[i] = PItem
        }

        val result = gridSearch(G, P)

        println(result)
    }
}
