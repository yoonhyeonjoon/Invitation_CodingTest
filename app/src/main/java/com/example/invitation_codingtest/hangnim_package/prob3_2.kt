import java.util.Collections.max

fun main(args : Array<String>){



    fun charout(inint : Int) : Char = when(inint) {
        0-> 'a'
        1-> 'b'
        else -> 'c'
    }

    fun secondmax(numarr : Array<Int>, maxidx : Int) : Int
    {
        if(0 == maxidx){
            if(numarr[1] > numarr[2]) return 1
            else return 2
        }
        if(1 == maxidx){
            if(numarr[0] > numarr[2]) return 0
            else return 2
        }
        if(2 == maxidx){
            if(numarr[0] > numarr[1]) return 0
            else return 1
        }
        return 0
    }

    fun dp(strarr: MutableList<Char>, numarr : Array<Int>, order : Int) : Int
    {
        //012 'a''b''c'
//
        if (numarr[0] == 0 && numarr[1] == 0 && numarr[2] == 0)
        { return 0 }
        else {
            when {
                order == 0 -> {
                    val maxidx = numarr.indexOf(numarr.max())
                    if(numarr[maxidx] <= 0) return 0 //작아버리면 리턴 시킴
                    strarr.add(charout(maxidx))
                    numarr[maxidx]--
                }
                order == 1 -> {
                    val maxidx = numarr.indexOf(numarr.max())
                    if(numarr[maxidx] <= 0) return 0 //작아버리면 리턴 시킴
                    strarr.add(charout(maxidx))
                    numarr[maxidx]--
                }
                else -> { //str 2 이상일때
                    //2개가 같은 수가 나온다면?
                    if (strarr.takeLast(2)[0] == strarr.takeLast(2)[1]) {
                        val maxidx = numarr.indexOf(numarr.max())
                        if (charout(maxidx) == strarr.takeLast(1)[0]) //문자가 같다면 문제가 생긴것.
                        {
                            val sndmax = secondmax(numarr, maxidx)
                            if(numarr[sndmax] <= 0) return 0 //작아버리면 리턴 시킴
                            strarr.add(charout(sndmax))
                            numarr[sndmax]--
                        } else //문자가 다르다면 그냥 쓰면됨
                        {
                            val maxidx = numarr.indexOf(numarr.max())
                            if(numarr[maxidx] <= 0) return 0 //작아버리면 리턴 시킴
                            strarr.add(charout(maxidx))
                            numarr[maxidx]--
                        }
                    }
                    //2개가 같은 수가 나오지않았다면 최대값 수가 들어가면된다.
                    else {
                        val maxidx = numarr.indexOf(numarr.max())
                        if(numarr[maxidx] <= 0) return 0 //작아버리면 리턴 시킴
                        strarr.add(charout(maxidx))
                        numarr[maxidx]--
                    }

                }
            }
            return 1
        }
    }

  fun solution(A: Int, B: Int, C: Int): String {
   val strarr = mutableListOf<Char>()
   var numarr = arrayOf(A,B,C)
   var counter = 0
   while(true)
   {
        if(dp(strarr, numarr, counter) == 0)
            break
        counter++
   }
   return strarr.joinToString ("") + " / " + strarr.size.toString()
  }

//   println("1 : "+solution(30,20,0))
//   println("2 : "+solution(30,1,20))
//   println("3 : "+solution(0,0,5))
//   println("4 : "+solution(10,5,2))
//   println("5 : "+solution(30,10,0))
//   println("6 : "+solution(50,15,10))
//   println("7 : "+solution(0,5,10))
//    println("8 : "+solution(10,5,15))
//    println("9 : "+solution(12,5,20))
//    println("10 : "+solution(30,15,50))
//    println("11 : "+solution(31,14,37))
//    println("12 : "+solution(33,11,43))

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
    println("10 : "+solution(0,1,0))
    println("10 : "+solution(0,0,1))
    println("10 : "+solution(0,0,2))
    println("10 : "+solution(2,0,2))
    println("10 : "+solution(0,2,0))
    println("10 : "+solution(0,2,2))
//



}