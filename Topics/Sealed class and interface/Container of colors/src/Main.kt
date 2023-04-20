// write code here
sealed class Color {
    object Red: Color()
    object Green: Color()
    object Blue: Color()

    class CustomColor(val hex: String): Color()
}