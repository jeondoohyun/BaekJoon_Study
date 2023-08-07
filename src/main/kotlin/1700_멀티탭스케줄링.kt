//import java.io.BufferedReader
//import java.io.BufferedWriter
//import java.io.InputStreamReader
//import java.io.OutputStreamWriter
//import java.lang.Exception
//
//lateinit var multitab: IntArray
//fun main(args: Array<String>) {
//    try {
//        val br = BufferedReader(InputStreamReader(System.`in`))
//        val bw = BufferedWriter(OutputStreamWriter(System.out))
//
//        var (n,k) = br.readLine().split(" ").map { it.toInt() }
//        var products = br.readLine().split(" ").map { it.toInt() }
//
//        multitab = IntArray(n)
//        for (i in 0 until multitab.size) {
//            multitab[i] = products[i]
//        }
//
//
//        for (i in n until products.size) {
//            for (j in 0 until multitab.size) {
//                if (products[i] != multitab[j]) {   // 사용할 제품이 멀티탭에 없는경우(제품 교체 해야됨, 뭘빼야 할지 정해야함)
//                    // check()호출할때 start 값에 +1해서 인자값 넣을것, 다음거 부터 확인해야되니까
//                }
//            }
//        }
//
//
//
//    } catch (e: Exception) {
//        e.printStackTrace()
//    }
//}
//
//fun check (start: Int, end: Int): Int {
//    for (i in start until end) {
//        for (j in 0 until multitab.size) {
//
//        }   // 멀티탭이 3구면 다음 기기중에 현재 멀티탭에 꽂혀있는거랑 같은 2개까지 확인해야된다.
//        // 멀티탭에 꽂혀 있는 기기와 같은기기면 같지 않은 기기를 뽑는다
//    }
//}
