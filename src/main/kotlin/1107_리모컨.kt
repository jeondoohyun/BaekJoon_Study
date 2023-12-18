import java.io.*
import java.lang.Math.*
import java.util.*

// 사용 가능 버튼 배열
var useButton = BooleanArray(10){true}
fun main(args: Array<String>) {

    // 1107 주어진 테스트 케이스는 다 맞는데 제출은 틀림
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var now = 100

    // n : 이동하려는 채널
    var n = br.readLine()

    // m : 고장난 버튼 개수
    var m = br.readLine().toInt()

    if (m!=0) {
        // troubles : 고장난 버튼들
        var troubles = br.readLine().split(" ").map { it.toInt() }
        troubles.forEach {
            useButton[it] = false
        }
    }

    var usePlusMinus = abs(now-n.toInt())    // +,- 버튼으로만 이동했을경우
    var cnt = 0
    var upCha = n.toInt()
    var downCha = n.toInt()

    if (n.toInt()==100) bw.write("0")
    else if (m==0) bw.write("${min(n.length, usePlusMinus)}")
    else {
        while (true) {
            if (cnt + upCha.toString().length >= usePlusMinus && cnt + downCha.toString().length >= usePlusMinus) {
                bw.write("$usePlusMinus")
                break
            }

            if (checkRemote(upCha)) {
                bw.write("${upCha.toString().length + cnt}")
                break
            }

            if (checkRemote(downCha)) {
                bw.write("${downCha.toString().length + cnt}")
                break
            }

            cnt++
            upCha++
            if (downCha != 0) downCha--
        }
    }
    bw.flush()
    bw.close()
}

fun checkRemote(chanel: Int): Boolean {
    var a = chanel.toString()
    for (i in a) {
        if (!useButton[i.toString().toInt()]) return false
    }
    return true
}


//lateinit var disableBtn: Array<String>
//
//fun main() {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//
//    // target : 이동하려는 채널
//    val target = br.readLine().toInt()
//    // n : 고장난 버튼 개수
//    val n = br.readLine().toInt()
//
//    val usePlusAndMinus = abs(target - 100) // + - 버튼을 사용해서 이동할경우
//
//    if (n == 0) {
//        println(min(usePlusAndMinus, target.toString().length))
//        return
//    }
//
//    val st = StringTokenizer(br.readLine(), " ")
//    disableBtn = Array(n) { " " }
//    for (i in 0 until n) disableBtn[i] = st.nextToken()
//
//    var cnt = 0
//
//
//    var upperBtn = target
//    var lowerBtn = target
//
//
//    while (true) {
//        var a = cnt + upperBtn.toString().length
//        var b = cnt + lowerBtn.toString().length
//        if (cnt + upperBtn.toString().length >= usePlusAndMinus && cnt + lowerBtn.toString().length >= usePlusAndMinus) {
//            println(usePlusAndMinus)
//            break
//        }
//
//        if (isAble(lowerBtn) && lowerBtn >= 0) {
//            println(cnt + lowerBtn.toString().length)
//            break
//        }
//
//        if (isAble(upperBtn)) {
//            println(cnt + upperBtn.toString().length)
//            break
//        }
//
//        upperBtn++
//        lowerBtn--
//        cnt++
//    }
//}
//
//fun isAble(c: Int): Boolean {
//    var channel = c.toString()
//
//    for(i in channel) {
//        if(i.toString() in disableBtn) {
//            return false
//        }
//    }
//    return true
//}
