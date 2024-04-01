import kotlin.math.pow

object ArmstrongNumber {
    fun check(input: Int): Boolean {
        val digits: List<Int> = input.digits()
        val power = digits.count()
        return input == digits.sumOfPowers(power)
    }

    private fun Int.digits() = this.toString().map { Character.getNumericValue(it) }
    private fun List<Int>.sumOfPowers(power: Int) = sumOf { it.toDouble().pow(power).toInt() }
}
