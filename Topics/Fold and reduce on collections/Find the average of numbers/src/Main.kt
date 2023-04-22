fun main() {
    val list = readln().split(" ").map { it.toDouble() }
    // write your code here
    val res = list.sum() / list.count()


    println(res)
}