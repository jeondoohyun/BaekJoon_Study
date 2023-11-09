import java.io.*

// 슬라이딩 윈도우
var conditionArr = IntArray(4)
fun main(args: Array<String>) {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    // 결과값 변수
    var result = 0

    // s : 임의로 만든 DNA 문자열 길이 s
    // p : 비밀번호로 사용할 부분문자열의 길이 p
    var (s,p) = br.readLine().split(" ").map { it.toInt() }

    // dna : 임의로 만든 dna 문자열
    var dna = br.readLine()

    // c : 부분문자열에 포함되어야 할 {‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수
    var c = br.readLine().split(" ").map { it.toInt() }

    var dnaArr = IntArray(4){0}
    conditionArr = IntArray(4){0}
    for (i in c.indices) {  // 0 until c.size
        conditionArr[i] = c[i]
    }

    for (i in 0 until p) {
        dnaArr = addDna(dna, i, dnaArr)
    }

    result += compareCondition(dnaArr)

    // n : 슬라이딩 하는 횟수
    var n = s-p
    var tmpDnaArr = dnaArr
    for (i in 0 until  n) {
        tmpDnaArr = removeDna(dna, i, tmpDnaArr)
        tmpDnaArr = addDna(dna, p+i, tmpDnaArr)
        result += compareCondition(tmpDnaArr)
    }

    bw.write(result.toString())
    bw.flush()
    bw.close()
}

fun compareCondition(dnaArr: IntArray): Int {
    var a = 0
    for (i in conditionArr.indices) {
        if (conditionArr[i] > dnaArr[i]) break
        else if(i == 3) a++
    }
    return a
}

fun removeDna(dna: String, i: Int, dnaArr: IntArray): IntArray {
    var s = dna[i]
    var tmpDnaArr = dnaArr
    if (s == 'A') tmpDnaArr[0]--
    else if (s == 'C') tmpDnaArr[1]--
    else if (s == 'G') tmpDnaArr[2]--
    else if (s == 'T') tmpDnaArr[3]--

    return tmpDnaArr
}

fun addDna(dna: String, i: Int, dnaArr: IntArray): IntArray {
    var s = dna[i]
    var tmpDnaArr = dnaArr
    if (s == 'A') tmpDnaArr[0]++
    else if (s == 'C') tmpDnaArr[1]++
    else if (s == 'G') tmpDnaArr[2]++
    else if (s == 'T') tmpDnaArr[3]++

    return tmpDnaArr
}