import java.util.Scanner

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var first = nextInt()
    var second = nextInt()
    var second_100 = second/100
    var second_10 = (second%100)/10
    var second_1 = second%10

    var result_1 = first * second_1
    var result_2 = first * second_10
    var result_3 = first * second_100
    var result_4 = result_1 + (result_2 * 10) + (result_3 * 100)

    println(result_1)
    println(result_2)
    println(result_3)
    println(result_4)
}