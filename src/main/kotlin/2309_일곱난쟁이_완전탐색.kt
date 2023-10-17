import java.io.*

//fun main(args: Array<String>) {
//    // 브루트포스(완전탐색)
//    // 완전탐색(전부다 차례로 확인하는것)
//    // 데이터가 9가지 밖에 안주어지기 때문에 그냥 다 더해도 오래 걸리지 않는다. 7개를 더해서 100을 확인하던가 9개를 더한값에서 2개데이터를 빼서 100을 만들던가
//    try {
//        val br = BufferedReader(InputStreamReader(System.`in`))
//        val bw = BufferedWriter(OutputStreamWriter(System.out))
//
//        var 아홉난쟁이 = mutableListOf<Int>()
//
//        repeat(9) {
//            아홉난쟁이.add(br.readLine().toInt())
//        }
//
//        var sum = 아홉난쟁이.sum()
//        var flag = false
//
//        for (i in 0..7) {
//            for (j in i+1 .. 8) {
//                var result = sum - 아홉난쟁이[i] - 아홉난쟁이[j]  // 왜 IndexOutOfBound가 뜨지
//                if (result == 100) {
//                    아홉난쟁이.removeAt(i)   // 요소를 빼버려서 리스트 인덱스가 짧아졌는데 for문 계속 돌리면 indexOutOfBound
//                    아홉난쟁이.removeAt(j-1) // 위에서 i index를 빼버렸기 때문에 한칸이 짧아져서 j-1을 해줘야 j위치의 요소값을 뺄수 있다
//                    아홉난쟁이.sort()
//                    flag = true
//                    break
//                }
//            }
//            if (flag) break
//        }
//
//        아홉난쟁이.forEach{
//            bw.write("$it\n")
//        }
//        bw.flush()
//        bw.close()
//    } catch (e: Exception) {
//        e.printStackTrace()
//    }
//}

// 다시풀어보기, 재귀함수 이용
var result = mutableListOf<Int>()
fun main(args: Array<String>) {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var hum = mutableListOf<Int>()
    repeat(9) {
        hum.add(br.readLine().toInt())
    }

    check2309(0,0, hum)

    result.sort()
    result.forEach {
        if (it != 0) bw.write("$it\n")
    }
    bw.flush()
    bw.close()
}

fun check2309(cnt: Int, idx: Int, hum: MutableList<Int>) {
    if (cnt == 2) {
        if (hum.sum() == 100) {
            if (result.isEmpty()) result.addAll(hum)  // result = hum을 하면 참조값이 들어가기 때문에 이후에 hum가 변경되면 변경된값이 result에 갱신된다.
        }
        return
    }
    for (i in idx until 9) {
        var a = hum.removeAt(i)
        hum.add(i, 0)   // 0으로 바꾸기
        check2309(cnt + 1, i + 1, hum)
        hum.removeAt(i)
        hum.add(i, a)
    }
}

