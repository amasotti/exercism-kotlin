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
        val tokenRegex = """[a-zA-Z0-9']+""".toRegex()

        val tokens = mutableListOf<String>()

        tokenRegex.findAll(phrase).forEach {
            match -> tokens.add(match.value)
        }

        return removeQuotation(tokens)
    }

    fun removeQuotation(tokens: List<String>): List<String> = tokens.map { it.replace("^\'|^\"|\"$|\'$".toRegex(), "") }


    fun countTokenOccurrences(tokens: List<String>): Map<String, Int> = tokens.groupingBy { it }.eachCount()


}
