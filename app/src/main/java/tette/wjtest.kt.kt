import java.util.*

fun main(args: Array<String>) {


    val scan = Scanner(System.`in`)
    val rcn = scan.nextLine().split(" ")
    val r = rcn[0].trim().toInt()
    val c = rcn[1].trim().toInt()
    val n = rcn[2].trim().toInt()
    val grid = Array(r, {Array<String>(c,{""})})

    for (i in 0 until r) {
        val gridItem = scan.nextLine().map { it.toString() }
        for (j in 0 until c) {
            grid[i][j] = gridItem[j]
        }
    }

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
        when {
            (n == 0) or  (n==1) -> result = doublearray_toarray(grid)
            n%2==0 -> {
                for (k in 0 until r){
                    var regrid = Array(c) { "" }
                    for (j in 0 until c) {
                        regrid = Array(c) { j -> "O" }
                    }
                    resultarray[k] = regrid.joinToString("")
                }
                result = resultarray
            }
            else -> when {
                n==3 -> {
                    repeat(1) {
                        val changegrid = Array(r, { Array(c, { "O" }) })
                        for (k in 0 until r) {
                            for (j in 0 until c) {
                                if (savegrid[k][j] == "O") {
                                    if (r == 1) {
                                        if (j == 0 && c != 1) {
                                            changegrid[k][j] = "."
                                            changegrid[k][j + 1] = "."
                                        } else if (j == c - 1 && c != 1) {
                                            changegrid[k][j] = "."
                                            changegrid[k][j - 1] = "."
                                        } else {
                                            changegrid[k][j] = "."
                                            changegrid[k][j + 1] = "."
                                            changegrid[k][j - 1] = "."
                                        }
                                    } else if (c == 1) {
                                        if (k == 0 && r != 1) {
                                            changegrid[k][j] = "."
                                            changegrid[k + 1][j] = "."
                                        } else if (k == r - 1 && r != 1) {
                                            changegrid[k][j] = "."
                                            changegrid[k - 1][j] = "."
                                        } else {
                                            changegrid[k][j] = "."
                                            changegrid[k + 1][j] = "."
                                            changegrid[k - 1][j] = "."
                                        }
                                    } else if (k == 0) {
                                        when (j) {
                                            0 -> {
                                                changegrid[k][j] = "."
                                                changegrid[k + 1][j] = "."
                                                changegrid[k][j + 1] = "."
                                            }
                                            in 1..c - 2 -> {
                                                changegrid[k][j] = "."
                                                changegrid[k + 1][j] = "."
                                                changegrid[k][j + 1] = "."
                                                changegrid[k][j - 1] = "."
                                            }
                                            c - 1 -> {
                                                changegrid[k][j] = "."
                                                changegrid[k][j - 1] = "."
                                                changegrid[k + 1][j] = "."
                                            }
                                        }
                                    } else if (k in 1..r - 2) {
                                        when (j) {
                                            0 -> {
                                                changegrid[k][j] = "."
                                                changegrid[k + 1][j] = "."
                                                changegrid[k][j + 1] = "."
                                                changegrid[k - 1][j] = "."
                                            }
                                            in 1..c - 2 -> {
                                                changegrid[k][j] = "."
                                                changegrid[k + 1][j] = "."
                                                changegrid[k][j + 1] = "."
                                                changegrid[k][j - 1] = "."
                                                changegrid[k - 1][j] = "."
                                            }
                                            c - 1 -> {
                                                changegrid[k][j] = "."
                                                changegrid[k][j - 1] = "."
                                                changegrid[k + 1][j] = "."
                                                changegrid[k - 1][j] = "."
                                            }
                                        }
                                    } else if (k == r - 1) {
                                        when (j) {
                                            0 -> {
                                                changegrid[k][j] = "."
                                                changegrid[k - 1][j] = "."
                                                changegrid[k][j + 1] = "."
                                            }
                                            in 1..c - 2 -> {
                                                changegrid[k][j] = "."
                                                changegrid[k - 1][j] = "."
                                                changegrid[k][j + 1] = "."
                                                changegrid[k][j - 1] = "."
                                            }
                                            c - 1 -> {
                                                changegrid[k][j] = "."
                                                changegrid[k][j - 1] = "."
                                                changegrid[k - 1][j] = "."
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        savegrid = changegrid
                    }
                    result = doublearray_toarray(savegrid)
                }
                n%4==1 -> {
                    repeat(2) {
                        var changegrid = Array(r, { Array(c, { "O" }) })
                        for (k in 0 until r) {
                            for (j in 0 until c) {
                                if (savegrid[k][j] == "O") {
                                    if (r == 1) {
                                        if (j == 0 && c != 1) {
                                            changegrid[k][j] = "."
                                            changegrid[k][j + 1] = "."
                                        } else if (j == c - 1 && c != 1) {
                                            changegrid[k][j] = "."
                                            changegrid[k][j - 1] = "."
                                        } else {
                                            changegrid[k][j] = "."
                                            changegrid[k][j + 1] = "."
                                            changegrid[k][j - 1] = "."
                                        }
                                    } else if (c == 1) {
                                        if (k == 0 && r != 1) {
                                            changegrid[k][j] = "."
                                            changegrid[k + 1][j] = "."
                                        } else if (k == r - 1 && r != 1) {
                                            changegrid[k][j] = "."
                                            changegrid[k - 1][j] = "."
                                        } else {
                                            changegrid[k][j] = "."
                                            changegrid[k + 1][j] = "."
                                            changegrid[k - 1][j] = "."
                                        }
                                    } else if (k == 0) {
                                        if (j == 0) {
                                            changegrid[k][j] = "."
                                            changegrid[k + 1][j] = "."
                                            changegrid[k][j + 1] = "."
                                        } else if (j in 1..c - 2) {
                                            changegrid[k][j] = "."
                                            changegrid[k + 1][j] = "."
                                            changegrid[k][j + 1] = "."
                                            changegrid[k][j - 1] = "."
                                        } else if (j == c - 1) {
                                            changegrid[k][j] = "."
                                            changegrid[k][j - 1] = "."
                                            changegrid[k + 1][j] = "."
                                        }
                                    } else if (k in 1..r - 2) {
                                        if (j == 0) {
                                            changegrid[k][j] = "."
                                            changegrid[k + 1][j] = "."
                                            changegrid[k][j + 1] = "."
                                            changegrid[k - 1][j] = "."
                                        } else if (j in 1..c - 2) {
                                            changegrid[k][j] = "."
                                            changegrid[k + 1][j] = "."
                                            changegrid[k][j + 1] = "."
                                            changegrid[k][j - 1] = "."
                                            changegrid[k - 1][j] = "."
                                        } else if (j == c - 1) {
                                            changegrid[k][j] = "."
                                            changegrid[k][j - 1] = "."
                                            changegrid[k + 1][j] = "."
                                            changegrid[k - 1][j] = "."
                                        }
                                    } else if (k == r - 1) {
                                        when (j) {
                                            0 -> {
                                                changegrid[k][j] = "."
                                                changegrid[k - 1][j] = "."
                                                changegrid[k][j + 1] = "."
                                            }
                                            in 1..c - 2 -> {
                                                changegrid[k][j] = "."
                                                changegrid[k - 1][j] = "."
                                                changegrid[k][j + 1] = "."
                                                changegrid[k][j - 1] = "."
                                            }
                                            c - 1 -> {
                                                changegrid[k][j] = "."
                                                changegrid[k][j - 1] = "."
                                                changegrid[k - 1][j] = "."
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        savegrid = changegrid
                    }
                    result = doublearray_toarray(savegrid)
                }
                n%4==3 -> {
                    repeat(3) {
                        var changegrid = Array(r, { Array(c, { "O" }) })
                        for (k in 0 until r) {
                            for (j in 0 until c) {
                                if (savegrid[k][j] == "O") {
                                    if (r == 1) {
                                        if (j == 0 && c != 1) {
                                            changegrid[k][j] = "."
                                            changegrid[k][j + 1] = "."
                                        } else if (j == c - 1 && c != 1) {
                                            changegrid[k][j] = "."
                                            changegrid[k][j - 1] = "."
                                        } else {
                                            changegrid[k][j] = "."
                                            changegrid[k][j + 1] = "."
                                            changegrid[k][j - 1] = "."
                                        }
                                    } else if (c == 1) {
                                        if (k == 0 && r != 1) {
                                            changegrid[k][j] = "."
                                            changegrid[k + 1][j] = "."
                                        } else if (k == r - 1 && r != 1) {
                                            changegrid[k][j] = "."
                                            changegrid[k - 1][j] = "."
                                        } else {
                                            changegrid[k][j] = "."
                                            changegrid[k + 1][j] = "."
                                            changegrid[k - 1][j] = "."
                                        }
                                    } else if (k == 0) {
                                        when (j) {
                                            0 -> {
                                                changegrid[k][j] = "."
                                                changegrid[k + 1][j] = "."
                                                changegrid[k][j + 1] = "."
                                            }
                                            in 1..c - 2 -> {
                                                changegrid[k][j] = "."
                                                changegrid[k + 1][j] = "."
                                                changegrid[k][j + 1] = "."
                                                changegrid[k][j - 1] = "."
                                            }
                                            c - 1 -> {
                                                changegrid[k][j] = "."
                                                changegrid[k][j - 1] = "."
                                                changegrid[k + 1][j] = "."
                                            }
                                        }
                                    } else if (k in 1..r - 2) {
                                        if (j == 0) {
                                            changegrid[k][j] = "."
                                            changegrid[k + 1][j] = "."
                                            changegrid[k][j + 1] = "."
                                            changegrid[k - 1][j] = "."
                                        } else if (j in 1..c - 2) {
                                            changegrid[k][j] = "."
                                            changegrid[k + 1][j] = "."
                                            changegrid[k][j + 1] = "."
                                            changegrid[k][j - 1] = "."
                                            changegrid[k - 1][j] = "."
                                        } else if (j == c - 1) {
                                            changegrid[k][j] = "."
                                            changegrid[k][j - 1] = "."
                                            changegrid[k + 1][j] = "."
                                            changegrid[k - 1][j] = "."
                                        }
                                    } else if (k == r - 1) {
                                        if (j == 0) {
                                            changegrid[k][j] = "."
                                            changegrid[k - 1][j] = "."
                                            changegrid[k][j + 1] = "."
                                        } else if (j in 1..c - 2) {
                                            changegrid[k][j] = "."
                                            changegrid[k - 1][j] = "."
                                            changegrid[k][j + 1] = "."
                                            changegrid[k][j - 1] = "."
                                        } else if (j == c - 1) {
                                            changegrid[k][j] = "."
                                            changegrid[k][j - 1] = "."
                                            changegrid[k - 1][j] = "."
                                        }
                                    }
                                }
                            }
                        }
                        savegrid = changegrid
                    }
                    result = doublearray_toarray(savegrid)
                }
            }
        }

        return result
    }


    val result = bomberMan(n, grid)
    println(result.joinToString("\n") )//jointostring이 두갠데 하나는 안되고 하나는 됨
}

