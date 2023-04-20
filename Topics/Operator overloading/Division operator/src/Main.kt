// define the function
operator fun String.div(number: Int): Int {
    return this.toInt() / number
}