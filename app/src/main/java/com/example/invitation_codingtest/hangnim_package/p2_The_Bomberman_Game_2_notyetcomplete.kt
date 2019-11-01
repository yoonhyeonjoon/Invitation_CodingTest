package com.example.invitation_codingtest.hangnim_package

import com.example.invitation_codingtest.hangnim_package.container.c
import com.example.invitation_codingtest.hangnim_package.container.n
import com.example.invitation_codingtest.hangnim_package.container.r
import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*


//폭탄 터진 곳은 2초 뒤에 "." 안터진 곳은 "0", 1초뒤엔 모두"0"
//1스테이지
//
//6 7 5
//.......
//...O.O.
//....O..
//..O....
//OO...OO
//OO.O...
//
//4
//.......
//...O.O.
//....O..
//..O....      상태 저장
//OO...OO
//OO.O...
//
//3
//OO000OO
//OO000OO
//OO000OO       상태 기억
//OO000OO
//OO000OO
//OO000OO
//
//2
//000.0.0
//00.....
//00....0
//.......      변형 연산 및 상태 저장
//.......
//.......
//
//1
//OO000OO
//OO000OO
//OO000OO
//OO000OO           상태 기억
//OO000OO
//OO000OO
//
//0
//.......
//...0.0.
//...00..
//..0000.
//0000000
//0000000





//
//var stringgrid = calculatedGrid[yindex].toCharArray()
//stringgrid[xindex] = 'O'
//calculatedGrid[yindex] = stringgrid.joinToString("")


object container{
    var r : Int = 0
    var c : Int = 0
    var n : Int = 0
}

fun replaceStr2CharArray(str: String, ch: Char, index: Int): String {
    val chars = str.toCharArray()
    chars[index] = ch
    return String(chars)
}


fun stateDecider( coord : Pair<Int, Int>, max_coord : Pair<Int, Int>, move_coord : Pair<Int, Int> ) : Boolean
{
  return(
          -1  <  coord.first + move_coord.first
      &&  coord.first  + move_coord.first  < max_coord.first -1
      &&  -1  <  coord.second + move_coord.second
      &&  coord.second + move_coord.second < max_coord.second -1
  ) //move coord는 음의 값이 될 수 있다.
    //조건을 만족하면 true가 반환되고 아니라면 false가 반환된다.
}


// Complete the com.example.invitation_codingtest.hangnim_package.bomberMan function below.
fun bomberMan2(n: Int, grid: Array<String>): Array<String> {
    var nn = n
    var drawingGrid = grid.clone()
    var containerGrid = grid.clone()
    var resultGrid = grid.clone()
    var stagecheck = 1 // 0:bombcehck 1:bomball 2:afterbomb

    nn-- //먼저 하나 깍고 시작
    while(nn > 0)
    {
        nn--
        /**initialization*/
        for((yindex, yy) in grid.withIndex()) {
            val sb = StringBuilder()
            for(xx in 0 until c)
                sb.append(".")
            drawingGrid[yindex] = sb.toString()
        }

        when(stagecheck)
        {
            1 -> { //전체를 폭탄으로 메꾼것을 리턴, 콘테이너에는 폭탄이 터질 위치를 기억
                stagecheck = 2
                for((yindex, yy) in grid.withIndex())
                {
                    for((xindex, xx) in yy.withIndex())
                    {
                            //up
                            if(stateDecider(
                                    Pair(yindex, xindex),
                                    Pair(grid.size, yy.length),
                                    Pair(0, 1)
                                )
                            )
                            {
                                var stringgrid = containerGrid[yindex].toCharArray()
                                stringgrid[xindex] = 'O'
                                containerGrid[yindex] = stringgrid.joinToString("")
                            }
                            //down
                            if(stateDecider(
                                    Pair(yindex, xindex),
                                    Pair(grid.size, yy.length),
                                    Pair(1, 0)
                                )
                            )
                            {}
                            //left
                            if(stateDecider(
                                    Pair(yindex, xindex),
                                    Pair(grid.size, yy.length),
                                    Pair(1, 0)
                                )
                            )
                            {}
                            //right
                            if(stateDecider(
                                    Pair(yindex, xindex),
                                    Pair(grid.size, yy.length),
                                    Pair(1, 0)
                                )
                            )
                            {}
                    }
                }

            }
            2 -> { //기억된 폭탄터진 위치를 리턴, 폭탄이 터질 위치를 유지
                stagecheck = 1

            }
        }

    }


    return resultGrid
}


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val rcn = scan.nextLine().split(" ")

     r = rcn[0].trim().toInt()
     c = rcn[1].trim().toInt()
     n = rcn[2].trim().toInt()
//
//    val grid = Array<String>(r, { "" }
//
//    for (i in 0 until r) {
//        val gridItem = scan.nextLine()
//        grid[i] = gridItem
//    }
//
//    val result = bomberMan(n, grid)
//
//    println(result.joinToString("\n"))
}
