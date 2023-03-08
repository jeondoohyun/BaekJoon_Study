import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

fun main(args:Array<String>) {
    try {

        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        var c = br.readLine().toInt()   // c: 테스트케이스

        for (i in 0 until c) {
            var input = br.readLine().split(" ")  // n: 학생의 수
            var n = input[0].toInt()    // n: 학생수
            var score_arr = IntArray(n)
            for (j in 0 until input.size-1) {
                score_arr[j] = input[j+1].toInt()
            }
            var score_average = score_arr.average()
            var cnt: Double = 0.0
            score_arr.forEach {
                if (it > score_average) cnt++
            }
            var ratio = (cnt/n)*100
            bw.write(String.format("%.3f", ratio) +"%\n")
        }
        bw.flush()

    } catch (e: Exception) {
        e.printStackTrace()
    }
}