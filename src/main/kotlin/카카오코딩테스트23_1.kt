import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {

    try {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        var n = br.readLine().toInt()

        var result = mutableListOf<Int>()

        var arr1 = br.readLine().split(" ").map { it.toInt() }
        var arr2 = br.readLine().split(" ").map { it.toInt() }

        for (i in 0 until n) {
            result.add(arr1[i] or arr2[i])  // 비트연산
        }

        var sb = StringBuffer()
        result.forEach { a ->
            var binary = Integer.toBinaryString(a)
            binary = binary.padStart(n,'0')     // n자리 까지 숫자가 채워지지 않으면 앞쪽에 0으로 채워 자리수를 맞춘다
            binary.forEach { b ->
                if (b.equals('0')) sb.append(" ")
                else sb.append("#")
            }
            sb.append("\n")
        }

        bw.write(sb.toString())
        bw.flush()
        bw.close()

    } catch (e: Exception) {
        e.printStackTrace()
    }

}