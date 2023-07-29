import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

fun main(args: Array<String>) {

    try {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        var arr_int = mutableListOf<Int>()
        var sum = 0

        var bounds = br.readLine().split(" ").map { it.toInt() }

        for (i in 1 .. 1000) {
            for (j in 1 .. i) {
                arr_int.add(i)
            }
        }

        for (i in bounds[0]-1 .. bounds[1]-1) {
            sum += arr_int[i]
        }

        bw.write("$sum")
        bw.flush()
        bw.close()

    } catch (e: Exception) {
        e.printStackTrace()
    }
}