package parking

import java.lang.IllegalArgumentException
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

    private fun carsByColor(color: String): List<Car> {

        val carsWithColor = spots.values.filter { it.color.lowercase() == color.lowercase() }

        return carsWithColor
    }

    fun regByColor(color: String): String {

        val carsWithColor = carsByColor(color)

        if (carsWithColor.isNullOrEmpty()) {
            return "No cars with color $color were found."
        }

        val registrationIds = mutableListOf<String>()

        for (car in carsWithColor) registrationIds.add(car.id)

        return registrationIds.joinToString(", ")

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

        val command = split.firstOrNull()
        val arguments = split.drop(1)

        try {
            when (command) {
                "create" -> {
                    val amount = arguments[0].toInt()
                    parkingLot = ParkingLot(amount, mutableMapOf())
                    println("Created a parking lot with $amount spots.")
                }
                "exit" -> break
                else -> {

                    if (parkingLot == null) {
                        println("Sorry, a parking lot has not been created.")
                        continue
                    }

                    when (command) {
                        "leave" -> parkingLot.leave(arguments[0].toInt())
                        "park" -> parkingLot.park(arguments[0], arguments[1])
                        "status" -> parkingLot.printStatus()
                        "reg_by_color" -> println(parkingLot.regByColor(arguments[0]))
                    }
                }
            }
        } catch (e: IndexOutOfBoundsException) {
            println(e)
        }
    }
}
