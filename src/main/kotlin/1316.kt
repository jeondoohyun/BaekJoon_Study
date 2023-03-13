import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

fun main(args:Array<String>) {
    try {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        var N = br.readLine().toInt()   // 단어 개수 N
        var groupWordCnt = 0

        var list = ArrayList<String>()  // 문자가 중복되는지 확인하는 배열
        var check = true
        for (i in 1 .. N) {
            list.removeAll(list)
            var inputWord = br.readLine().toString()
//            println("$inputWord")
            run {
                inputWord.forEach {
                    if (!list.contains(it.toString())) {
                        list.add(it.toString())
                    } else {
                        if (list.size > 1 && !list[list.size-1].contains(it)) {
                            check = false
                            return@run
                        }
                    }
                }
            }
            if (check) groupWordCnt++
        }
        bw.write(groupWordCnt.toString())
        bw.flush()

    } catch (e: Exception) {
        e.printStackTrace()
    }
}