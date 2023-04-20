// write code here

sealed class Result {
    data class Success(val message: String)
    data class Error(val message: String)
}