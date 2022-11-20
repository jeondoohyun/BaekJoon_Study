import java.util.Scanner

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var hour = nextInt()
    var min = nextInt()

    var hour_60 = hour * 60
    var time_minus_45 = hour_60 + min - 45

    if (time_minus_45 < 0) {
        time_minus_45 = (23 * 60) + (60 + (min - 45))   // (min - 45) 값은 음수임.
    }

    var hour_result = time_minus_45 / 60
    var min_result = time_minus_45 % 60

    print("${hour_result} ${min_result}")
}