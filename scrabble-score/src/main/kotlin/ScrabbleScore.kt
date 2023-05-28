object ScrabbleScore {

    private val letterScore = mapOf(
        "aeioulnrst" to 1,
        "dg" to 2,
        "bcmp" to 3,
        "fhvwy" to 4,
        "k" to 5,
        "jx" to 8,
        "qz" to 10
    )

    fun scoreWord(word: String): Int {
        return word.lowercase()
            .sumOf {
                letterScore.entries
                    .find { entry -> entry.key.contains(it) }?.value ?: 0
            }
    }
}

