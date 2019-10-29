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
/*
 * Complete the simpleArraySum function below.
 */
fun main(args: Array<String>) {
    fun formatMilitary(parts: List<Int>) = parts.joinToString(":") { "%02d".format(it) }
    val time = readLine()!!
    val values = time.removeSuffix("PM").removeSuffix("AM").split(":").map { it.toInt() }
    val military = if (time.endsWith("PM"))
        formatMilitary(listOf(
            if (values[0] < 12) values[0] + 12 else 12,
            values[1],
            values[2])
        )

    else
        formatMilitary(listOf(if (values[0] < 12) values[0] else 0, values[1], values[2]))
    println(military)
}

