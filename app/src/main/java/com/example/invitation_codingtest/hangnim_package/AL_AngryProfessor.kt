import java.util.*

fun main(args : Array<String>)
{
     val scan = Scanner(System.`in`)
     var iternum = scan.nextLine().toInt()

    while(iternum > 0)
    {
        val structure = scan.nextLine().split(" ")
        val stu_behavior = scan.nextLine().split(" ").map{ it.trim() }
        var stu_counter = 0
        for(j in stu_behavior)
        {
            when
            {
                (j.toInt()) <= 0 -> { stu_counter++ } //on time stu.
            }
        }

        if(structure[1].toInt() <= stu_counter) println("NO")
        else  println("YES")
        iternum--
    }


}