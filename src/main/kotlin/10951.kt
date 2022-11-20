import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception
import java.util.StringTokenizer

fun main(args: Array<String>) {
    try {
        var br = BufferedReader(InputStreamReader(System.`in`))
        var bw = BufferedWriter(OutputStreamWriter(System.out))

        var input: String?

        while (br.readLine().also { input = it } != null && input != "") {     // 입력이 있을때만 실행, null 대신 ""을 넣으면 콘솔에서도 정답이긴함. "" 넣으면 백준에서 npe 뜸
            val tokenizer = StringTokenizer(input)  // StringTokenizer는 문자열을 쪼갠다, 미지정시 공백을 기준으로 쪼갬
            val num_first = tokenizer.nextToken().toInt()   // nextToken은 쪼개진 문자열을 처음부터 하나씩 꺼냄
            val num_second = tokenizer.nextToken().toInt()
            bw.write("${num_first + num_second}\n")
        }
        bw.flush()
    } catch (e: Exception) {
        print(e.printStackTrace())
    }
}

// 편집기 콘솔에선 오류 뜨는데 백준에선 정답임