import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.Comparator

data class Jewelry(var M: Int, var V: Int)

fun main(args: Array<String>) {
    // 우선순위 큐를 사용 하여 푼다
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var arr = mutableListOf<Jewelry>()
    val pq = PriorityQueue(Comparator.reverseOrder<Int>())

    var N_K = br.readLine().split(" ").map { it.toInt() }

    for (i in 0 until N_K[0]) {
        var n_k = br.readLine().split(" ").map { it.toInt() }
        arr.add(Jewelry(n_k[0], n_k[1]))
    }

    var C = mutableListOf<Int>()    // 배낭에 넣을수 있는 무게 한도
    for (i in 0 until N_K[1]) {
        C.add(br.readLine().toInt())
    }

    C.sort()

    val arr_2 = arr.sortedWith(Comparator { j1, j2 ->
        // when문법대신 이렇게 정렬하면 심플함, when대신 아래처럼 하니까 IllegalArgument에러 안뜸
        if (j1.M == j2.M) {
            j2.V - j1.V // V를 내림차순
        } else j1.M - j2.M// M을 오름차순
    })

    var result: Long = 0
    var num = 0

    C.forEach {a ->
        run {
            for (i in num until arr_2.size) {
                if (a >= arr_2[num].M) {    // a무게 가방에 들어가는 보석들을 다 pq에 추가 한다음에 가격 내림차순 정렬된 pq에서 가장 비싼거를 하나 우선순위큐에서 뽑는다, 그러면 각 무게에서 가장 비싼 보석을 뽑아 최대값구하기 가능
                    pq.offer(arr_2[i].V)
                    num++
                } else {
                    return@run
                }
            }
        }

        if (!pq.isEmpty()) {
            result += pq.poll() // poll()을 하여 값을 뽑으면 뽑힌 값은 pq에서 사라짐
            // result 결과 값이 보석과 배낭 갯수 <300000, 가격<1000000 으로 가격 총합이 int범위를 초과 할수 있기 때문에 long으로 처리 한다
        }
    }

    bw.write("$result")
    bw.flush()
    bw.close()


}