import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

fun main(args:Array<String>) {
    try {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        var cnt = 1
        var input_cnt = br.readLine().toInt()
        var line_cnt = input_cnt * 2 - 1
        var stringBuffer = StringBuffer()
        for (i in 1 ..line_cnt) {
            if (i <= input_cnt) {
                for (j in input_cnt-i downTo 1) stringBuffer.append(" ")
                for (k in 1 .. 2 * i -1) stringBuffer.append("*")
            } else {
                for (j in 1 .. i-input_cnt) stringBuffer.append(" ")
                for (k in 1 .. (line_cnt - i) * 2 + 1 ) stringBuffer.append("*")
            }
            stringBuffer.append("\n")
        }
        bw.write(stringBuffer.toString())
        bw.flush()

    } catch (e: Exception) {

    }
}