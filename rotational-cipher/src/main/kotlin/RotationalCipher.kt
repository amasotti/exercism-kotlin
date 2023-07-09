class RotationalCipher(private val shift: Int) {

    fun encode(text: String): String {
        return text.map { char ->
            when {
                char.isLowerCase() -> shiftChar(char, 'a')
                char.isUpperCase() -> shiftChar(char, 'A')
                else -> char
            }
        }.joinToString("")
    }

    /**
     * Shifts a given character using the shift param of the cipher (see constructor).
     *
     * @param base The base character of the range in which `c` falls ('a' for lowercase, 'A' for uppercase).
     * @return The character obtained by shifting `c` by the cipher's shift value, wrapping around at 'z' or 'Z' as appropriate.
     *
     * This function treats 'a' or 'A' as the start of the alphabet (with an index of 0), and 'z' or 'Z' as the end (with an index of 25).
     * It computes the index of `c` relative to `base`, adds the cipher's shift value, and takes the result modulo 26 to get the new index.
     * It then returns the character corresponding to the new index.
     */
    fun shiftChar(char: Char, base: Char): Char {
        val index = char - base
        val newIndex = (index + shift) % 26
        return base + newIndex
    }
}
