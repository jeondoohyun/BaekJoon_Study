import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    // https://scarlettb.tistory.com/57 10진수에서 2진수로 바꿀때 나머지를 이용한 알고리즘

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var T = br.readLine().toInt()

    var n = mutableListOf<Int>()
    var sb = StringBuffer()

    repeat(T) {
        n.add(br.readLine().toInt())
    }

    n.forEachIndexed { index, it ->
        var bin = it
        var index = 0
        while (bin > 0) {
            if (bin%2 == 1) {   // 10진수를 2로 나눠서 나머지가 1이면 2진수의 첫자리수가 1이다. 2로 나눴던 10진수를 다시 2로 나눠서 나머지가1이면 그 다음자리수가 1이다.
                sb.append("$index ")
            }
            bin /= 2
            index++
        }
        sb.append("\n")
    }

    bw.write("${sb.toString()}")
    bw.flush()
    bw.close()
}