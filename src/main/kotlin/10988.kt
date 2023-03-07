import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

fun main(args:Array<String>) {
    try {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        var input_string = br.readLine().toString()
        var chars = input_string.toCharArray()
        var result = 0

        if (input_string.length == 1) result = 1
        else {
            for (i in 0 until input_string.length/2) {
                if (chars[i] != chars[input_string.length-1-i]) {   // 배열 index는 0부터 시작이라 마지막 index는 -1해줘야됨
                    result = 0
                    break
                }
                result = 1
            }
        }

        bw.write(result.toString())
        bw.flush()
    } catch (e: Exception) {
        println(e.printStackTrace())
    }
}