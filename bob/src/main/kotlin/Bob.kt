object Bob {
    /**
     * Respond based on the input type.
     * @param input the input to respond to
     * @return the response
     */
    fun hey(input: String): String {
        val trimmedInput = input.trim()

        return when {
            trimmedInput.isEmpty() -> "Fine. Be that way!"
            trimmedInput.isYelledQuestion() -> "Calm down, I know what I'm doing!"
            trimmedInput.isShouting() -> "Whoa, chill out!"
            trimmedInput.isQuestion() -> "Sure."
            else -> "Whatever."
        }
    }
}

fun String.isQuestion() = this.last() == '?'
fun String.isShouting() = this.any { it.isLetter() } && this == this.uppercase()
fun String.isYelledQuestion() = this.isQuestion() && this.isShouting()