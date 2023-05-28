enum class Signal {
    WINK,
    DOUBLE_BLINK,
    CLOSE_YOUR_EYES,
    JUMP
}

object HandshakeCalculator {
    fun calculateHandshake(number: Int): List<Signal> {
        // Convert to Binary
        val binary = number.toBinary()

        // Get last 5 digits
        val lastFiveDigits = binary.takeLast(5)

        // Convert to Signals
        val secretHandshake = mutableListOf<Signal>()
        lastFiveDigits.reversed().forEachIndexed { index, digit ->
            if (digit == '1') {
                when (index) {
                    0 -> secretHandshake.add(Signal.WINK)
                    1 -> secretHandshake.add(Signal.DOUBLE_BLINK)
                    2 -> secretHandshake.add(Signal.CLOSE_YOUR_EYES)
                    3 -> secretHandshake.add(Signal.JUMP)
                    4 -> secretHandshake.reverse()
                }
            }
        }

        return secretHandshake
    }


    /**
     * Converts an integer to a binary string representation passing
     * through an unsigned integer.
     */
    @Throws(IllegalArgumentException::class)
    fun Int.toBinary(): String {
        if (this < 0) {
            throw IllegalArgumentException("Only positive numbers are allowed")
        }

        return toUInt().toString(2)
    }


}
