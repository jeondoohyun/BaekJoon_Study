import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var be_pass = Passengers(0,0)

    var max = 0
    var pre = 0

    repeat(10) {
        var a = br.readLine().split(" ").map { it.toInt() }
        pre = pre - a[0] + a[1]

        if (pre > max) max = pre

        be_pass.outBus = a[0]
        be_pass.inBus = a[1]
    }

    bw.write("$max")
    bw.flush()
    bw.close()

}

data class Passengers(var outBus: Int, var inBus: Int)