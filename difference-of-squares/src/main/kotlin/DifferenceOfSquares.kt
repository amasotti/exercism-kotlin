/**
 * Functional approach + optimization through Arithmetic Sequences
 */
class Squares(private val upTo: Int) {
    fun squareOfSum(): Int {
        return upTo.times(upTo + 1).div(2).let { it * it }
    }

    fun sumOfSquares(): Int {
        return upTo.times(upTo + 1).times(2 * upTo + 1).div(6)
    }

    fun difference(): Int {
        return squareOfSum() - sumOfSquares()
    }
}