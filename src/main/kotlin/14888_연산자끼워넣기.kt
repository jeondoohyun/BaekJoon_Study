import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


private var max = Integer.MIN_VALUE
private var min = Integer.MAX_VALUE
var num_arr = mutableListOf<Int>()
var oper_arr = mutableListOf<Int>()

fun main(args: Array<String>) {
//    val sc = Scanner(System.`in`)
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()

    num_arr = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    oper_arr = br.readLine().split(" ").map { it.toInt() }.toMutableList()

    dfs(num_arr[0], 1)
    println(max)
    println(min)
}

fun dfs(num: Int, index: Int) {
    if (index == num_arr.size) {
        max = Math.max(max, num)
        min = Math.min(min, num)
        return
    }
    for (i in oper_arr.indices) {
        if (oper_arr[i] > 0) {
            oper_arr[i]--
            if (i == 0) {
                dfs(num + num_arr[index], index + 1)
            } else if (i == 1) {
                dfs(num - num_arr[index], index + 1)
            } else if (i == 2) {
                dfs(num * num_arr[index], index + 1)
            } else {
                dfs(num / num_arr[index], index + 1)
            }
            oper_arr[i]++
        }
    }
}