import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var num_input = br.readLine().toInt()
    var N = num_input
    var num_result = -1
    var cycle = 0

    var num_10 = 0
    var num_1 = 0

    if (N < 10) num_10 = 10
    while (num_input != num_result) {

        var num_sum = (N / 10) + (N % 10)

        num_result = ((N % 10).toString() + (num_sum % 10).toString()).toInt()
        N = num_result
        cycle++
    }
    bw.write("$cycle")
    bw.flush()
    bw.close()
}