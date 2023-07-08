object Pangram {

    const val ALPHABET_SIZE = 26

    fun isPangram(input: String): Boolean {
        return hasRightNumberOfLetters(input) && hasAllLetters(input) && compareWithLetterArray(input) && hasRightNumberOfLetters2(input)
    }

    // Just for fun

    // Sol. 1 - Using a Set and counting the number of letters
    fun hasRightNumberOfLetters(input: String): Boolean {
        val letters = input.lowercase().filter { it.isLetter() }.toSet()
        return letters.size == ALPHABET_SIZE
    }

    // Sol. 2 - Using a Set and checking if all letters are present
    fun hasAllLetters(input: String): Boolean {
        val letters = input.lowercase().filter { it.isLetter() }.toSet()
        return letters.containsAll(('a'..'z').toList())
    }

    // Sol. 3 - Hardcoded array of letters
    fun compareWithLetterArray(input: String) : Boolean {
        val letters = "abcdefghijklmnopqrstuvwxyz".toCharArray().toSet()
        val inputChars = input.lowercase().filter { it.isLetter() }.toCharArray().toSet()
        return letters == inputChars
    }

    // Sol. 4 - Using a the distinct function
    fun hasRightNumberOfLetters2(input: String): Boolean {
        val letters = input.map { it.lowercase() }.joinToString { it }.filter { it.isLetter() }.toList().distinct()
        return letters.size == ALPHABET_SIZE
    }

}
