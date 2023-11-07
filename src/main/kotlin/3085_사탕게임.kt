import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max

var result_3085 = 0
fun main(args: Array<String>) {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))



    var n = br.readLine().toInt()   // n x n  크기
    var array2 = Array(n) {Array<String>(n){""}}

    for (i in 0 until n) {
        var s = br.readLine()
        for (j in 0 until n) {
            array2[i][j] = s[j].toString()
        }
    }

    checkCandy(array2, n)
    if (result_3085 != n) {
        changeWidth(array2, n)
        changeHeight(array2, n)
    }

//    changeWidth(array2, n)
//    changeHeight(array2, n)

    bw.write(result_3085.toString())
    bw.flush()
    bw.close()
}

fun changeWidth(array2: Array<Array<String>>, n: Int) {
    if (result_3085 == n) return
    var tmpArray2 = array2
    for (i in 0 until n) {
        for (j in 0 until n-1) {
            var s = tmpArray2[i][j]
            tmpArray2[i][j] = tmpArray2[i][j+1]
            tmpArray2[i][j+1] = s

            checkCandy(tmpArray2, n)

            s = tmpArray2[i][j]
            tmpArray2[i][j] = tmpArray2[i][j+1]
            tmpArray2[i][j+1] = s
        }
    }
}

fun changeHeight(array2: Array<Array<String>>, n: Int) {
    if (result_3085 == n) return
    var tmpArray2 = array2
    for (j in 0 until n) {
        for (i in 0 until n-1) {
            var s = tmpArray2[i][j]
            tmpArray2[i][j] = tmpArray2[i+1][j]
            tmpArray2[i+1][j] = s

            checkCandy(tmpArray2, n)

            s = tmpArray2[i][j]
            tmpArray2[i][j] = tmpArray2[i+1][j]
            tmpArray2[i+1][j] = s
        }
    }
}

fun checkCandy(array2: Array<Array<String>>, n: Int) {
    var tmpArray2 = array2
    var cnt = 1
    for (i in 0 until n) {
        cnt = 1
        for (j in 0 until n-1) {
            if (tmpArray2[i][j] == tmpArray2[i][j+1]) cnt++
            else if (j != n-2) cnt = 1
        }
        result_3085 = max(result_3085, cnt)
        if (result_3085 == n) return
    }

    for (j in 0 until n) {
        cnt = 1
        for (i in 0 until n-1) {
            if (tmpArray2[i][j] == tmpArray2[i+1][j]) cnt++
            else if (i != n-2) cnt = 1
        }
        result_3085 = max(result_3085, cnt)
        if (result_3085 == n) return
    }
}