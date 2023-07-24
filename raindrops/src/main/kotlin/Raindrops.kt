object Raindrops {
    fun convert(n: Int): String {
        val factorToSound : Map<Int, String> = mapOf(3 to "Pling", 5 to "Plang", 7 to "Plong")
        return factorToSound
            .filterKeys { n % it == 0 }
            .values.joinToString("")
            .ifEmpty { n.toString() }
    }
    fun convert5(n: Int) : String {
        val factors: List<Pair<Int, String>> = listOf(Pair(3,"Pling"), Pair(5, "Plang"), Pair(7,"Plong"))
        val raindropSound = factors.fold("") { acc, (factor, sound) -> if (n % factor == 0) acc + sound else acc }

        return if (raindropSound.isBlank()) n.toString()  else raindropSound
    }

        fun convert2(n: Int): String {
            val factors = listOf(3 to "Pling", 5 to "Plang", 7 to "Plong")
            val result = factors.filter { (factor, _) -> n % factor == 0 }.map { it.second }.joinToString("")
            return if (result.isEmpty()) n.toString() else result
        }




}
