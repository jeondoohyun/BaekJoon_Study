import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

lateinit var multitab: BooleanArray
fun main(args: Array<String>) {
    try {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        var (n,k) = br.readLine().split(" ").map { it.toInt() }
        var products = br.readLine().split(" ").map { it.toInt() }

        multitab = BooleanArray(k+1)

        var cnt = 0

        for (i in 0 until products.size) {
            if (multitab[products[i]]) continue // 3구 멀티탭에 1212 사용 순서일때 세번째 1은 이미 꽂혀있기때문에 continue로 다음으로 넘어감
            if (multitab.count { it } < n) {
                multitab[products[i]] = true
            } else {  // 3구 멀티탭에 이미 3개가 꽂혀있어서 뽑을 기기를 정해야함
                var reuse_arr = mutableListOf<Int>()
                for (next in i+1 until products.size) {
                    // 재사용해야 하는 기기 저장, 재사용하지 않는 기기들을 멀티탭에서 빼준다
                    if (multitab[products[next]] && products[next] !in reuse_arr) reuse_arr.add(products[next]) // reuse에 중복되면 추가를 안하기 때문에 reuse가 n값보다 커질수가 없다
                }

                if (reuse_arr.size != n) {
                    for (del in 0 until products.size) {
                        if (multitab[del] && del !in reuse_arr) { multitab[del] = false;break }
                    }
                } else { // 현재 멀티탭에 꽂혀있는 기기 모두 나중에 재사용 된다. 제일 나중에 사용되는 기기를 빼준다. 123122 이여서 마지막 2를 빼주던 123221 여서 1을 빼주던 뽑는 횟수는 똑같다
                    multitab[reuse_arr.last()] = false
                }
                multitab[products[i]] = true
                cnt++
            }
        }

        bw.write("$cnt")
        bw.flush()
        bw.close()



    } catch (e: Exception) {
        e.printStackTrace()
    }
}
