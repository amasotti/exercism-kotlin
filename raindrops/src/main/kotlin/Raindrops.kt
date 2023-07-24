object Raindrops {
    fun convert(n: Int): String {
        val factors = listOf(3 to "Pling", 5 to "Plang", 7 to "Plong")
        val result = factors.filter { (factor, _) -> n % factor == 0 }.map { it.second }.joinToString("")
        return if (result.isEmpty()) n.toString() else result
    }
}
