import java.util.Collections.max

fun main(args : Array<String>){


        lateinit var arrspace : Array<Int?>

        fun sumcal(A: IntArray, setpoint : Int) : Int {
            var maxsaver1: Int? = null
            var maxsaver2: Int? = null
            var maxsaver3: Int? = null
            var maxsaver4: Int? = null
            var maxsaver5: Int? = null
            var maxsaver6: Int? = null

            if(setpoint == 0) return A[setpoint]

            //dice back 1
            if (setpoint - 1 >= 0) {
                if (arrspace[setpoint - 1] != null) {
                    maxsaver1 = A[setpoint] + arrspace[setpoint - 1]!!
                } else //null인 경우
                {
                    if (setpoint - 1 >= 0) {
                        maxsaver1 = A[setpoint] + sumcal(A, setpoint - 1)
                        arrspace[setpoint - 1] = maxsaver1 - A[setpoint]
                    } else maxsaver1 = null
                }
            }
            //dice back 2
            if (setpoint - 2 >= 0) {
                if (arrspace[setpoint - 2] != null) {
                    maxsaver2 = A[setpoint] + arrspace[setpoint - 2]!!
                } else //null인 경우
                {
                    if (setpoint - 2 >= 0) {
                        maxsaver2 = A[setpoint] + sumcal(A, setpoint - 2)
                        arrspace[setpoint - 2] = maxsaver2 - A[setpoint]
                    } else maxsaver2 = null
                }
            }

            //dice back 3
            if (setpoint - 3 >= 0) {
                if (arrspace[setpoint - 3] != null) {
                    maxsaver3 = A[setpoint] + arrspace[setpoint - 3]!!
                } else //null인 경우
                {
                    if (setpoint - 3 >= 0) {
                        maxsaver3 = A[setpoint] + sumcal(A, setpoint - 3)
                        arrspace[setpoint - 3] = maxsaver3 - A[setpoint]
                    } else maxsaver3 = null
                }
            }

            //dice back 4
            if (setpoint - 4 >= 0) {
                if (arrspace[setpoint - 4] != null) {
                    maxsaver4 = A[setpoint] + arrspace[setpoint - 4]!!
                } else //null인 경우
                {
                    if (setpoint - 4 >= 0) {
                        maxsaver4 = A[setpoint] + sumcal(A, setpoint - 4)
                        arrspace[setpoint - 4] = maxsaver4 - A[setpoint]
                    } else maxsaver4 = null
                }
            }

            //dice back 5
            if (setpoint - 5 >= 0) {
                if (arrspace[setpoint - 5] != null) {
                    maxsaver5 = A[setpoint] + arrspace[setpoint - 5]!!
                } else //null인 경우
                {
                    if (setpoint - 5 >= 0) {
                        maxsaver5 = A[setpoint] + sumcal(A, setpoint - 5)
                        arrspace[setpoint - 5] = maxsaver5 - A[setpoint]
                    } else maxsaver5 = null
                }
            }

            //dice back 6
            if (setpoint - 6 >= 0) {
                if (arrspace[setpoint - 6] != null) {
                    maxsaver3 = A[setpoint] + arrspace[setpoint - 6]!!
                } else //null인 경우
                {
                    if (setpoint - 6 >= 0) {
                        maxsaver6 = A[setpoint] + sumcal(A, setpoint - 6)
                        arrspace[setpoint - 6] = maxsaver6 - A[setpoint]
                    } else maxsaver6 = null
                }
            }


            var tempormax = maxsaver1!!

            if(maxsaver2 != null && tempormax < maxsaver2) tempormax = maxsaver2
            if(maxsaver3 != null && tempormax < maxsaver3) tempormax = maxsaver3
            if(maxsaver4 != null && tempormax < maxsaver4) tempormax = maxsaver4
            if(maxsaver5 != null && tempormax < maxsaver5) tempormax = maxsaver5
            if(maxsaver6 != null && tempormax < maxsaver6) tempormax = maxsaver6
            return tempormax
    }


    fun solution(A: IntArray): Int {
        // write your code in Kotlin
        return sumcal(A, A.size-1)
    }


    var A = intArrayOf(1,-2,0,9,-1,-2)
    arrspace = Array<Int?>(A.size){null}

    println(solution(A))

}