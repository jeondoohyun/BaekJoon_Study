import java.io.*

// 슬라이딩 윈도우 기법을 사용

var conditionArr = IntArray(4)
var checkCnt = 0    // checkCnt가 4가 되면 (각자리 조건4개가 충족되면) result +1
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
        if (c[i] == 0) checkCnt++   // 0개라는건 없어도 된다는거니까 무조건 조건충족이라 checkCnt를 +1
    }

    // 부분문자열 길이 만큼의 dna배열 만들기
    for (i in 0 until p) {
        dnaArr = addDna(dna[i], dnaArr)
    }

    if (checkCnt == 4) result++

    // n : 슬라이딩 하는 횟수
    var n = s-p
    var tmpDnaArr = dnaArr
    for (i in 0 until  n) {
        tmpDnaArr = removeDna(dna[i], tmpDnaArr)
        tmpDnaArr = addDna(dna[p+i], tmpDnaArr)
        if (checkCnt == 4) result++
    }

    bw.write(result.toString())
    bw.flush()
    bw.close()
}

fun addDna(s: Char, dnaArr: IntArray): IntArray {
    var tmpDnaArr = dnaArr
    if (s == 'A') {
        tmpDnaArr[0]++
        if (tmpDnaArr[0] == conditionArr[0]) checkCnt++     // 충족된 순간 한번만 +1해준다. 조건문을 >= 이렇게 해놓으면 한자리에 checkCnt가 여러번 증가 될수 있다.
    } else if (s == 'C') {
        tmpDnaArr[1]++
        if (tmpDnaArr[1] == conditionArr[1]) checkCnt++
    } else if (s == 'G') {
        tmpDnaArr[2]++
        if (tmpDnaArr[2] == conditionArr[2]) checkCnt++
    } else if (s == 'T') {
        tmpDnaArr[3]++
        if (tmpDnaArr[3] == conditionArr[3]) checkCnt++
    }

    return tmpDnaArr
}
fun removeDna(s: Char, dnaArr: IntArray): IntArray {
    var tmpDnaArr = dnaArr
    if (s == 'A') {
        if (tmpDnaArr[0] == conditionArr[0]) checkCnt--     // 지금은 같지만 다음 라인에서 -- 되기 때문에 충족값보다 적어지기 때문에 checkCnt를 -1 해준다.
        tmpDnaArr[0]--
    } else if (s == 'C') {
        if (tmpDnaArr[1] == conditionArr[1]) checkCnt--
        tmpDnaArr[1]--
    } else if (s == 'G') {
        if (tmpDnaArr[2] == conditionArr[2]) checkCnt--
        tmpDnaArr[2]--
    } else if (s == 'T') {
        if (tmpDnaArr[3] == conditionArr[3]) checkCnt--
        tmpDnaArr[3]--
    }
    return tmpDnaArr
}

