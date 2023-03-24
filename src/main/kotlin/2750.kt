import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

fun main(args: Array<String>) {
    /**
     * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
     * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
     */
    try {
        var br = BufferedReader(InputStreamReader(System.`in`))
        var bw = BufferedWriter(OutputStreamWriter(System.out))

        var nums = ArrayList<Int>()
        var N = br.readLine().toInt()
        for (i in 0 until N) {
            var input = br.readLine().toInt()
            nums.add(input)
        }
        nums.sort()     // 오름차순
        var sb = StringBuffer()

        nums.forEach {
            sb.append("$it\n")
        }
        bw.write(sb.toString())
        bw.flush()

    } catch (e: Exception) {

    }
}