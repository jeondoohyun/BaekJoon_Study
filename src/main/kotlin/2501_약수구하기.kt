import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var N_K = br.readLine().split(" ").map { it.toInt() }
    var sb = StringBuffer()

    for (i in 1 .. N_K[0]) {
        if ((N_K[0] % i)==0 &&
                i==N_K[1]) {
            sb.append(i.toString())
            break
        }
    }

    if (sb.isEmpty()) sb.append("0")

    bw.write(sb.toString())
    bw.flush()
    bw.close()

    // todo : 백준 제출 하면 틀렸다고 나옴
}