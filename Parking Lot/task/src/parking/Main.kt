package parking

import java.lang.IndexOutOfBoundsException

data class Car(val id: String, val color: String)

val parkingLot = mutableMapOf<Int,Car>()

const val PARKING_LOT_SIZE = 20

fun main() {
    showMenu()
}

fun showMenu() {
    while (true) {

        val input = readln()
        val split = input.split(" ")

        try {
            when (split.firstOrNull()) {
                "leave" -> leave(split[1].toInt())
                "park" -> park(split[1], split[2])
                "exit" -> break
            }
        } catch (e: IndexOutOfBoundsException) {
            println(e)
        }
    }
}

fun park(id: String, color: String) {

    var i = 1
    while (parkingLot[i] != null) i++

    if (i > PARKING_LOT_SIZE) {
        println("Sorry, the parking lot is full.")
    } else {
        parkingLot[i] = Car(id, color)
        println("$color car parked in spot $i.")
    }
}

fun leave(spot: Int) {
    val occupied = check(spot) != null

    if (occupied) {
        parkingLot.remove(spot)
        println("Spot $spot is free.")
    } else {
        println("There is no car in spot $spot.")
    }
}

fun check(spot: Int): Car? = parkingLot[spot]