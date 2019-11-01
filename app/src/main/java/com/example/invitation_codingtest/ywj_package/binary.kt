import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val input = scan.nextLine().toInt()

    fun binary_make(number: Int): MutableList<String> {
        var numberuse = number
        var numberlist = mutableListOf<String>()
        var step = 0
        while (numberuse != 0) {
            if (numberuse % 2 == 0) {
                numberlist.add("0")
                numberuse /= 2
                step += 1
            } else if (numberuse % 2 == 1) {
                numberlist.add("1")
                numberuse = (numberuse - 1) / 2
                step += 1
            }
        }
        return numberlist.reversed().joinToString("").split("1").toMutableList()
    }

    fun count0(args: MutableList<String>): Int {
        val arraysize = args.size
        var count = 0
        if (arraysize == 2) {
            count = 0
            return count
        } else if (args[arraysize - 1] == "") {
            for (i in 1 until arraysize) {
                var a = args[i].split(" ")[0].split("")
                if (a.size - 2 > count)
                    count = a.size - 2
            }
        } else for (i in 1 until arraysize - 1) {
            var a = args[i].split(" ")[0].split("")
            if (a.size - 2 > count)
                count = a.size - 2
        }
        return count
    }

    val result = binary_make(input)
    val a = count0(result)
    println(a)
}
