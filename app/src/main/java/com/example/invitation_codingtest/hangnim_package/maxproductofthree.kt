import kotlin.math.absoluteValue

fun main(args : Array<String>){

    data class dataset(var num1 : Int? = null, var num2 : Int? = null, var num3 : Int? = null)

    fun powerstackplus(ds : dataset, putnum : Int)
    {
        // 넘1 > 넘2> 넘3
        if(ds.num1 == null)
        {
            ds.num1 = putnum
        }
        else if(ds.num2 == null)
        {
            ds.num2 = putnum
        }
        else if(ds.num3 == null)
        {
            ds.num3 = putnum
        }
        else //값이 모두 채워져 있을경우.
        {
            if(putnum >= ds.num1!!)
            {
                ds.num3 = ds.num2
                ds.num2 = ds.num1
                ds.num1 = putnum
            }
            else if(ds.num2!! <= putnum && putnum < ds.num1!! )
            {
                ds.num3 = ds.num2
                ds.num2 = putnum
            }
            else if(ds.num3!! <= putnum && putnum < ds.num2!! )
            {
                ds.num3 = putnum
            }
        }

    }
    fun powerstackminus(dsminus : dataset, putnum : Int)
    {
        // 넘1 > 넘2> 넘3
        if(dsminus.num1 == null)
        {
            dsminus.num1 = putnum
        }
        else if(dsminus.num2 == null)
        {
            dsminus.num2 = putnum
        }
        else if(dsminus.num3 == null)
        {
            dsminus.num3 = putnum
        }
        else
        {
            var num1ab =  dsminus.num1!!.absoluteValue
            var num2ab =  dsminus.num2!!.absoluteValue
            var num3ab =  dsminus.num3!!.absoluteValue
            var putnumab = putnum.absoluteValue
            if(putnumab >= num1ab)
            {
                num3ab = num2ab
                num2ab = num1ab
                num1ab = putnumab
            }
            else if(num2ab <= putnumab && putnumab < num1ab )
            {
                num3ab = num2ab
                num2ab = putnumab
            }
            else if(num3ab <= putnumab && putnumab < num2ab )
            {
                num3ab = putnumab
            }
            dsminus.num1 = -num1ab
            dsminus.num2 = -num2ab
            dsminus.num3 = -num3ab
        }

    }

    fun powerstackminus_minimum(dsminus : dataset, putnum : Int)
    {
        // 넘1 > 넘2> 넘3
        if(dsminus.num1 == null)
        {
            dsminus.num1 = putnum
        }
        else if(dsminus.num2 == null)
        {
            dsminus.num2 = putnum
        }
        else if(dsminus.num3 == null)
        {
            dsminus.num3 = putnum
        }
        else
        {
            var num1ab =  dsminus.num1!!.absoluteValue
            var num2ab =  dsminus.num2!!.absoluteValue
            var num3ab =  dsminus.num3!!.absoluteValue
            var putnumab = putnum.absoluteValue
            if(putnumab >= num1ab)
            {
                num3ab = num2ab
                num2ab = num1ab
                num1ab = putnumab
            }
            else if(num2ab <= putnumab && putnumab < num1ab )
            {
                num3ab = num2ab
                num2ab = putnumab
            }
            else if(num3ab <= putnumab && putnumab < num2ab )
            {
                num3ab = putnumab
            }
            dsminus.num1 = -num1ab
            dsminus.num2 = -num2ab
            dsminus.num3 = -num3ab
        }

    }

    fun multiple(ds : dataset, dsminus : dataset) : Int
    {
//        //곱하는 방법은 무조건 4개
//
//        //+++ 000
//        if(ds.num1 != null && ds.num2 != null && ds.num3 != null)
//        {val case1 = ds.num1!!* ds.num2!!* ds.num3!!}
//        //++0 -00
//        if(ds.num1 != null && ds.num2 != null && ds.num3 != null)
        return 0
    }

    fun solution(A: IntArray): Int {

        var array = Array(A.size){0}
        var ds = dataset()
        var dsminus = dataset()
        for(idx in array.indices)
        {
            //array[idx] = A[idx]
            if(A[idx] > 0)
            powerstackplus(ds, A[idx])
            else
            powerstackminus(dsminus, A[idx])
        }
        return multiple(ds, dsminus)

    }


    var A = intArrayOf(-2, -3, -5, -6, 0)
    val B = solution(A)
    print(B)

}