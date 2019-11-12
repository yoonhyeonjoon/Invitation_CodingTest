package tette
import kotlin.math.max

fun main(args : Array<String>){
    fun max2(Array :Array<Int> , Brray : MutableList<Char>) : Int{
        val Crray = Array.toMutableList()
        return if(Array.sortedArrayDescending()[0]==Array.sortedArrayDescending()[1] &&
            Brray[Brray.lastIndex]== arrayListOf('a','b','c')[Array.indexOf(Array.sortedArrayDescending()[0])]) {
            Crray.remove(Array.max()!!)
            val a=Crray.indexOf(Crray.max()!!)+1
            a
        } else Array.indexOf(Array.sortedArrayDescending()[1])
    }

    fun outputword(dp : MutableList<Char> , numberring : Array<Int>){
        dp.add(arrayListOf('a','b','c')[numberring.indexOf(numberring.max())])
        numberring[numberring.indexOf(numberring.max())]-=1
    }

    fun solution(A: Int, B: Int, C: Int): String {
        val numberring = listOf<Int>(A, B, C).toTypedArray()
        val Chararray = charArrayOf('a','b', 'c')
        val dp = mutableListOf<Char>()
        var i = 2
        if (numberring.sum() == 0){
            return ""
        }
        else if (numberring.sum() ==1){
            outputword(dp,numberring)
        }
        else if (numberring.sum() !=0){
            outputword(dp,numberring)
            outputword(dp,numberring)
            while (numberring.sum() != 0){
                if (dp[i - 1] == Chararray[numberring.indexOf(numberring.max())] &&
                    dp[i-2]==dp[i-1]){
                    if (numberring.sum() == numberring.max()){
                        break
                    }
                    val a=max2(numberring,dp)
                    dp.add(arrayListOf('a','b','c')[a])
                    numberring[a]-=1
                    i+=1
                }
                else{
                    outputword(dp,numberring)
                    i+=1
                }

            }
        }
        return dp.joinToString ("")+dp.size.toString()
    }

    println("1 : "+solution(1,1,0))
    println("2 : "+solution(3,1,0))
    println("3 : "+solution(0,0,0))
    println("4 : "+solution(30,1,20))
    println("5 : "+solution(30,0,20))
    println("6 : "+solution(0,13,0))
    println("7 : "+solution(0,1,5))
    println("8 : "+solution(9,1,2))
    println("9 : "+solution(3,1,0))
    println("10 : "+solution(3,1,0))

}