import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

data class Jewelry(var M: Int, var V: Int)

fun main(args: Array<String>) {
    // 우선순위 큐를 사용 하여 푼다
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var arr = mutableListOf<Jewelry>()

    var N_K = br.readLine().split(" ").map { it.toInt() }

    for (i in 0 until N_K[0]) {
        var n_k = br.readLine().split(" ").map { it.toInt() }
        arr.add(Jewelry(n_k[0], n_k[1]))
    }

    var C = mutableListOf<Int>()
    for (i in 0 until N_K[1]) {
        C.add(br.readLine().toInt())
    }

    C.sort()

    var arr_2 = arr.sortedWith(Comparator { t, t2 ->
        when {
            t.V < t2.V -> 1
            t.V == t2.V -> when {
                t.M < t2.M -> -1
                else -> 1
            }
            else -> -1
        }
    })

    var result = 0
    var num = 0

    C.forEach {a ->
        run {
            arr_2.forEach {b ->
                if (a >= b.M) {
                    result += b.V
                    return@run
                }
            }
        }

    }

    bw.write("$result")
    bw.flush()
    bw.close()


}