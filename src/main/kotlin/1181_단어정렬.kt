import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

fun main(args: Array<String>) {
    /**
     * N개의 단어가 입력 되면 다음과 같은 조건에 맞게 정렬을 하시오. 1) 길이가 짧은 것부터 2) 길이가 같으면 사전 순으로 3)중복된 단어는 하나만 남기고 제거 해야한다.
     */
    try {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        var N = br.readLine().toInt()
        var ArrayString = ArrayList<String>()

        for (i in 0 until N) {
            ArrayString.add(br.readLine())
        }

        bw.write("${ArrayString.size}")
        bw.flush()


    } catch (e: Exception) {
        e.printStackTrace()
    }
}