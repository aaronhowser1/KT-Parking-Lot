data class Spell(val name: String, val power: Int)

fun main() {
    val input = readln().split(" ")
    val spells = input.map { Spell(it.split("-")[0], it.split("-")[1].toInt()) }

    // write your code here
    val spell = spells.firstOrNull {it.power > 50}

    if (spell == null) {
        println("No spell found")
    } else {
        println(spell)
    }
}