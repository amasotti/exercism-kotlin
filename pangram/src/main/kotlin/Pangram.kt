object Pangram {

    const val ALPHABET_SIZE = 26

    fun isPangram(input: String): Boolean {
        val letters = input.toLowerCase().filter { it.isLetter() }.toSet()
        return letters.size == ALPHABET_SIZE
    }
}
