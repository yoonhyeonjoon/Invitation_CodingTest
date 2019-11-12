package tette

import kotlin.math.max


fun main(args : Array<String>){
    fun max2(Array :IntArray) : Int{

        val Crray = Array.toMutableList()
        if(Array.sortedArrayDescending()[0]==Array.sortedArrayDescending()[1]) {
            Crray.remove(Array.max()!!)
            val a=Crray.indexOf(Crray.max()!!)+1
            return a
        }
        else return Array.indexOf(Array.sortedArrayDescending()[1])
    }

    fun solution(A: Int, B: Int, C: Int): String {

        var numberring = listOf<Int>(A, B, C).toTypedArray()
        val Chararray = charArrayOf('A','B', 'C')
        var dp = mutableListOf<Char>()
        var i = 2
        if (numberring.sum() == 0){

        }

        else if (numberring.sum() ==1){
            dp.add(Chararray[numberring.indexOf(numberring.max())])
        }
        else if (numberring.sum() ==2){
            dp.add(Chararray[numberring.indexOf(numberring.max())])
            numberring[numberring.indexOf(numberring.max())]-=1
            dp.add(Chararray[numberring.indexOf(numberring.max())])
        }

        else {
            dp.add(Chararray[numberring.indexOf(numberring.max())])
            numberring[numberring.indexOf(numberring.max())] -= 1
            dp.add(Chararray[numberring.indexOf(numberring.max())])
            numberring[numberring.indexOf(numberring.max())] -= 1

            while (numberring.sum() != 0) {
                if (dp[i - 1] != Chararray[numberring.indexOf(numberring.max())]) {
                    dp.add(Chararray[numberring.indexOf(numberring.max())])
                    numberring[numberring.indexOf(numberring.max())] -= 1
                    i += 1
                }

                else if (numberring.sum() == numberring.max() && dp[dp.size-1]==dp[dp.size-2]) {
                    break
                }
                else if (dp[i - 1] == Chararray[numberring.indexOf(numberring.max())]){
                    if (dp[i-2]==dp[i-1]){
                        val a= max2(numberring.toIntArray())
                        dp.add(Chararray[a])
                        numberring[a] -= 1
                        i += 1
                    }
                    else {
                        dp.add(Chararray[numberring.indexOf(numberring.max())])
                        numberring[numberring.indexOf(numberring.max())] -= 1
                        i += 1
                    }
                }

            }
        }

        return dp.joinToString ("")+dp.size.toString()
    }

    println("1 : "+solution(3,1,0))


}