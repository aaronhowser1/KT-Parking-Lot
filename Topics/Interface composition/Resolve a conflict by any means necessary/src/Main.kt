interface PrinterInterface {
    fun printSomething() = print("something")
    fun printSomethingElse() = print("something else")
}

interface NewLinePrinterInterface {
    fun printSomething() = println("new line something")
    fun printSomethingElse() = println("new line something else")
}

class MultiPrinterClass : PrinterInterface, NewLinePrinterInterface {
    override fun printSomething() = print("classy something")

    override fun printSomethingElse() {
        // Change only the following line
        super<NewLinePrinterInterface>.printSomethingElse()
    }
}