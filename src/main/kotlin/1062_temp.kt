//import java.io.BufferedReader
//import java.io.BufferedWriter
//import java.io.InputStreamReader
//import java.io.OutputStreamWriter
//import java.lang.Exception
//
//fun main(args: Array<String>) {
//
//    // https://ongveloper.tistory.com/132
//    try {
//        val br = BufferedReader(InputStreamReader(System.`in`))
//        val bw = BufferedWriter(OutputStreamWriter(System.out))
//
//        val chk = BooleanArray(26)  // 각 요소들은 false로 초기화
//
//        chk[0] = true   // 인덱스 0 위치는 a 위치
//        chk['i'-'a']=true   // i위치 true, a에서 i까지의 차이를 나타내기때문에
//
//        println("${'i'-'a'}")   // 8
//        println("${'i'.toInt()}")   //
//        println("${'a'.toInt()}")   //
//
//        chk.forEach {
//            println("$it")
//        }
//
//
//
//    } catch (e: Exception) {
//        e.printStackTrace()
//    }
//
//
//}

import kotlin.math.*
val br = System.`in`.bufferedReader()

//1<=n<=50
//0<=k<26
val chk = BooleanArray(26)
var answer=0

fun count(words : Array<String>, n : Int) : Int{
    var cnt=0
    for(i in 0 until n){
        var j=4
        while(j<words[i].length-3){     // words의 단어는 최소 알파벳8개 여야함, 단어가 되려면 anta로시작 tica로 끝나야 하기 때문에 최소 8글자는 되야함. 그래야 cnt를 셀수있음
            if(!chk[words[i][j++]-'a'])break    // word의 2차 인덱스는 문자열중에 char를 뽑은것
        }
        if(j==words[i].length-3) cnt++  // leng-3과 길이가 같다는건 j++가 되면서 필수 알파벳을 제외한 모든 char와 비교를 완료했다는뜻
    }
    return cnt
}

fun combination(idx : Int, cnt : Int, n : Int, k : Int, words : Array<String>){

    if(cnt==k){
        answer = max(answer,count(words,n))
        return
    }

    for(i in idx until 26){
        if(chk[i])continue
        chk[i]=true
        combination(i+1,cnt+1,n,k,words)
        chk[i]=false
    }
}

fun main() = with(System.out.bufferedWriter()){
    val (n,k) = br.readLine().split(' ').map{it.toInt()}
    val words = Array(n){br.readLine()} // Array배열 사이즈 갯수n개 만큼 readLine()을 받는다
    // a,n,t,i,c는 필수 알파벳임
    chk[0]=true
    chk['i'-'a']=true   // a부터 차례대로 했을경우 i 위치 인덱스 (8)에 true로 설정
    chk['n'-'a']=true
    chk['t'-'a']=true
    chk['c'-'a']=true

    if(k<5){    // 필수 알파벳 5개 antic도 못 배웠다는거니까 읽을수 있는 단어는 없다
        write("0")
    }
    else{
        combination(0,0,n,k-5,words)    // k-5는 필수 알파벳을 빼고는 몇개의 알파벳을 배운상태인지
        write("$answer")
    }

    close()
}