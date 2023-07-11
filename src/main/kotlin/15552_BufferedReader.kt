import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

// Scanner, println, readLine등은 비효율적으로 느리다.
// Scanner와 다르게 BufferedReader.readLine은 엔터로만 입력 완료된다(스페이스는 안됨)
fun main(args: Array<String>) {
    try {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        for (i in 1..br.readLine().toInt()) {
            var nums = br.readLine().split(" ")  // readLine을 space기준으로 나누기 위해 .split, readLine에서 입력을 받는다
            bw.write("${nums[0].toInt() + nums[1].toInt()}\n")  // 출력 작성
//            bw.flush()    // flush를 쓸때 한번에 출력이 된다
        }
        bw.flush()

    } catch (e: Exception) {
        println(e.printStackTrace())
    }
}