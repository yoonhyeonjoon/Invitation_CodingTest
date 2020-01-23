import java.io.*
import java.util.*

fun main(args: Array<String>) {

    val vectors: List<Pair<Int, Int>> =
        (-1..1).map { x ->
            (-1..1).map { y ->
                x to y
            }
        }.flatten() - (0 to 0)

    Scanner(System.`in`).run {
        val n = nextInt()
        val k = nextInt()
        val queen = nextInt() to nextInt()
        val obstacles = (1..k).map { nextInt() to nextInt() }.toSet()

        val nRange = 1..n

        vectors.asSequence().map { (dx, dy) ->
            generateSequence(queen) { (x, y) ->
                (x + dx) to (y + dy)
            }
            .drop(1).takeWhile {
                val (x, y) = it
                (x in nRange) && (y in nRange) && (it !in obstacles)
            }.count()
        }.sum()

    }.also(::println)
}