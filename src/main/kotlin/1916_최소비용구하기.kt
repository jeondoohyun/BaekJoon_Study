import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

lateinit var bus_info: Array<IntArray>
var size_busInfo = 0
var min_price = 100000
var start = 0   // 시작 도시
var mid = 0 // 통과 도시
var end = 0 // 도착 도시
var ing = false
var price_total = 0

// 다익스트라 알고리즘
fun main(args: Array<String>) {
    try {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        // 도시 개수
        var N = br.readLine().toInt()

        // 버스 개수
        var M = br.readLine().toInt()

        // 버스 출발도시, 도착도시, 이용요금
        bus_info = Array(M,{IntArray(3,{0})})

        bus_info.forEachIndexed { index, ints ->
            var bus = br.readLine().split(" ").map { it.toInt() }.toIntArray()
            bus_info[index] = bus
        }
        size_busInfo = bus_info.size

        var a = br.readLine().split(" ").map { it.toInt() }
        start = a[0] // 출발 도시
        end = a[1]  // 도착 도시

        cost(0, false)

        bw.write("$min_price")
        bw.flush()
        bw.close()


    } catch (e: Exception) {
        e.printStackTrace()
    }
}

// todo : 재귀함수 원리 확실히 정리 하기, 백준 입력 그대로 입력해서 디버그 해보기
fun cost(index: Int, flag_result: Boolean) {    // 재귀함수를 사용하여 최소값 구해보기
    // 재귀함수 끝나는 시점 1) 인덱스가 bus_info 마지막 일때(마지막까지 완전탐색)
    // 시작 지점이 일치하고 도착지점도 일치 할때 그때 발생하는 비용을 구해서 최소 값이면 min_bus에 넣는다
    // 첫 bus_info배열에서 출발하자 마자 도착할 경우도 있음
    // 마지막 인덱스의 bus_info에서 최소비용이 완성될 경우도 있음

//    if (end == bus_info[index][1] && flag_result) {
    if (end == bus_info[index][1] && flag_result) {
        if (price_total < min_price) {  // price_totla이랑 min_bus를 비교해야함
            min_price = price_total
        }
        return
    }


    if (index == size_busInfo-1) {
        return
    }

    for (i in index until size_busInfo) {
        if (start == bus_info[i][0] &&
                mid == 0) {  // 2번째 bus_info의 출발 도시도 start와 같을수 있다. 그럴때 이 조건이 성립하지 못하도록 해야함
            if (end == bus_info[i][1]) {
                if (bus_info[i][2] < min_price) {
                    min_price = bus_info[i][2]
                }
                continue
            }
            mid = bus_info[i][1]    // 처음 시작일때만 mid를 여기서 갱신해주고 다음부턴 아래에서 갱신한다
            price_total += bus_info[i][2]
//            ing = true
        }
        if (mid != 0 &&
                i != size_busInfo-1) { // 마지막 인덱스에서 최소값이 발생할수도 있다. 그러면 cost(i+1)을 재호출 했을때 인덱스 아웃 오류 뜸
            var conn = false
            if (mid == bus_info[i+1][0]) {  // 이전버스 도착점이 다음 버스 시작점과 같을때, 같을때 말고 무조건 재귀함수를 호출해야 함, 더 나중에 이어질수도 있는데 다음것만 확인하기때문에 재호출이 안됨, 재호출이 안되면 다 확인이 불가
                price_total += bus_info[i+1][2]   // 다음 i+1버스가 연결되는건데 이전 버스 요금을 더했음
                mid = bus_info[i+1][1]
                conn = true // 이전 버스 도착점과 다음 버스 시작점 같을때 연결되어 있을때만 재귀호출에서 도착점에 도착하면 min_price을 구한다
            }
            cost(i+1, conn) // 재귀호출을 하여 return을 받은 재귀호출만 return 처리가 되고  아래로 내려가서 mid=0, price_totla=0이 된다,
        }
//        ing = false
        mid = 0
        price_total = 0

    }
}