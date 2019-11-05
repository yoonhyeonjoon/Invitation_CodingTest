import android.service.autofill.Validators.and
import java.util.*

fun main(args : Array<String>){


    fun solution(A: IntArray): Int {

        var checkmax = 0
        val bitsetcheck = BitSet(A.size)
        var resultnum = 0
        for(idx in A.indices)
        {
            checkmax = Math.max(checkmax, A[idx])
            bitsetcheck.set(A[idx], true)
            val getbit = bitsetcheck.get(0,checkmax)
            if(bitsetcheck.cardinality() == checkmax)
                resultnum++
        }
        return resultnum
    }

    var A = intArrayOf(1,2,7,4,5,6,3)
  //  var A = intArrayOf(1,5,3,4,2,15, 40,9,6)
    val B = solution(A)
    println(B)

}