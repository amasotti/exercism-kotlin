object Acronym {
    fun generate(phrase: String) : String {
        val cleaned = cleanup(phrase)
        val tokens = tokenize(cleaned)
        return tokens
            .filter { it.isNotBlank() }
            .map { it.first().uppercase() }
            .joinToString("")
    }

    fun tokenize(phrase: String): List<String> {
        return phrase.split(" ", "-")
    }

    fun cleanup(phrase: String): String {
        return phrase.replace(Regex("[^a-zA-Z' ]"), " ")
    }
}
