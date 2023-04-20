// complete the definition
infix fun List<Double>.average(markLimit: Double): Double {
    val aboveLimit = this.filter {it > markLimit}
    return aboveLimit.sum() / aboveLimit.count()
}