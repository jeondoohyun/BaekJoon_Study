import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

fun main(args: Array<String>) {
    // 유클리드호제법 : 2개의 자연수(또는 정식) a, b에 대해서 a를 b로 나눈 나머지를 r이라 하면(단, a>b), a와 b의 최대공약수는 b와 r의 최대공약수와 같다. 이 성질에 따라, b를 r로 나눈 나머지 r'를 구하고, 다시 r을 r'로 나눈 나머지를 구하는 과정을 반복하여 나머지가 0이 되었을 때 나누는 수가 a와 b의 최대공약수이다.

    try {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))





    } catch (e: Exception) {
        e.printStackTrace()
    }
}

// 유클리드호제법 최대공약수를 재귀함수를 사용하여 구현
fun GCD(n1: Int, n2: Int): Int {
    return if (n2 == 0) {
        n1
    } else {
        GCD(n2, n1 % n2)
    }
}