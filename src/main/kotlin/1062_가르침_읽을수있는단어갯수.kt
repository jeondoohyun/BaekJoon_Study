import kotlin.math.*
val br = System.`in`.bufferedReader()

//1<=n<=50
//0<=k<26
val chk = BooleanArray(26)
var answer=0

fun count(words : Array<String>, n : Int) : Int{
    var cnt=0
    for(i in 0 until n){    // antarctica 단어를 검사 한다고 하면 처음과 끝의 anta, tica를 제외한 가운데 rc를 검사 한다.
        var j=4
        while(j<words[i].length-3){     // words의 단어는 최소 알파벳8개 여야함, 단어가 되려면 anta로시작 tica로 끝나야 하기 때문에 최소 8글자는 되야함. 그래야 cnt를 셀수있음
            if(!chk[words[i][j++]-'a'])break    // words의 2차 인덱스j는 문자열중에 char를 뽑은것, j가 4라서 5번째 알파벳을 확인(antarctica라면 r이 true인지 확인) ,j++라서 이 라인 벗어나야 1커짐
        }
        if(j==words[i].length-3) cnt++  // leng-3과 길이가 같다는건 j++가 되면서 필수 알파벳을 제외한 모든 char와 비교를 완료했다는뜻
    }
    return cnt
}

fun combination(idx : Int, cnt : Int, n : Int, k : Int, words : Array<String>){

    // 체크해야할 알파벳이 3개일경우 재귀 함수가 3번 불려서 cnt가+3이 되어야 answer단어를 체크하기 시작
    if(cnt==k){
        answer = max(answer,count(words,n))
        return
    }

    for(i in idx until 26){
        if(chk[i])continue
        chk[i]=true

        // 예를들어 배울수 있는 알파벳수가 8개 라면 알고 있어야할 최소 알파벳(antic)5개 빼고 3개를 재귀함수를 사용하여 완전탐색으로 하나씩 적용하여 확인한다.
        // 2개의 알파벳은 true로 고정하고 마지막 하나를 반복문으로 처음부터 끝까지 돌리고 다 돌면 2번째 알파벳을 다음꺼를 true로 하고 세번째 다시 반복문
        // ex) abc, abd, abe .... abz, acd, ace, acf... 이런식으로 모든 알파벳 체크
        combination(i+1,cnt+1,n,k,words)

        // abc를 확인했으면 c를 다시 false처리 하고 d를 true처리 후 다시 검사. 모든 알파벳을 검사 한후 max()메소드로 제일 높은경우를 출력(단어를 많이 읽을수 있는 최대 숫자)
        chk[i]=false
    }
}

fun main() = with(System.out.bufferedWriter()){
    val (n,k) = br.readLine().split(' ').map{it.toInt()}
    val words = Array(n){br.readLine()} // Array배열 사이즈 갯수n개 만큼 readLine()을 받는다
    // a,n,t,i,c는 필수 알파벳임
    chk[0]=true
    chk['i'-'a']=true   // a부터 차례대로 했을경우 i 위치 인덱스 (8)에 true로 설정, 유니코드는 차례로 되있기 때문에 i와a는 8차이가 날수밖에 없다.
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