import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(System.out.bufferedWriter()) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var N_string = br.readLine()

    val list = mutableListOf<String>()

    N_string.forEach {
        list.add(it.toString())
    }

    // 아스키코드순으로 되어 있기 때문에 굳이 Int형으로 바꾼다음에 정렬할 필요 없이 스트링값으로 정렬시켜도 내림차순 적용가능
    val list_descending = list.sortedDescending()

    var sb = StringBuffer()
    list_descending.forEach {
        sb.append(it)
    }
    write("$sb")
    flush()
    close()
}