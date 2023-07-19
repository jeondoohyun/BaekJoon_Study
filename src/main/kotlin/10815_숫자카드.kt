import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    // 시간초과 떴음
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    br.readLine().toInt()
    var sangunCard = br.readLine().split(" ")
    br.readLine().toInt()
    var compareCard = br.readLine().split(" ")

    var stringBuffer = StringBuffer()

    compareCard.forEach { a ->
        run {   // forEach를 break하기 위해 run사용
            sangunCard.forEachIndexed { i, b ->
                if (a == b) {
                    stringBuffer.append("1 ")
                    return@run
                }
                if ( (i + 1) == sangunCard.size) stringBuffer.append("0 ")
            }
        }
    }

    bw.write(stringBuffer.toString())
    bw.flush()
    bw.close()
}