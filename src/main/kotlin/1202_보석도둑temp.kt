import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

fun main() {
    val firstInput = readLine()!!.split(" ")
    val n = firstInput[0].toInt()
    val k = firstInput[1].toInt()
    val jewelries = ArrayList<Jewelry2>()
    val bags = ArrayList<Int>()
    val pq = PriorityQueue(Comparator.reverseOrder<Int>())
    var sum: Long = 0
    var position = 0

    for (i in 0 until n) {
        val info = readLine()!!.split(" ")
        jewelries.add(Jewelry2(info[0].toInt(), info[1].toInt()))
    }

    for (i in 0 until k) {
        bags.add(readLine()!!.toInt())
    }

    jewelries.sortWith(Comparator<Jewelry2> { j1, j2 ->
        if (j1.weight == j2.weight) {
            j2.value - j1.value
        } else j1.weight - j2.weight
    })

    bags.sort()

    for(bag in bags) {
// todo : 내 코드로 하면 백준에서 틀림, temp코드 디버그 하고 내코드 디버그 해서 차이점 알아내기
        for (i in position until jewelries.size) {
            if (jewelries[i].weight <= bag) {
                pq.offer(jewelries[i].value)
                position = i + 1
            } else {
                break
            }
        }

        if (!pq.isEmpty()) {
            sum += pq.poll()
        }
    }
    println(sum)
}

data class Jewelry2(
        val weight: Int,
        val value: Int
)