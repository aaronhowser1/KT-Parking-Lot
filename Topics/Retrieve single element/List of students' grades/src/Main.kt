fun main() {
//    val list = readln().split(" ").map{ it.toDouble() }
//    // write your code here
//    val firstPassed = list.firstOrNull { it >= 5.0 }
//    val highest = list.lastOrNull()
//
//    println("$firstPassed:$highest")

    val listOfNames = listOf("Pablo", "John", "Jane", "Mary", "Peter")

    val a = listOfNames.map {if (it.length < 5) it else listOfNames }
    println(a)
}