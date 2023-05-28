import org.junit.Test
import kotlin.test.assertEquals

class HandshakeCalculatorTest_3 {
    @Test
    fun testThatInput1YieldsAWink() {
        assertEquals(listOf(Signal.WINK), HandshakeCalculator_3.calculateHandshake(1))
        assertEquals(listOf(Signal.WINK), HandshakeCalculator_3.calculateHandshakeBinaryPlayground(1))
    }


    @Test
    fun testThatInput2YieldsADoubleBlink() {
        assertEquals(listOf(Signal.DOUBLE_BLINK),HandshakeCalculator_3.calculateHandshake(2))
        assertEquals(listOf(Signal.DOUBLE_BLINK),HandshakeCalculator_3.calculateHandshakeBinaryPlayground(2))
    }


    @Test
    fun testThatInput4YieldsACloseYourEyes() {
        assertEquals(listOf(Signal.CLOSE_YOUR_EYES),HandshakeCalculator_3.calculateHandshake(4))
        assertEquals(listOf(Signal.CLOSE_YOUR_EYES),HandshakeCalculator_3.calculateHandshakeBinaryPlayground(4))
    }


    @Test
    fun testThatInput8YieldsAJump() {
        assertEquals(listOf(Signal.JUMP),HandshakeCalculator_3.calculateHandshake(8))
        assertEquals(listOf(Signal.JUMP),HandshakeCalculator_3.calculateHandshakeBinaryPlayground(8))
    }


    @Test
    fun testAnInputThatYieldsTwoActions() {
        assertEquals(listOf(Signal.WINK, Signal.DOUBLE_BLINK),HandshakeCalculator_3.calculateHandshake(3))
        assertEquals(listOf(Signal.WINK, Signal.DOUBLE_BLINK),HandshakeCalculator_3.calculateHandshakeBinaryPlayground(3))
    }


    @Test
    fun testAnInputThatYieldsTwoReversedActions() {
        assertEquals(listOf(Signal.DOUBLE_BLINK, Signal.WINK),HandshakeCalculator_3.calculateHandshake(19))
        assertEquals(listOf(Signal.DOUBLE_BLINK, Signal.WINK),HandshakeCalculator_3.calculateHandshakeBinaryPlayground(19))
    }


    @Test
    fun testReversingASingleActionYieldsTheSameAction() {
        assertEquals(listOf(Signal.JUMP),HandshakeCalculator_3.calculateHandshake(24))
        assertEquals(listOf(Signal.JUMP),HandshakeCalculator_3.calculateHandshakeBinaryPlayground(24))
    }


    @Test
    fun testReversingNoActionsYieldsNoActions() {
        assertEquals(emptyList(),HandshakeCalculator_3.calculateHandshake(16))
        assertEquals(emptyList(),HandshakeCalculator_3.calculateHandshakeBinaryPlayground(16))
    }


    @Test
    fun testInputThatYieldsAllActions() {
        assertEquals(listOf(Signal.WINK, Signal.DOUBLE_BLINK, Signal.CLOSE_YOUR_EYES, Signal.JUMP),HandshakeCalculator_3.calculateHandshake(15))
        assertEquals(listOf(Signal.WINK, Signal.DOUBLE_BLINK, Signal.CLOSE_YOUR_EYES, Signal.JUMP),HandshakeCalculator_3.calculateHandshakeBinaryPlayground(15))
    }


    @Test
    fun testInputThatYieldsAllActionsReversed() {
        assertEquals(listOf(Signal.JUMP, Signal.CLOSE_YOUR_EYES, Signal.DOUBLE_BLINK, Signal.WINK),HandshakeCalculator_3.calculateHandshake(31))
        assertEquals(listOf(Signal.JUMP, Signal.CLOSE_YOUR_EYES, Signal.DOUBLE_BLINK, Signal.WINK),HandshakeCalculator_3.calculateHandshakeBinaryPlayground(31))
    }


    @Test
    fun testThatInput0YieldsNoActions() {
        assertEquals(
            emptyList(),
            HandshakeCalculator_3.calculateHandshake(0)
        )
        assertEquals(
            emptyList(),
            HandshakeCalculator_3.calculateHandshakeBinaryPlayground(0))
    }


    @Test
    fun testThatInputWithLower5BitsNotSetYieldsNoActions() {
        assertEquals(
            emptyList(),
            HandshakeCalculator_3.calculateHandshake(32)
        )
        assertEquals(
            emptyList(),
            HandshakeCalculator_3.calculateHandshakeBinaryPlayground(32))

    }


}