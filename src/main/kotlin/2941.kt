import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

fun main(args:Array<String>) {
    try {
        var tran = arrayOf<String>("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=")

        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        var input = br.readLine()

        tran.forEach {
            if (input.contains(it)) {
                input = input.replace(it,".")   // 크로아티아 알파벳 갯수만 알면 되기 때문에 크로아티아 알파벳을 갯수 하나인 . 로 치환
            }
        }
        bw.write("${input.length}")
        bw.flush()

    } catch (e: Exception) {
        print(e.printStackTrace())
    }
}