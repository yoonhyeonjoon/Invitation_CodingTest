import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

//fun moveQueen(r_q: Int, c_q: Int) : Pair<Int, Int>
//{
//
//}

fun queensAttack(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: Array<Array<Int>>): Int {

    //1. 퀸을 기점으로 8방향을 순차 접근
    //2. 장애물을 만나면 접근은 break.
    //3. 끝을 만나도 break
    //4. 퀸의 이동은 1,1 / 1,-1 / -1,1 / -1,-1 / ... 8방향이며 계속됨

    // 시간방향으로 서술. 칼럼이 x좌표
    // step 1. 9시
    var totalcounter = 0
    var isObsThere = false
    var movecounter = 1
    while(c_q - movecounter > 0)
    {
        for(obs in obstacles)
        {
            if(obs[1] == c_q - movecounter && obs[0] == r_q) //같다면 장애물 만남
            {
                isObsThere = true
                break
            }
        }
        if(isObsThere) break

        //위 조건을 다 통과한다면
        movecounter++
        totalcounter++
    }


    //11시
    isObsThere = false
    movecounter = 1
    while( 0 < c_q - movecounter && r_q + movecounter < n + 1 )
    {
        for(obs in obstacles)
        {
            if( c_q - movecounter == obs[1] &&  r_q + movecounter == obs[0]) //좌표가 같다면 장애물 만남
            {
                isObsThere = true
                break
            }
        }
        if(isObsThere) break

        //위 조건을 다 통과한다면
        movecounter++
        totalcounter++
    }

    //12시
    isObsThere = false
    movecounter = 1
    while( r_q + movecounter < n + 1 )
    {
        for(obs in obstacles)
        {
            if( c_q == obs[1] &&  r_q + movecounter == obs[0]) //좌표가 같다면 장애물 만남
            {
                isObsThere = true
                break
            }
        }
        if(isObsThere) break

        //위 조건을 다 통과한다면
        movecounter++
        totalcounter++
    }


    //1시
    isObsThere = false
    movecounter = 1
    while(c_q + movecounter < n + 1 && r_q + movecounter < n + 1 )
    {
        for(obs in obstacles)
        {
            if( c_q + movecounter == obs[1] &&  r_q + movecounter == obs[0]) //좌표가 같다면 장애물 만남
            {
                isObsThere = true
                break
            }
        }
        if(isObsThere) break

        //위 조건을 다 통과한다면
        movecounter++
        totalcounter++
    }

    //3시
    isObsThere = false
    movecounter = 1
    while(c_q + movecounter < n + 1)
    {
        for(obs in obstacles)
        {
            if( c_q + movecounter == obs[1] &&  r_q  == obs[0]) //좌표가 같다면 장애물 만남
            {
                isObsThere = true
                break
            }
        }
        if(isObsThere) break

        //위 조건을 다 통과한다면
        movecounter++
        totalcounter++
    }

    //5시
    isObsThere = false
    movecounter = 1
    while(c_q + movecounter < n + 1 &&  0 <  r_q - movecounter)
    {
        for(obs in obstacles)
        {
            if( c_q + movecounter == obs[1] &&   r_q - movecounter  == obs[0]) //좌표가 같다면 장애물 만남
            {
                isObsThere = true
                break
            }
        }
        if(isObsThere) break

        //위 조건을 다 통과한다면
        movecounter++
        totalcounter++
    }

    //6시
    isObsThere = false
    movecounter = 1
    while(0 < r_q - movecounter)
    {
        for(obs in obstacles)
        {
            if( c_q == obs[1] && r_q - movecounter == obs[0]) //좌표가 같다면 장애물 만남
            {
                isObsThere = true
                break
            }
        }
        if(isObsThere) break

        //위 조건을 다 통과한다면
        movecounter++
        totalcounter++
    }


    //8시
    isObsThere = false
    movecounter = 1
    while(0 < r_q - movecounter && 0 < c_q - movecounter)
    {
        for(obs in obstacles)
        {
            if( c_q - movecounter == obs[1] && r_q - movecounter == obs[0]) //좌표가 같다면 장애물 만남
            {
                isObsThere = true
                break
            }
        }
        if(isObsThere) break

        //위 조건을 다 통과한다면
        movecounter++
        totalcounter++
    }


    return totalcounter
}

fun main(args: Array<String>) {

    val scan = Scanner(System.`in`)
    val nk = scan.nextLine().split(" ")
    val n = nk[0].trim().toInt()
    val k = nk[1].trim().toInt()
    val r_qC_q = scan.nextLine().split(" ")
    val r_q = r_qC_q[0].trim().toInt()
    val c_q = r_qC_q[1].trim().toInt()
    val obstacles = Array(k) { Array(2) { 0 } }

    for (i in 0 until k) {
        obstacles[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    }

    val result = queensAttack(n, k, r_q, c_q, obstacles)

    println(result)
}
