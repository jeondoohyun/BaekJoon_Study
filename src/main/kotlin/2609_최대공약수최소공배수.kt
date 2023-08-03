import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

fun main(args: Array<String>) {
    // 유클리드호제법(최대공약수 알고리즘)
    // 최대공약수 : 2개의 자연수(또는 정식) a, b에 대해서 a를 b로 나눈 나머지를 r이라 하면(단, a>b), a와 b의 최대공약수는 b와 r의 최대공약수와 같다. 이 성질에 따라, b를 r로 나눈 나머지 r'를 구하고, 다시 r을 r'로 나눈 나머지를 구하는 과정을 반복하여 나머지가 0이 되었을 때 나누는 수가 a와 b의 최대공약수이다.
    // 최소공배수 : a * b / 최대공약수
    try {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        var n1_n2 = br.readLine().split(" ").map { it.toInt() }
        var gcd = GCD(n1_n2[0], n1_n2[1])

        bw.write("$gcd\n${LCM(n1_n2[0], n1_n2[1], gcd)}")
        bw.flush()
        bw.close()

    } catch (e: Exception) {
        e.printStackTrace()
    }
}

// 유클리드호제법 최대공약수를 재귀함수를 사용하여 구현
fun GCD(n1: Int, n2: Int): Int {
    return if (n2 == 0) {   // n2로 들어오는 수는 n1 % n2(n1을 n2로 나눴을때의 나머지값)
        n1
    } else {
        GCD(n2, n1 % n2)  // 재귀 함수를 재호출할때 인자 값을 바꿔가며 재호출
    }
}

fun LCM(n1: Int, n2: Int, gcd: Int): Int {
    return n1 * n2 / gcd
}