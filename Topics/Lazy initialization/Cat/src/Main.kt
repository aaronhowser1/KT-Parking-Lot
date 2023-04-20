class Cat {
    lateinit var name: String

    fun callName(): String {
        if (::name.isInitialized) {

        }
    }

}