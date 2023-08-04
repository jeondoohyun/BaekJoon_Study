import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

fun main(args: Array<String>) {
    try {
        var ess_char = charArrayOf('a','n','t','i','c') // char는 작은 따옴표 사용

        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        var N_K = br.readLine().split(" ").map { it.toInt() }   // 단어갯수 N, 알파벳갯수 K

        var st_arr = Array<String>(N_K[0]){""}

        for (i in 0 until N_K[0]) {
            st_arr[i] = br.readLine()
        }
        val st_arr_sort = st_arr.sortedWith(Comparator { o1, o2 ->
            o1.length - o2.length
        })

        var result = 0

        if (N_K[1] < 5) {   // 남극 시작과 끝에 들어가는 anta tica의 최소 알파벳 개수는 5개
            bw.write("0")
        } else if (N_K[1] == 26) {  // 알파벳 소문자만 하면 26개면 모든 알파벳을 사용할수 있기 때문에 모든 단어 읽기 가능
            bw.write("${N_K[0]}")
        } else {
            for (i in 0 until N_K[0]) {
//                var st_sub = st_arr[i].substring(0,4).substring(st_arr[i].length-4, st_arr[i].length)
                var st_sub = st_arr_sort[i].replace("anta","").replace("tica","")
                println(st_sub)
            }
        }






    } catch (e: Exception) {
        e.printStackTrace()
    }



}