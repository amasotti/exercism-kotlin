import org.junit.Assert.assertThrows
import org.junit.Test
import kotlin.test.assertEquals

class HammingTest {

    @Test
    fun `empty strands`() {
        assertEquals(0, Hamming.compute("", ""))
    }

    @Test
    fun `single letter identical strands`() {
        assertEquals(0, Hamming.compute("A", "A"))
    }

    @Test
    fun `single letter different strands`() {
        assertEquals(1, Hamming.compute("G", "T"))
    }

    @Test
    fun `long identical strands`() {
        assertEquals(0, Hamming.compute("GGACTGAAATCTG", "GGACTGAAATCTG"))
    }

    @Test
    fun `long different strands`() {
        assertEquals(9, Hamming.compute("GGACGGATTCTG", "AGGACGGATTCT"))
    }

    @Test
    fun `disallow first strand longer`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Hamming.compute("AATG", "AAA")
        }
        assertEquals("left and right strands must be of equal length", exception.message)
    }

    @Test
    fun `disallow second strand longer`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Hamming.compute("ATA", "AGTG")
        }
        assertEquals("left and right strands must be of equal length", exception.message)
    }
}
