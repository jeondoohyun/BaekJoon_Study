import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var N_K = br.readLine().split(" ").map { it.toInt() }
    var array = mutableListOf<Int>()

    for (i in 1 .. N_K[0]) {
        if ((N_K[0] % i)==0) {
            array.add(i)
            if (array.size == N_K[1]) break
        }
    }

    if (array.size < N_K[1]) bw.write("0")
    else bw.write("${array[N_K[1]-1]}")
    bw.flush()
    bw.close()

}