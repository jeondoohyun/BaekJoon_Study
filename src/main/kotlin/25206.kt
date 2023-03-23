import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

fun main(args: Array<String>) {
    try {

        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        var N_M = br.readLine().split(" ")
        var N = N_M[0].toInt()
        var M = N_M[1].toInt()

        var A = ArrayList<ArrayList<Int>>()
        var B = ArrayList<ArrayList<Int>>()

        for (i in 0 until N) {
            A.add(ArrayList())
            var temp = br.readLine().split(" ")
            temp.forEach {
                A[i].add(it.toInt())
            }
        }

        var sb = StringBuffer()
        for (i in 0 until N) {
            B.add(ArrayList())
            var temp = br.readLine().split(" ")
            temp.forEachIndexed { index, s ->
                sb.append("${A[i][index]+s.toInt()} ")
            }
            sb.append("\n")
        }
        bw.write(sb.toString())
        bw.flush()

    } catch (e: Exception) {
        e.printStackTrace()
    }
}