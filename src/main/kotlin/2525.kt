import java.util.Scanner

// 문제의 입력 범위 양끝 값을 넣어서 테스트 해본다
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var hour = nextInt()
    var min = nextInt()
    var time_plus = nextInt()

    var hour_60 = hour * 60

    var time_result = hour_60 + min + time_plus

    if (time_result >= 1440) {  // 하루 24시간을 분으로 나타내면 1440
        time_result = time_result % 1440
    }

    print("${time_result/60} ${time_result%60}")
}