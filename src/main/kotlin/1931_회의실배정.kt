import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

data class TimeOfUse (val start_time: Int, val end_time: Int)
fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))
    var cnt = 1

    var list_timeOfUse = mutableListOf<TimeOfUse>()

    for (i in 0 until br.readLine().toInt()) {
        var inputTime = br.readLine().split(" ")
        list_timeOfUse.add(TimeOfUse(inputTime[0].toInt(), inputTime[1].toInt()))
    }

    // 그리디정렬 적용
    // 시작시간은 끝나는시간과 같거나 작다. 끝나는시간을 오름차순으로 정렬하면 첫번째 회의실 이용시간은 최소인 요소를 배치 할수 있다.
    // 끝나는 시간을 기준으로 오름차순으로 정렬후 끝나는시간이 같으면 시작시간을 오름차순으로 정렬한다.
    var list__ = list_timeOfUse.sortedWith(Comparator { o1, o2 ->
        when {
            o1.end_time < o2.end_time -> -1
            o1.end_time == o2.end_time -> when {
                o1.start_time < o2.start_time -> -1
                else -> 1
            }
            else -> 1
        }
    })

    var temp_end = list__[0].end_time
    for (i in 1 until list__.size) {
        if (temp_end <= list__[i].start_time) {
            cnt++
            temp_end = list__[i].end_time
        }
    }

    bw.write("$cnt")
    bw.flush()
    bw.close()

}