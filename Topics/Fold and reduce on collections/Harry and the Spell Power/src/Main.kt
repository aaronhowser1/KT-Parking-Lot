data class Spell(val name: String, val power: Int)

fun main() {
    val input = readln().split(" ")
    val spells = input.map { Spell(it.split("-")[0], it.split("-")[1].toInt()) }

    // write your code here
    val res = spells
        .filter { it.power >= 40 }
        .fold(0) { acc, spell -> acc+spell.power }

    println(res)
}