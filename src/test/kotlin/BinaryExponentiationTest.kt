import org.junit.jupiter.api.Test
import kotlin.math.pow
import kotlin.test.assertEquals

class BinaryExponentiationTest {
    @Test
    fun testBinPow() {
        assertEquals(3.0.pow(0).toLong(), binPow(3, 0))
        assertEquals(3.0.pow(1).toLong(), binPow(3, 1))
        assertEquals(3.0.pow(2).toLong(), binPow(3, 2))
        assertEquals(3.0.pow(3).toLong(), binPow(3, 3))
        assertEquals(3.0.pow(27).toLong(), binPow(3, 27))
        assertEquals(3.0.pow(26).toLong(), binPow(3, 26))
        assertEquals(2.0.pow(30).toLong(), binPow(2, 30))
    }

    private fun slowPow(a: Long, b: Long, m: Long): Long {
        var result = 1L
        for (i in 0L..<b) {
            result = (result * a) % m
        }
        return result
    }

    @Test
    fun testBinPowMod() {
        val m = 1000000007L
        assertEquals(slowPow(3, 0, m), binPow(3, 0, m))
        assertEquals(slowPow(3, 1, m), binPow(3, 1, m))
        assertEquals(slowPow(3, 2, m), binPow(3, 2, m))
        assertEquals(slowPow(3, 3, m), binPow(3, 3, m))
        assertEquals(slowPow(3, 27, m), binPow(3, 27, m))
        assertEquals(slowPow(3, 26, m), binPow(3, 26, m))
        assertEquals(slowPow(2, 30, m), binPow(2, 30, m))
        // number b is selected so that the slow one doesn't take that long,
        // but perhaps it would be better to just generate and store some test vectors?
        assertEquals(slowPow(2, 200000000, m), binPow(2, 200000000, m))
    }
}