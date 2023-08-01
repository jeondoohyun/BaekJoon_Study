import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var T = br.readLine().toInt()


    var stringBuffer = StringBuffer()

    for (i in 0 until T) {
        var a = br.readLine().split(" ").map { it.toInt() }
        var a_descend = a.sortedDescending()
        stringBuffer.append("${a_descend[2]}\n")
    }

    bw.write(stringBuffer.toString())
    bw.flush()
    bw.close()

}