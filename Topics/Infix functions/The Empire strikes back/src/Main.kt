infix fun List<Ship>.battle(ammunitionLimit: Int): List<String> {
    val overLimit = mutableListOf<String>()

    for ((name, ammo) in this) {
        if (ammo > ammunitionLimit) overLimit.add(name)
    }

    return overLimit

}