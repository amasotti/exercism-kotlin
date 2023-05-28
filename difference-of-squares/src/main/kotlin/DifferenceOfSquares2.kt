/**
 * Functional Approach - but no clever algorithm
 */
class Squares2(private val upTo: Int) {

    fun sumOfSquares(): Int {
        return (1..upTo).map { it * it }.sum()
    }

    fun squareOfSum(): Int {
        return (1..upTo).sum().let { it * it }
    }

    fun difference(): Int {
        return squareOfSum() - sumOfSquares()
    }
}