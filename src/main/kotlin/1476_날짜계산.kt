import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 브루트 포스
// 나머지 연산 %을 사용하려고 햇는데 e가 15인경우까지 표시 되야 되는데 %15를 하면 결과값이 0으로 되서 오히려 복잡해짐
fun main(args: Array<String>) {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    // 1 <= e <= 15
    // 1 <= s <= 28
    // 1 <= m <= 19
    var (e,s,m) = br.readLine().split(" ").map { it.toInt() }

    var result = 0
    var flagCheck = true
    var eC = 0
    var sC = 0
    var mC = 0
    while (flagCheck) {
        result++
        eC++
        sC++
        mC++

        if (eC == 16) eC = 1
        if (sC == 29) sC = 1
        if (mC == 20) mC = 1

        if (e==eC && s==sC && m==mC) flagCheck = false
    }

    bw.write(result.toString())
    bw.flush()
    bw.close()
}