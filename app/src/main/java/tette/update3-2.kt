package tette
import kotlin.math.max

fun main(args : Array<String>){
    fun max2(Array :Array<Int> , Brray : MutableList<Char>) : Int{
        val Crray = Array.toMutableList()
        return if(Array.sortedArrayDescending()[0]==Array.sortedArrayDescending()[1]) {
            Crray.remove(Array.max()!!)
            val a=Crray.indexOf(Crray.max()!!)+1
            a
        } else Array.indexOf(Array.sortedArrayDescending()[1])
    }

    fun outputword(dp : MutableList<Char> , numberring : Array<Int>){

        if (dp.lastIndex>=1 &&
            dp[dp.lastIndex ] == arrayListOf('a','b','c')[numberring.indexOf(numberring.max())] &&
            dp[dp.lastIndex]==dp[dp.lastIndex-1]) {
            val a=max2(numberring,dp)
            dp.add(arrayListOf('a','b','c')[a])
            numberring[a]-=1
        }

        else{
            dp.add(arrayListOf('a','b','c')[numberring.indexOf(numberring.max())])
            numberring[numberring.indexOf(numberring.max())]-=1
        }
    }

    fun solution(A: Int, B: Int, C: Int): String {
        val numberring = listOf<Int>(A, B, C).toTypedArray()
        val dp = mutableListOf<Char>()

        if (numberring.sum() == 0){
            return ""
        }

        else while (numberring.sum() !=0){
            if (dp.size>=2 &&
                numberring.sum() == numberring.max() &&
                dp[dp.lastIndex] == dp[dp.lastIndex-1] &&
                dp[dp.lastIndex] == arrayListOf('a','b','c')[numberring.indexOf(numberring.max())]){
                break
            }
            outputword(dp,numberring)
        }
        return dp.joinToString ("")+dp.size.toString()
    }


    println("1 : "+solution(30,20,0))
    println("2 : "+solution(30,1,20))
    println("3 : "+solution(0,0,5))
    println("4 : "+solution(10,5,2))
    println("5 : "+solution(30,10,0))
    println("6 : "+solution(50,15,10))
    println("7 : "+solution(0,5,10))
    println("8 : "+solution(10,5,15))
    println("9 : "+solution(12,5,20))
    println("10 : "+solution(30,15,50))
    println("11 : "+solution(31,14,37))
    println("12 : "+solution(33,11,43))
}