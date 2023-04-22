/* Do not change code below */
fun main() {
    val list = readln().split(" ")
    // write your code here
    val res = list.first { it.last() == 'm'}.reversed()

    println(res)
}