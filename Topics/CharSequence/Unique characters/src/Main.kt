fun countUniqueChars(sequence: CharSequence): Int {

    val uniqueLetters = mutableListOf<Char>()

    for (char in sequence) if (!uniqueLetters.contains(char)) uniqueLetters.add(char)

    return uniqueLetters.size
}