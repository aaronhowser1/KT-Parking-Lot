fun isPalindrome(str: CharSequence): Boolean {

    val reverse = str.reversed()

    for (i in str.indices) {
        if (reverse[i] != str[i]) return false
    }

    return true

}