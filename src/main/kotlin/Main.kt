import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception
import java.util.*

fun main(args: Array<String>) {

    multitab = BooleanArray(6)

    multitab[0] = true
    multitab[1] = true

//    multitab.forEach {
//        println(it)
//    }
    println(multitab.count { it })
}
