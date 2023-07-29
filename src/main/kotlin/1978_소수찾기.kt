import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

fun main(args: Array<String>) {
    // 에라토스테네스의체를 사용하여 풀수도 있다

    try {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        var N = br.readLine().toInt()
        var integer = br.readLine().split(" ").map { it.toInt() }
        var cnt = 0

        integer.forEach {
            if (PrimalityCheck(it)) cnt++
        }

        bw.write("$cnt")
        bw.flush()
        bw.close()

    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun PrimalityCheck(a: Int): Boolean {
    if (a<2) return false  // 0,1은 소수가 아니다

    for (i in 2 until a) {
        if (a%i == 0) return false
    }

    return true
}