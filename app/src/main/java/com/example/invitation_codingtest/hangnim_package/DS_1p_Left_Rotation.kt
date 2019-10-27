import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*



fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val nd = scan.nextLine().split(" ")
    val n = nd[0].trim().toInt()
    val d = nd[1].trim().toInt()
    val a = scan.nextLine()
    val b = a.split(" ").map { it.trim() }
    val c = b.map { it.toInt() }
    val e = c.toTypedArray() //컬렉션을 배열로 만들어준다.
    val f = c.take(d)
    val g = c.takeLast(n - d)
    val h = g + f
    //var stringbuilding = ""
    for (ni in h.indices)
    {
        print(h[ni])
        print(" ")
       // stringbuilding += String.format("%s ", h[ni])
    }

}
