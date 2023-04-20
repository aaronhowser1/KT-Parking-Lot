// define the function
operator fun List<Double>.invoke(markLimit: Double): Double {
    val amountOver = this.filter {it >= markLimit}

    return amountOver.sum() / amountOver.count()

}