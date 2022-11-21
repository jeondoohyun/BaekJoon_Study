import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var a: String?
    while (br.readLine().also { a = it } != null && a != "0 0") {
        var nums = a?.split(" ")
        bw.write("${nums?.get(0)?.toInt()!! + nums?.get(1)?.toInt()!!}\n")
    }

    bw.flush()

}