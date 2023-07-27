import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var N = br.readLine().toInt()
    var integers = br.readLine().split(" ").map { it.toInt() }

    var min = integers.sorted()

    bw.write("${min[0]} ${min[min.size-1]}")
    bw.flush()
    bw.close()

}