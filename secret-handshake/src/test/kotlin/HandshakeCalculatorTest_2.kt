import org.junit.Test
import kotlin.test.assertEquals

class HandshakeCalculatorTest_2 {

    @Test
    fun testThatInput1YieldsAWink() {
        assertEquals(
            listOf(Signal.WINK),
            HandshakeCalculator_2.calculateHandshake(1)
        )
    }


    @Test
    fun testThatInput2YieldsADoubleBlink() {
        assertEquals(
            listOf(Signal.DOUBLE_BLINK),
            HandshakeCalculator_2.calculateHandshake(2)
        )
    }


    @Test
    fun testThatInput4YieldsACloseYourEyes() {
        assertEquals(
            listOf(Signal.CLOSE_YOUR_EYES),
            HandshakeCalculator_2.calculateHandshake(4)
        )
    }


    @Test
    fun testThatInput8YieldsAJump() {
        assertEquals(
            listOf(Signal.JUMP),
            HandshakeCalculator_2.calculateHandshake(8)
        )
    }


    @Test
    fun testAnInputThatYieldsTwoActions() {
        assertEquals(
            listOf(Signal.WINK, Signal.DOUBLE_BLINK),
            HandshakeCalculator_2.calculateHandshake(3)
        )
    }


    @Test
    fun testAnInputThatYieldsTwoReversedActions() {
        assertEquals(
            listOf(Signal.DOUBLE_BLINK, Signal.WINK),
            HandshakeCalculator_2.calculateHandshake(19)
        )
    }


    @Test
    fun testReversingASingleActionYieldsTheSameAction() {
        assertEquals(
            listOf(Signal.JUMP),
            HandshakeCalculator_2.calculateHandshake(24)
        )
    }


    @Test
    fun testReversingNoActionsYieldsNoActions() {
        assertEquals(
            emptyList(),
            HandshakeCalculator_2.calculateHandshake(16)
        )
    }


    @Test
    fun testInputThatYieldsAllActions() {
        assertEquals(
            listOf(Signal.WINK, Signal.DOUBLE_BLINK, Signal.CLOSE_YOUR_EYES, Signal.JUMP),
            HandshakeCalculator_2.calculateHandshake(15)
        )
    }


    @Test
    fun testInputThatYieldsAllActionsReversed() {
        assertEquals(
            listOf(Signal.JUMP, Signal.CLOSE_YOUR_EYES, Signal.DOUBLE_BLINK, Signal.WINK),
            HandshakeCalculator_2.calculateHandshake(31)
        )
    }


    @Test
    fun testThatInput0YieldsNoActions() {
        assertEquals(
            emptyList(),
            HandshakeCalculator_2.calculateHandshake(0)
        )
    }


    @Test
    fun testThatInputWithLower5BitsNotSetYieldsNoActions() {
        assertEquals(
            emptyList(),
            HandshakeCalculator_2.calculateHandshake(32)
        )
    }

}