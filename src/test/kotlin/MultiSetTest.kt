import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.NoSuchElementException
import kotlin.test.assertEquals

class MultiSetTest {
    @Test
    fun testAddRemoveContains() {
        val ms = MultiSet<Int>()
        assertEquals(false, ms.contains(5))
        ms.add(5)
        assertEquals(true, ms.contains(5))
        ms.remove(5)
        assertEquals(false, ms.contains(5))
    }

    @Test
    fun testRemoveNonPresent() {
        val ms = MultiSet<Int>()
        ms.remove(5)
        assertEquals(false, ms.contains(5))
    }

    @Test
    fun testContainsNonPresent() {
        val ms = MultiSet<Int>()
        assertEquals(false, ms.contains(6))
        ms.add(5)
        assertEquals(false, ms.contains(6))
        ms.remove(5)
        assertEquals(false, ms.contains(6))
    }

    @Test
    fun testIsEmpty() {
        val ms = MultiSet<Int>()
        assertEquals(true, ms.isEmpty())
        assertEquals(false, ms.isNotEmpty())
        ms.add(5)
        assertEquals(false, ms.isEmpty())
        assertEquals(true, ms.isNotEmpty())
        ms.remove(5)
        assertEquals(true, ms.isEmpty())
        assertEquals(false, ms.isNotEmpty())
    }

    @Test
    fun testCount() {
        val ms = MultiSet<Int>()
        assertEquals(0, ms.count(1))
        ms.add(1)
        assertEquals(1, ms.count(1))
        ms.add(1)
        assertEquals(2, ms.count(1))
        ms.remove(1)
        assertEquals(1, ms.count(1))
        ms.remove(1)
        assertEquals(0, ms.count(1))
    }

    @Test
    fun testCountRemovedNonPresent() {
        val ms = MultiSet<Int>()
        ms.remove(0)
        assertEquals(0, ms.count(5))
    }

    @Test
    fun testSorted() {
        val ms = MultiSet<Int>()
        ms.add(1)
        ms.add(3)
        ms.add(5)
        assertEquals(3, ms.floor(3))
        assertEquals(3, ms.ceiling(3))
        assertEquals(1, ms.lower(3))
        assertEquals(5, ms.higher(3))
        assertEquals(1, ms.lower(2))
        assertEquals(5, ms.higher(4))
        assertEquals(1, ms.first())
        assertEquals(5, ms.last())
    }

    @Test
    fun testValues() {
        val ms = MultiSet<Int>()
        ms.add(1)
        ms.add(3)
        ms.add(3)
        ms.add(5)
        val values = ms.values()
        assertEquals(true, values.contains(1))
        assertEquals(true, values.contains(3))
        assertEquals(true, values.contains(5))
    }

    @Test
    fun testClear() {
        val ms = MultiSet<Int>()
        ms.add(1)
        ms.clear()
        assertEquals(true, ms.isEmpty())
    }

    @Test
    fun testFirstLastEmpty() {
        val ms = MultiSet<Int>()
        assertThrows<NoSuchElementException> { ms.first() }
        assertThrows<NoSuchElementException> { ms.last() }
    }
}