import java.io.*
import kotlin.math.max

var N_14501 = 0
lateinit var T: IntArray // 상담 소요 일수
lateinit var P: IntArray // 수익
var result_14501 = 0
fun main(args: Array<String>) {

    // 브루트포스 (완전탐색)
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))


    N_14501 = br.readLine().toInt() // 일할수 있는 날짜
    T = IntArray(N_14501) // 상담 소요 일수
    P = IntArray(N_14501) // 수익

    for (i in 0 until N_14501) {
        var (t,p) = br.readLine().split(" ").map { it.toInt() }
        T[i] = t
        P[i] = p
    }
    check14501(0,0, 0)

    bw.write(result_14501.toString())
    bw.flush()
    bw.close()

}

fun check14501(idx: Int, cnt: Int, total: Int) {
    var price = total

    // cnt : 다음상담 날짜
    // total : 수익 총액
    if (cnt >= N_14501) {
        result_14501 = max(result_14501, total)
        return
    }

    for (i in idx until N_14501) {
        var a = P[i]

        // i+T[i] : 다음상담 날짜
        if (i+T[i] <= N_14501) price += a   // 마지막날에 상담소요일 하루일 경우까지 수익금을 더해준다.
        check14501(i + T[i], i+T[i], price)
        if (i+T[i] <= N_14501) price -= a
    }
}