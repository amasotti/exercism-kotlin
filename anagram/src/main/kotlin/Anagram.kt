import kotlin.math.absoluteValue

class Anagram(private val base : String) {

    /**
     * Main Anagram function, called in the Unit Tests
     */
    fun match(anagrams: Collection<String>): Set<String> {
        return anagrams.filter { isAnagram(it) }.toSet()
    }

    private fun isAnagram(word: String): Boolean {
        // If the length is different, it's not an anagram
        if (word.length != base.length) return false

        // If the word is the same as the base, it's not an anagram
        if (word.toLowerCase() == base.toLowerCase()) return false


        // If the word has the same letters as the base, it's an anagram
        return base
            .measureDistanceFrom(word)
            .isZero()
    }

    /* -------------------- EXTENSIONS -------------------- */

    /**
     * Measures the distance between two strings in terms of characters not shared
     * with the base string
     */
    private fun String.measureDistanceFrom(other: String): Int {

        val baseWordCounts = this.toLowerCase().groupingBy { it }.eachCount()
        val wordCounts = other.toLowerCase().groupingBy { it }.eachCount()

        return baseWordCounts
            .map { (letter, count) -> (count - (wordCounts[letter] ?: 0)).absoluteValue }
            .sum()
    }

    /**
     * Just a more human-readable check for zero
     */
    private fun Int.isZero() = this == 0

}
