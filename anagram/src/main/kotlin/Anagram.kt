class Anagram(private val base : String) {

    private val baseChars = base.toCharArray().map { it.lowercaseChar() }

    fun match(anagrams: Collection<String>): Set<String> {
        return anagrams.filter { isAnagram(it) }.toSet()
    }

    fun isAnagram(word: String): Boolean {
        if (word.length != base.length) return false
        if (word.equals(base, ignoreCase = true)) return false
        val wordChars = word.toCharArray().map { it.lowercaseChar() }
        return wordChars.all { baseChars.contains(it) } && wordChars.all { wordChars.count { c -> c == it } == baseChars.count { c -> c == it } }
    }

}
