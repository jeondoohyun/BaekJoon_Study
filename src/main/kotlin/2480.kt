import java.util.Collections
import java.util.Scanner

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var dice_1 = nextInt()
    var dice_2 = nextInt()
    var dice_3 = nextInt()

    var dice_array = listOf<Int>(dice_1, dice_2, dice_3)
    var result = 0

    if (dice_1 == dice_2 && dice_1 == dice_3) {     // 셋다 같은경우
        result = 10000+(dice_1*1000)
    } else if (dice_1 == dice_2) {
        result = 1000+(dice_1*100)
    } else if (dice_2 == dice_3) {
        result = 1000+(dice_2*100)
    } else if (dice_1 == dice_3) {
        result = 1000+(dice_1*100)
    } else {    // 셋다 다를경우
        result = Collections.max(dice_array) * 100
    }
    print(result)
}