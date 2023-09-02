object ResistorColor {

    private val colorMapping = mapOf(
        "black" to 0,
        "brown" to 1,
        "red" to 2,
        "orange" to 3,
        "yellow" to 4,
        "green" to 5,
        "blue" to 6,
        "violet" to 7,
        "grey" to 8,
        "white" to 9
    )

    fun colorCode(input: String): Int {
        return colorMapping[input]
            ?: throw IllegalArgumentException("Invalid color: $input")
    }

    fun colors(): List<String> = colorMapping.keys.toList()

}
