package com.example.invitation_codingtest.hangnim_package

import java.lang.Integer.min
import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.math.max
import kotlin.ranges.*
import kotlin.text.*

//6 7 5
//.......
//...O.O.
//....O..
//..O....
//OO...OO
//OO.O...

//...X.X.
//..XOXOX
//..XXOX.
//XXOXXXX
//OOXXXOO
//OOXOXXX

fun replaceCharUsingCharArray(str: String, ch: Char, index: Int): String {
    val chars = str.toCharArray()
    chars[index] = ch
    return String(chars)
}

// Complete the com.example.invitation_codingtest.hangnim_package.bomberMan function below.
fun bomberMan(n: Int, grid: Array<String>): Array<String> {
    var nn = n
    var transedGrid = grid.clone()
    var allbombGrid = grid.clone()
    var calculatedGrid = grid.clone()
    var calculatedinverseGrid = grid.clone()
    var resultGrid = grid.clone()
    var stagecheck = 1 // 0:bombcehck 1:bomball 2:afterbomb
    nn-- //먼저 하나 깍고 시작

    for((yindex, y) in transedGrid.withIndex())
    {
        var rowstr = ""
        for((xindex, x) in y.withIndex())
        {
            rowstr = rowstr + "."
        }
        allbombGrid[yindex] = rowstr
    }

    while(nn > 0)
    {
        nn--
        when(stagecheck)
        {
            1-> {
                stagecheck = 2
                for((yindex, y) in transedGrid.withIndex())
                {
                    var rowstr = ""
                    for((xindex, x) in y.withIndex()) {
                        rowstr = rowstr + "."
                    }
                    calculatedGrid[yindex] = rowstr
                }
                /**여기서 폭탄 체크**/
                for((yindex, y) in transedGrid.withIndex())
                        {
                            for((xindex, x) in y.withIndex())
                            {
                                when
                                {
                                    transedGrid[yindex][xindex] == 'O' -> {
                                        var stringgrid = calculatedGrid[yindex].toCharArray()
                                        stringgrid[xindex] = 'O'
                                        calculatedGrid[yindex] = stringgrid.joinToString("")
                                    }
                                    transedGrid[min(yindex+1, transedGrid.size-1)][xindex] == 'O' -> {
                                        var stringgrid = calculatedGrid[yindex].toCharArray()
                                        stringgrid[xindex] = 'O'
                                        calculatedGrid[yindex] = stringgrid.joinToString("")
                                }
                                    transedGrid[yindex][min(xindex+1, y.length-1)] == 'O' -> {
                                        var stringgrid = calculatedGrid[yindex].toCharArray()
                                        stringgrid[xindex] = 'O'
                                        calculatedGrid[yindex] = stringgrid.joinToString("")
                                    }
                                    transedGrid[max(yindex-1,0)][xindex]  == 'O' -> {
                                        var stringgrid = calculatedGrid[yindex].toCharArray()
                                        stringgrid[xindex] = 'O'
                                        calculatedGrid[yindex] = stringgrid.joinToString("")
                                    }
                                    transedGrid[yindex][max(xindex-1, 0)]  == 'O' -> {
                                        var stringgrid = calculatedGrid[yindex].toCharArray()
                                        stringgrid[xindex] = 'O'
                                        calculatedGrid[yindex] = stringgrid.joinToString("")
                                    }
                                }

                            }
                        }
                resultGrid = transedGrid
//                println(String.format("------------%s-------", nn))
//                println(calculatedGrid.joinToString("\n"))

            }
            2-> {
                //make bomb inverse state
                stagecheck = 1
                for((yindex, y) in transedGrid.withIndex())
                {
                    for((xindex, x) in y.withIndex())
                    {
                        when
                        {
                            calculatedGrid[yindex][xindex] == 'O' -> {
                                var stringgrid = calculatedinverseGrid[yindex].toCharArray()
                                stringgrid[xindex] = '.'
                                calculatedinverseGrid[yindex] = stringgrid.joinToString("")
                            }

                            calculatedGrid[yindex][xindex] == '.' -> {
                                var stringgrid = calculatedinverseGrid[yindex].toCharArray()
                                stringgrid[xindex] = 'O'
                                calculatedinverseGrid[yindex] = stringgrid.joinToString("")
                            }
                        }

                    }
                }
                transedGrid = calculatedinverseGrid
                resultGrid = allbombGrid
//                println(String.format("------------%s-------", nn))
//                println(transedGrid.joinToString("\n"))



            }
            else -> {

            }
        }

    }
    return resultGrid
}




fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val rcn = scan.nextLine().split(" ")
    val r = rcn[0].trim().toInt()
    val c = rcn[1].trim().toInt()
    val n = rcn[2].trim().toInt()

    val grid = Array<String>(r, { "" })
    for (i in 0 until r) {
        val gridItem = scan.nextLine()
        grid[i] = gridItem
    }

    val result = bomberMan(n, grid)

    println(result.joinToString("\n"))
}
