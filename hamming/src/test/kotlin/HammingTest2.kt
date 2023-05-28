import org.junit.Assert.assertThrows
import org.junit.Test
import kotlin.test.assertEquals

class HammingTest2 {
    @Test
    fun `empty strands`() {
        assertEquals(0, Hamming_2.compute("", ""))
    }

    @Test
    fun `single letter identical strands`() {
        assertEquals(0, Hamming_2.compute("A", "A"))
    }

    @Test
    fun `single letter different strands`() {
        assertEquals(1, Hamming_2.compute("G", "T"))
    }

    @Test
    fun `long identical strands`() {
        assertEquals(0, Hamming_2.compute("GGACTGAAATCTG", "GGACTGAAATCTG"))
    }

    @Test
    fun `long different strands`() {
        assertEquals(9, Hamming_2.compute("GGACGGATTCTG", "AGGACGGATTCT"))
    }

    @Test
    fun `disallow first strand longer`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Hamming_2.compute("AATG", "AAA")
        }
        assertEquals("left and right strands must be of equal length", exception.message)
    }

    @Test
    fun `disallow second strand longer`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Hamming_2.compute("ATA", "AGTG")
        }
        assertEquals("left and right strands must be of equal length", exception.message)
    }
}
