object WordCount {

    fun phrase(phrase: String): Map<String, Int> {
        val tokens = tokenize(phrase.lowercase())
        return countTokenOccurrences(tokens)
    }


    /**
     * Tokenize the phrase. According to the task description
     * contractions count as one word, all other chars are ignored
     */
    fun tokenize(phrase: String): List<String> {
        val tokenRegex = Regex("""[a-zA-Z0-9']+""")

        val tokens = tokenRegex.findAll(phrase).map {
            match -> match.value
        }.toList()

        return removeQuotation(tokens)
    }

    fun removeQuotation(tokens: List<String>): List<String> =  tokens.map { it.replace(Regex("^['\"]|['\"]$"), "") }


    fun countTokenOccurrences(tokens: List<String>): Map<String, Int> = tokens.groupingBy { it }.eachCount()


}
