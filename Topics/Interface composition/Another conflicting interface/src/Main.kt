interface PrinterInterface {
    fun printSomething() = print("something")
    fun printSomethingElse() = print("something else")
}
// Do not change the code above.

interface NewLinePrinterInterface {
    // Change only the code here.

    fun printSomething() = println("new line something")
    fun printSomethingElse2() = println("new line something else")
}

// Do not change the code below.
class MultiPrinterClass : PrinterInterface, NewLinePrinterInterface {
    override fun printSomething() = print("classy something")

    override fun printSomethingElse() {
        super.printSomethingElse()
    }
}