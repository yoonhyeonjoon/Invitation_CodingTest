import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val scoresCount = scan.nextLine().trim().toInt()
    val scores = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    val aliceCount = scan.nextLine().trim().toInt()
    val alice = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()



    fun scoreswithalice (scores:Array<Int>, alice: Array<Int>, aliceCount:Int): MutableList<Int> {
        var result = MutableList<Int>(aliceCount,{i->0})
        for (i in 0 until aliceCount){
            val test = (scores+alice[i]).sortedArrayDescending().distinct().indexOf(alice[i]) // 같은 값을 가진 거 제거하는 함수임!
            result[i]=test+1
        }
        return result
    }

    val result =scoreswithalice(scores,alice,aliceCount)


    println(result.joinToString ("\n"))
}