import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

fun main(args: Array<String>) {
    try {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        var inputs = br.readLine().split(" ")

        var N = inputs[0].toInt()
        var M = inputs[1].toInt()

        var basket_1 = Array<Int>(N) { i -> i+1 }  // N은 사이즈, i+1 대신 i로 쓰면 0~9 까지 들어가기 때문에 i+1로 써준다, 1~10 까지 들어간 값으로 초기화 됨
        var basket_2 = basket_1.copyOf()

        for (i in 1..M) {
            var rotate = br.readLine().split(" ") // index 0 : start, 1 : end, 2 : mid

            var start = rotate[0].toInt() - 1
            var end = rotate[1].toInt() - 1
            var mid = rotate[2].toInt() - 1

            var cnt = start
            for (j in mid..end) {
                basket_2[cnt] = basket_1[j]
                cnt++
            }
            for (j in start until mid) {
                basket_2[cnt] = basket_1[j]
                cnt++
            }
            basket_1 = basket_2.copyOf()
        }
        var stringBuffer = StringBuffer()
        basket_1.forEach { stringBuffer.append(it.toString()+" ") }

        bw.write(stringBuffer.toString())
        bw.flush()

    } catch (e: Exception) {

    }

}