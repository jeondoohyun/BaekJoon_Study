import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(System.out.bufferedWriter()) {
    /**
     * N개의 단어가 입력 되면 다음과 같은 조건에 맞게 정렬을 하시오. 1) 길이가 짧은 것부터 2) 길이가 같으면 사전 순으로 3)중복된 단어는 하나만 남기고 제거 해야한다.
     */

    // 받으면서 정렬하는게 아니고 다 받고나서 정렬
    val br = BufferedReader(InputStreamReader(System.`in`))
    var t = Integer.parseInt(br.readLine())
    val set = mutableSetOf<String>()    // 중복데이터를 허용하지 않는다
    for (i in 0 until t) {
        set.add(br.readLine())
    }
    val resultSet = set.sortedWith(Comparator { a, b ->
        // 글자수를 우선적으로 확인한다. 글자수가 같을때는 a,b 아스키코드순 (알파벳순)으로 오름차순으로 정렬
        // a가 b보다 작을때 -1을 반환하면 오름차순으로 정렬됨
        when {
            a.length < b.length -> -1
            a.length == b.length -> when {
                a < b -> -1
                else -> 1
            }
            else -> 1
        }
    })
    for (item in resultSet) {
        write("$item\n")
    }
    flush()
    close()
}