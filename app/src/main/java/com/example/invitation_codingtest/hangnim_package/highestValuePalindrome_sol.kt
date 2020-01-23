
import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    val k = sc.nextInt()
    sc.nextLine()
    val str = sc.nextLine()

    println(toPolindrom(str, k))
}

private fun toPolindrom(str: String, k: Int): String {

    val arr = str.toCharArray()

    var mismatches = 0
    for (i in 0 until arr.size / 2) {
        val match = arr[i] == arr[arr.size - 1 - i]
        if (!match) {
            ++mismatches
        }
    }

    if (mismatches > k) {
        return "-1"
    }

    var dk = k

    for (i in 0 until arr.size / 2) {
        // can change both
        val mismatch = arr[arr.size - 1 - i] != arr[i]
        if (dk - mismatches >= if (mismatch) 1 else 2) {
            if (mismatch) {
                --mismatches
            }
            if (arr[i] != '9') {
                arr[i] = '9'
                --dk
            }
            if (arr[arr.size - 1 - i] != '9') {
                arr[arr.size - 1 - i] = '9'
                --dk
            }
        } else if (mismatch) {
            // can change one digit only
            val max = if (arr[i] > arr[arr.size - 1 - i]) arr[i] else arr[arr.size - 1 - i]
            arr[arr.size - 1 - i] = max
            arr[i] = max
            --mismatches
            --dk
        }
    }

    if (dk >= 1 && str.length % 2 == 1) {
        arr[arr.size / 2] = '9'
        --dk
    }

    return String(arr)
}