import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private var N = 0
private var S = 0
private var left = 0
private var right = 0
private var answer2 = 100001
private var sum = 0
private lateinit var nums: List<Int>
fun main(args: Array<String>) {

    // https://youngest-programming.tistory.com/527
    try {

        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        var n_s = br.readLine().split(" ").map { it.toInt() }

        N = n_s[0]
        S = n_s[1]

        nums = br.readLine().split(" ").map { it.toInt() }
        while (true) {
            if (sum >= S) { //조건 만족
                sum -= nums[left]
                answer2 = Math.min(answer2, right - left) // 부분합 최소 길이 갱신
                left++ // 왼쪽 포인터 오른쪽으로 이동
            } else if (right == N) { //끝 도달
                break
            } else { // right포인터 오른쪽으로 이동
                sum += nums[right++]
            }
        }
        if (answer2 == 100001) {
            bw.write("0")
        } else {
            bw.write("$answer2")
        }

        bw.flush()
        bw.close()


    } catch (e: Exception) {
        e.printStackTrace()
    }


}