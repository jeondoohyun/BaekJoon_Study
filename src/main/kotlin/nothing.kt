import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    try {
        var br = BufferedReader(InputStreamReader(System.`in`))
        var bw = BufferedWriter(OutputStreamWriter(System.out))

//        val alist = List<Int>(30, {it + 1})
        var output_list = mutableListOf<Int>()
        var input: String? = ""


        var cnt = br.readLine().toInt()
        var score_str = br.readLine().split(" ")

        var score_int = mutableListOf<Int>()
        score_str.forEach {
            score_int.add(it.toInt())
        }

        var score_max = Collections.max(score_int)

        println("$score_max , ${score_int.sum()}")

        bw.write("${(score_int.sum().toFloat() * 100 / score_max) / cnt}")
        bw.flush()
        bw.close()

    } catch (e: Exception) {
        print(e.printStackTrace())
    }
}
