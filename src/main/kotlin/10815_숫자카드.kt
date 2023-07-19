import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    // 시간초과 떴음, 이진탐색(이분탐색) 사용할것
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    br.readLine().toInt()
    var sangunCard = br.readLine().split(" ").map { it.toInt() }.sorted()
    br.readLine().toInt()
    var compareCard = br.readLine().split(" ").map { it.toInt() }

    var stringBuffer = StringBuffer()

    compareCard.forEach { a ->
        stringBuffer.append(bSearch(a, sangunCard))
    }

    bw.write(stringBuffer.toString())
    bw.flush()
    bw.close()
}

// 이진탐색 알고리즘
fun bSearch(target: Int, arr: List<Int>): String {
    var low = 0
    var high = arr.lastIndex
    var mid = 0

    while (low <= high) {
        mid = (low + high) / 2

        when {
            arr[mid] < target   -> low = mid + 1
            arr[mid] > target   -> high = mid - 1
            arr[mid] == target  -> return "1 "
        }
    }

    return "0 "
}