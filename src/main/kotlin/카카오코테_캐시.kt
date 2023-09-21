import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main(args: Array<String>) {
    try {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        var cacheSize = br.readLine().toInt()
        var cities = br.readLine()
        cities = cities.toLowerCase()
                .replace("[", "")
                .replace("]","")
                .replace("\"","")

        var cities_list = cities.split(", ")

        val queue: Queue<String> = LinkedList()
        var result = 0

        cities_list.forEach { city ->
            //1. 해당 데이터가 캐시에 저장되어 있는지 확인후 있으면 +1, 없으면 캐시에 추가 하고 +5, 추가 하는데 사이즈가 3개넘어가면 하나 빼면서 추가

            if (queue.remove(city)) { // 해당 데이터가 캐시에 저장되어 있는경우, 지울수 있으면(저장되어 있으면) true반환, 삭제후 다시 가장위로 추가됨(아래 코드에서)
                result += 1
            } else {
                if (queue.size > cacheSize) {
                    queue.poll()
                }
                result += 5
            }
            queue.add(city)     // 가장 위로 다시 추가됨

        }

        bw.write("$result")
        bw.flush()
        bw.close()

    } catch (e: Exception) {
        e.printStackTrace()
    }
}