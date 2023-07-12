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
//        println("${coor_[0].toInt()}, ${coor_[1].toInt()}")
    }
    // todo : x,y 좌표 각각 비교해서 정렬


}