import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

fun main(args: Array<String>) {
    // 완전탐색(전부다 차례로 확인하는것)
    // 데이터가 9가지 밖에 안주어지기 때문에 그냥 다 더해도 오래 걸리지 않는다. 7개를 더해서 100을 확인하던가 9개를 더한값에서 2개데이터를 빼서 100을 만들던가
    try {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        var 아홉난쟁이 = mutableListOf<Int>()

        repeat(9) {
            아홉난쟁이.add(br.readLine().toInt())
        }

        var sum = 아홉난쟁이.sum()
        var flag = false

        for (i in 0..7) {
            for (j in i+1 .. 8) {
                var result = sum - 아홉난쟁이[i] - 아홉난쟁이[j]  // 왜 IndexOutOfBound가 뜨지
                if (result == 100) {
                    아홉난쟁이.removeAt(i)   // 요소를 빼버려서 리스트 인덱스가 짧아졌는데 for문 계속 돌리면 indexOutOfBound
                    아홉난쟁이.removeAt(j-1) // 위에서 i index를 빼버렸기 때문에 한칸이 짧아져서 j-1을 해줘야 j위치의 요소값을 뺄수 있다
                    아홉난쟁이.sort()
                    flag = true
                    break
                }
            }
            if (flag) break
        }

        아홉난쟁이.forEach{
            bw.write("$it\n")
        }
        bw.flush()
        bw.close()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}