class Triangle<out T : Number>(val a: T, val b: T, val c: T) {

    /**
     * The sides of the triangle as a list
     */
    private val sides = listOf(a, b, c)

    /**
     * The triangle is valid if all sides are greater than 0 and the sum of any two sides is greater than the third
     */
    init {
        requireSidesGreaterThanZero()
        requireNonDegeneratedTriangle()
    }

    private fun requireSidesGreaterThanZero() {
        check(sides.all { it.toDouble() > 0 }) { "All sides must be greater than 0" }
    }

    private fun requireNonDegeneratedTriangle() {
        check(sides.all { it.toDouble() <= sides.sumOf { it.toDouble() } - it.toDouble() }) { "Triangle inequality violation" }
    }

    /**
     * A triangle has n distinct sides if the number of distinct sides is n
     */
    private infix fun List<Number>.hasNDistinctSides(n: Int): Boolean = this.distinct().size == n

    /**
     * A triangle is equilateral if all sides are equal
     */
    val isEquilateral: Boolean = sides hasNDistinctSides(1)

    /**
     * A triangle is isosceles if two sides are equal
     */
    val isIsosceles: Boolean = sides hasNDistinctSides(2)

    /**
     * A triangle is scalene if all sides are different
     */
    val isScalene: Boolean = sides hasNDistinctSides(3)
}
