import java.io.*
import java.lang.Integer.min
import java.math.*
import java.text.*
import java.util.*
import java.util.regex.*


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val n = scan.nextLine().trim().toInt()
    val p = scan.nextLine().trim().toDouble()

    if( n == p.toInt() ) println(0)
    else
    {
    val p_oddeven = p.toDouble() / 2.0
    val p_oddeven_int = p.toInt() / 2
    var n_total_page = 0
    var p_taget= 0.0
    n_total_page  = n /2
    when(p_oddeven - p_oddeven_int)
    {
        0.0 -> {p_taget = p/2 }
        0.5 -> {p_taget = (p+1)/2}
    }
    val checker = kotlin.math.min(n_total_page-p_taget, p_taget - 1).toInt()

    println(checker)
    }
}
