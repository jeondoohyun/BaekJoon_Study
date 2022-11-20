import java.util.Scanner

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var king = nextInt()
    var queen = nextInt()
    var look = nextInt()
    var bishop = nextInt()
    var night = nextInt()
    var fone = nextInt()

    print("${1-king} ${1-queen} ${2-look} ${2-bishop} ${2-night} ${8-fone}")
}