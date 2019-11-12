package tette



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

    fun solution(A: IntArray): Int {

        return (max2(A)!!)
    }


    println(solution(intArrayOf(1,1,0)))




}