import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

fun main(args: Array<String>) {

    try {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        var input = br.readLine()

        var arrayNum = mutableListOf<Int>()

        var i = 0
        var cnt = 0
        run {
            while (i < input.length) {
                // 문자(char)를 toInt()하면 아스키코드로 전환, 문자열(string)을 toInt()하면 숫자로 변환
                if (input[i].toInt() in 48..57) { // 문자가 숫자일경우
                    cnt++
                    if (input[i+1].toInt() in 48 .. 57) {   // 2자리 숫자일 경우
                        var num = ("${input[i]}" + "${input[i+1]}").toInt()
                        arrayNum.add(num)
                        i+=2    // 2자리 숫자라 다음 숫자까지 입력이 되었기때문에 다음숫자 index는 뛰어 넘기기위해 +2를 해준다
                        continue
                    }
                    arrayNum.add(input[i].toString().toInt())
                    i++
                    continue
                }

                if (input[i].equals('S')) {
                    arrayNum[cnt-1] = arrayNum[cnt-1].toFloat().pow(1).toInt()
                    i++
                    continue
                }

                if (input[i].equals('D')) {
                    arrayNum[cnt-1] = arrayNum[cnt-1].toFloat().pow(2).toInt()
                    i++
                    continue
                }

                if (input[i].equals('T')) {
                    arrayNum[cnt-1] = arrayNum[cnt-1].toFloat().pow(3).toInt()
                    i++
                    continue
                }

                if (input[i].equals('*')) {
                    i++
                    if (cnt>1) {
                        arrayNum[cnt-2] *= 2
                    }
                    arrayNum[cnt-1] *= 2
                    continue
                }

                if (input[i].equals('#')) {
                    i++
                    arrayNum[cnt-1] *= -1
                }
            }
        }

        bw.write("${arrayNum[0]+arrayNum[1]+arrayNum[2]}")
        bw.flush()
        bw.close()



    } catch (e: Exception) {
        e.printStackTrace()
    }

}