import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    // 투포인터

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    // n: 재료의 갯수
    var n = br.readLine().toInt()

    // m: 갑옷을 만드는데 필요한 숫자
    var m = br.readLine().toInt()

    var arrNum = br.readLine().split(" ").map { it.toInt() }.sorted()

    var result_1940 = 0

    var low = 0
    var high = arrNum.size-1
    // 투포인터
    while (low<high) {
        if (arrNum[low] + arrNum[high] > m) high--
        else if (arrNum[low] + arrNum[high] < m) low++
        else {
            low++
            high--
            result_1940++
        }
    }

    bw.write(result_1940.toString())
    bw.flush()
    bw.close()

}
