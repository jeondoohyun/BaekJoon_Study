import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

fun main(args: Array<String>) {

    // https://ongveloper.tistory.com/132
    try {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        val chk = BooleanArray(26)  // 각 요소들은 false로 초기화

        chk[0] = true   // 인덱스 0 위치는 a 위치
        chk['i'-'a']=true   // i위치 true

        println("${'i'-'a'}")   // 8
        println("${'i'.toInt()}")   //
        println("${'a'.toInt()}")   //

        chk.forEach {
            println("$it")
        }



    } catch (e: Exception) {
        e.printStackTrace()
    }


}