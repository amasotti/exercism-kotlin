object Isogram {

    fun isIsogram(input: String): Boolean {
        val letters = input.lowercase().filter(Char::isLetterOrDigit)
        return letters.toSet().size == letters.length
    }
}
