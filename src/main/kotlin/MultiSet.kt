import java.util.*

class MultiSet<V> {
    private val data = TreeMap<V, Int>()

    /**
     * Add one instance of the given value to this multiset.
     */
    fun add(value: V) {
        data[value] = count(value) + 1
    }

    /**
     * Remove one instance of the given value from this multiset.
     */
    fun remove(value: V) {
        val curCount = count(value)
        if (curCount == 0) return
        data[value] = curCount - 1
        if (data[value] == 0) data.remove(value)
    }

    /**
     * Remove all the values from this multiset.
     */
    fun clear() = data.clear()

    /**
     * Returns `true` if this multiset contains the given value.
     */
    fun contains(value: V): Boolean = data.containsKey(value)

    /**
     * Returns the count of the given value in this multiset, or 0 if it is not present.
     */
    fun count(value: V): Int = data.getOrDefault(value, 0)

    /**
     * Returns `true` if this multiset is empty.
     */
    fun isEmpty() = data.isEmpty()

    /**
     * Returns `true` if this multiset is not empty.
     */
    fun isNotEmpty() = data.isNotEmpty()

    /**
     * Return the greatest value less than or equal to the given value, or `null` if there is no such value.
     */
    fun floor(value: V): V? = data.floorKey(value)

    /**
     * Return the least value greater than or equal to the given value, or `null` if there is no such value.
     */
    fun ceiling(value: V): V? = data.ceilingKey(value)

    /**
     * Return the greatest value less than the given value, or `null` if there is no such value.
     */
    fun lower(value: V): V? = data.lowerKey(value)

    /**
     * Return the least value greater than the given value, or `null` if there is no such value.
     */
    fun higher(value: V): V? = data.higherKey(value)

    /**
     * Return the first (lowest) value.
     * @throws NoSuchElementException if this set is empty
     */
    fun first(): V = data.firstKey()

    /**
     * Return the last (highest) value.
     * @throws NoSuchElementException if this set is empty
     */
    fun last(): V = data.lastKey()

    /**
     * Returns a [Set] view of the values contained in this multiset.
     *
     * @return a set view of the values contained in this multiset
     */
    fun values() = data.keys

    fun println() {
        println(data)
    }
}