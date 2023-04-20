interface Color {
    fun getColorCode(): String
}

interface Shape {
    fun getShape(): String
    fun countAngles(): Int
}

class RedCircle : Color, Shape {
    override fun getColorCode(): String = "FF0000"
    override fun getShape(): String = "Circle"
    override fun countAngles(): Int = 0
}

object Red : Color {
    override fun getColorCode(): String = "FF0000"
}

object Circle : Shape {
    override fun getShape(): String = "Circle"
    override fun countAngles(): Int = 0
}

// Do not change the code above.
// Change only *line* below.

class RedCircleComposition : Color by Red, Shape by Circle