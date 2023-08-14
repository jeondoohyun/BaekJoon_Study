import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

fun main(args: Array<String>) {
    try {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        // 도시 개수
        var N = br.readLine().toInt()

        // 버스 개수
        var M = br.readLine().toInt()

        // 버스 출발도시, 도착도시, 이용요금
        var bus_info = Array(M,{IntArray(3,{0})})

        bus_info.forEachIndexed { index, ints ->
            var bus = br.readLine().split(" ").map { it.toInt() }.toIntArray()
            bus_info[index] = bus
        }

        var a = br.readLine().split(" ").map { it.toInt() }
        var start = a[0] // 출발 도시
        var end = a[1]  // 도착 도시





    } catch (e: Exception) {
        e.printStackTrace()
    }



}