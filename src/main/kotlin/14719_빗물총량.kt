import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

lateinit var map: Array<IntArray>   // null로 초기화 하는것을 지양하는 코틀린에서 null초기화 말고 나중에 초기화를 하도록 하는 lateinit
var w = 0
var h = 0
fun main(args: Array<String>) {
    // 재귀함수는 반복문과 비슷하다고 생각해라. 같은 함수를 계속 호출하기때문에
    try {

        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        var h_w = br.readLine().split(" ").map { it.toInt() }
        w = h_w[1]
        h = h_w[0]
        var h_temp = br.readLine().split(" ").map { it.toInt() }
        var sum = 0

        map = Array(w){IntArray(h){0} }   // h_w는 인데스 0에 높이 값이 들어있는데 편의상 가로에 대한 세로 값이 보기 편하므로 2차 배열 map에 1차 배열 위치에 가로 배열을 넣어준다(h_w[1])
        for (i in 0 until map.size) {
            for (j in 0 until h_temp[i]) {
                map[i][j] = 1   // 블록맵 만들기, 블록이 있는 위치는 1로 채운다
            }
        }

        // 해당 높이위치가 블록이 없이 0이면서 양옆에 블록으로 막혀 있어야 물이 고일수 있음. 옆에 블록이 없이 0으로 채워져 있으면 계속 옆의 블록을 확인해서 막혀 있는지 확인
        for (i in 0 until w) {
            for (j in 0 until h) {
                if (map[i][j] == 0) {   // 블록으로 채워져 있지 않고 물이 들어갈 공간이 있는지
                    if (left(i-1,j)) {
                        if (right(i+1,j)) {
                            sum += 1
                        }
                    }
                }
            }
        }


        bw.write("$sum")
        bw.flush()
        bw.close()


    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun left(i: Int, j: Int): Boolean {     // 왼쪽의 공간들이 블록으로 채워져있는가?
    if (i >= 0) {
        return if (map[i][j] == 1) true
        else left(i-1, j)   // 재귀 함수를 재호출할때 인자 값을 바꿔가며 재호출
    }
    return false
}
fun right(i: Int, j: Int): Boolean {     // 오른쪽의 공간들이 블록으로 채워져있는가?
    if (i < w) {
        return if (map[i][j] == 1) true
        else right(i+1, j)
    }
    return false
}