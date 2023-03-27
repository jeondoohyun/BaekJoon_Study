import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

fun main(args: Array<String>) {
    /**
     * 첫째줄 사람수 N을 받고 둘째줄 각 사람이 돈을 인출하는데 걸리는 시간 P를 받고 가장 빠른 시간을 배열하여 시간을 구하시오
     */
    try {
        var br = BufferedReader(InputStreamReader(System.`in`))
        var bw = BufferedWriter(OutputStreamWriter(System.out))

        br.readLine()   // N을 굳이 받지 않고 P를 띄어쓰기 기준으로 배열로 받아도 알고리즘에 지장이 없다. 다만 첫째줄에 입력을 받아야 하기 때문에 readLine()을 넣어준다.
        var P_string = br.readLine().split(" ")
        var P_int = ArrayList<Int>()

        P_string.forEach {
            P_int.add(it.toInt())
        }

        P_int.sort()    // 내장 함수를 사용 하여 오름차순 정렬을 함

        var result = 0
        var temp = 0

        P_int.forEach {
            temp += it
            result += temp
        }

        bw.write("$result")
        bw.flush()

    } catch (e: Exception) {
        e.printStackTrace()
    }
}