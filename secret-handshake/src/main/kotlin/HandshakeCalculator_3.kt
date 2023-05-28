import Signal.*

object HandshakeCalculator_3 {

    fun calculateHandshake(n: Int): List<Signal> =
        if (n >= 16)
            calculateHandshake(n - 16).reversed()
        else if (n >= 8)
            calculateHandshake(n - 8) + listOf(JUMP)
        else if (n >= 4)
            calculateHandshake(n - 4) + listOf(CLOSE_YOUR_EYES)
        else if (n >= 2)
            calculateHandshake(n - 2) + listOf(DOUBLE_BLINK)
        else if (n >= 1)
            listOf(WINK)
        else
            listOf()

    /**
     * The same as above but with binary literals
     * ... because it's fun
     */
    fun calculateHandshakeBinaryPlayground(n: Int): List<Signal> = when {
        n and 0b10000 != 0 -> calculateHandshakeBinaryPlayground(n - 0b10000).reversed()
        n and 0b1000 != 0 -> calculateHandshakeBinaryPlayground(n - 0b1000) + JUMP
        n and 0b100 != 0 -> calculateHandshakeBinaryPlayground(n - 0b100) + CLOSE_YOUR_EYES
        n and 0b10 != 0 -> calculateHandshakeBinaryPlayground(n - 0b10) + DOUBLE_BLINK
        n and 0b1 != 0 -> calculateHandshakeBinaryPlayground(n - 0b1) + WINK
        else -> emptyList()
    }

}
