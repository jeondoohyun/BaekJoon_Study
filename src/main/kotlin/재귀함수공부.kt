fun main(args: Array<String>) {

    recursive(1)

}

fun recursive(num: Int) {
    // base case, stopping condition, 종료 조건
    if (num > 3) {
        return;
    }

    println("before call itself, num: ${num}")
    recursive(num + 1)  // 재귀함수를 호출하고 return을 만나면 여기 아래부터 다시 호출되었던 함수 역순으로 진행.
    println("after call itself, num: ${num}")
//    return;
}



