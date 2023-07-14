import java.io.BufferedReader
import java.io.InputStreamReader

data class XY (val x: Int, val y: Int)
fun main() = with(System.out.bufferedWriter()) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var N = br.readLine().toInt()
    var XY_List = mutableListOf<XY>()

    for (i in 0 until N) {
        var coor_ = br.readLine().split(" ")
        XY_List.add(XY(coor_[0].toInt(), coor_[1].toInt()))
    }

    val result = XY_List.sortedWith(Comparator { a, b ->
        // a가 b보다 작을때 -1을 반환하면 오름차순으로 정렬됨
        when {
            a.x < b.x -> -1
            a.x == b.x -> when {    // x좌표가 같을땐 y기준으로 오름차순 정렬
                a.y < b.y -> -1
                else -> 1
            }
            else -> 1
        }
    })

    for (item in result) {
        write("${item.x} ${item.y}\n")
    }
    flush()
    close()
}