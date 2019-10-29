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
import kotlin.math.min
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*






fun main(args: Array<String>) {


    val scan = Scanner(System.`in`)
    val rcn = scan.nextLine().split(" ")
    val r = rcn[0].trim().toInt()
    val c = rcn[1].trim().toInt()
    val n = rcn[2].trim().toInt()
    fun doublearray_toarray(grid : Array<Array<String>>) : Array<String>{
        var resultarray =Array(r,{""})
        for (k in 0 until r) {
            var regrid = Array(c, { "" })
            for (j in 0 until c) {
                regrid = Array(c, { j -> grid[k][j] })
            }
            resultarray[k] = regrid.joinToString("")
        }
        return resultarray
    }
    fun bomberMan(n: Int, grid: Array<Array<String>>): Array<String> {

        val resultarray =Array(r,{""})
        var savegrid = grid
        var result =Array(r,{""})
        if ((n == 0) or  (n==1)) {
            result = doublearray_toarray(grid)
        }

        else if (n%2==0 ){
            for (k in 0 until r){
                var regrid = Array(c) { "" }
                for (j in 0 until c) {
                    regrid = Array(c) { j -> "O" }
                }
                resultarray[k] = regrid.joinToString("")
            }
            result = resultarray
        }
        else {

            for (count in 3.. n step 2) {
                var changegrid = Array(r, { Array(c, { "O" }) })
                for (k in 0 until r) {
                    for (j in 0 until c) {
                        if (savegrid[k][j] == ".") {
                            if (k == 0 && j == 0) {
                                if (savegrid[k + 1][j] == "O") {
                                    changegrid[k][j] = "."
                                }
                                if (savegrid[k + 1][j] == "O") {
                                    changegrid[k][j] = "."
                                }
                            } else if (k == r - 1 && j == c - 1) {
                                if (savegrid[k - 1][j] == "O") {
                                    changegrid[k][j] = "."
                                }
                                if (savegrid[k][j - 1] == "O") {
                                    changegrid[k][j] = "."
                                }
                            } else if (k == 0 && j == c - 1) {
                                if (savegrid[k + 1][j] == "O") {
                                    changegrid[k][j] = "."
                                }
                                if (savegrid[k][j - 1] == "O") {
                                    changegrid[k][j] = "."
                                }
                            } else if (k == r - 1 && j == 0) {
                                if (savegrid[k - 1][j] == "O") {
                                    changegrid[k][j] = "."
                                }
                                if (savegrid[k][j + 1] == "O") {
                                    changegrid[k][j] = "."
                                }
                            } else if (k == 0) {
                                if (savegrid[k + 1][j] == "O") {
                                    changegrid[k][j] = "."
                                }
                                if ((savegrid[k][j-1] == "O") or (savegrid[k][j +1] == "O")) {
                                    changegrid[k][j] = "."
                                }
                            } else if (k == r - 1) {
                                if (savegrid[k - 1][j] == "O") {
                                    changegrid[k][j] = "."
                                }
                                if ((savegrid[k][j  -1] == "O") or (savegrid[k][j + 1] == "O")) {
                                    changegrid[k][j] = "."
                                }
                            } else if (j == 0) {
                                if ((savegrid[k + 1][j] == "O") or (savegrid[k  -1][j] == "O")) {
                                    changegrid[k][j] = "."
                                }
                                if (savegrid[k][j + 1] == "O") {
                                    changegrid[k][j] = "."
                                }
                            } else if (j == c - 1) {
                                if ((savegrid[k  -1][j] == "O") or (savegrid[k + 1][j] == "O")) {
                                    changegrid[k][j] = "."
                                }
                                if (savegrid[k][j - 1] == "O") {
                                    changegrid[k][j] = "."
                                }
                            } else {
                                if ((savegrid[k  -1][j] == "O") or (savegrid[k + 1][j] == "O") or(savegrid[k ][j+1] == "O") or (savegrid[k ][j-1] == "O")) {
                                    changegrid[k][j] = "."
                                }
                            }
                        }
                        else if (savegrid[k][j] == "O") {
                            changegrid[k][j] = "."
                        }
                    }
                }
                savegrid = changegrid
            }
            result = doublearray_toarray(savegrid)
        }

        return result
    }

    val grid = Array(r, {Array<String>(c,{""})})
    for (i in 0 until r) {
        val gridItem = scan.nextLine().map { it.toString() }
        for (j in 0 until c) {
            grid[i][j] = gridItem[j]
        }
    }

    val result = bomberMan(n, grid)
    println(result.joinToString("\n") )//jointostring이 두갠데 하나는 안되고 하나는 됨
}

