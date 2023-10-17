import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception
import java.util.*

fun main(args: Array<String>) = with(System.`in`.bufferedReader())  {


    val n = readLine().toInt()

    // 1일에 잡힌 상담 -> arr[0]일, arr[1]원
    val arr = Array(n) { readLine().split(" ").map { it.toInt() } }
    var a = readLine().toInt()


}
