package parking

import java.lang.IndexOutOfBoundsException

data class Car(val id: String, val color: String)

data class ParkingLot(val size: Int, val spots: MutableMap<Int, Car>) {

    fun park(id: String, color: String) {

        var i = 1
        while (spots[i] != null) i++

        if (i > size) {
            println("Sorry, the parking lot is full.")
        } else {
           spots[i] = Car(id, color)
            println("$color car parked in spot $i.")
        }
    }

    fun leave(spot: Int) {
        val occupied = check(spot) != null

        if (occupied) {
            spots.remove(spot)
            println("Spot $spot is free.")
        } else {
            println("There is no car in spot $spot.")
        }
    }

    fun printStatus() {

        if (spots.isEmpty()) {
            println("Parking lot is empty.")
        } else {
            for ((spotNumber, car) in spots) {
                println("""
                $spotNumber ${car.id} ${car.color}
            """.trimIndent())
            }
        }
    }

    private fun check(spot: Int): Car? = spots[spot]
}

fun main() {
    showMenu()
}

fun showMenu() {

    var parkingLot: ParkingLot? = null

    while (true) {

        val input = readln()
        val split = input.split(" ")

        try {
            when (split.firstOrNull()) {
                "create" -> {
                    val amount = split[1].toInt()
                    parkingLot = ParkingLot(amount, mutableMapOf())
                    println("Created a parking lot with $amount spots.")
                }
                "exit" -> break
                else -> {

                    if (parkingLot == null) {
                        println("Sorry, a parking lot has not been created.")
                        continue
                    }

                    when (split.firstOrNull()) {
                        "leave" -> parkingLot.leave(split[1].toInt())
                        "park" -> parkingLot.park(split[1], split[2])
                        "status" -> parkingLot.printStatus()
                    }
                }
            }
        } catch (e: IndexOutOfBoundsException) {
            println(e)
        }
    }
}
