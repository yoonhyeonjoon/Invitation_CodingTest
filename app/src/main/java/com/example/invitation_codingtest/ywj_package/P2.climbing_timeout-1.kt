import java.util.*





/*
https://www.hackerrank.com/rest/contests/master/challenges/climbing-the-leaderboard/hackers/mponkin/download_solution
위의 창에서 얻어갈수 있는거
scan.nextInt()하면 int를 차례로 입력 받는 형식으로 만들수 있다. 여기서 sort를 사용 안하고 중복되는 것도 동신에 처리함.
이게 시간 줄이는 방법인듯!. 그러니까 sortedarraydescending 이랑 distinct를 배열 만들고 나서 사용하여 시간을 끄는게 아니라
배열을 만드는 과정속에서 처리해줌으로 시간 단축!
\
 */



fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val scoresCount = scan.nextLine().trim().toInt()
    val scores = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()


    val aliceCount = scan.nextLine().trim().toInt()
    val alice = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    val scoresort = scores.asSequence().toSortedSet().reversed().toTypedArray()


    fun scoreswithalice (scores:Array<Int>, alice: Array<Int>, aliceCount:Int): Array<Int> {
        for (i in 0 until aliceCount) {
            for (j in 1 until scores.size) {
                if (alice[i]>=scores[0]) {
                    alice[i] = 1
                    break
                }
                else if (alice[i]<scores[scores.size-1]){
                    alice[i]=scores.size+1
                    break
                }
                else if (alice[i] >= scores[j]){
                    alice[i]= j+1
                    break
                }
            }
        }
        return alice
    }
    val result =scoreswithalice(scoresort,alice,aliceCount)
    println(result.joinToString ("\n"))
}