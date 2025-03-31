/**
 * Calculate the value of a^b in O(log b) time using binary exponentiation.
 *
 * See: https://cp-algorithms.com/algebra/binary-exp.html#effective-computation-of-large-exponents-modulo-a-number
 * See: https://en.algorithmica.org/hpc/number-theory/exponentiation/
 */
fun binPow(a: Long, b: Long): Long {
    var result = 1L
    var base = a
    var exponent = b
    while (exponent > 0) {
        if (exponent % 2 == 1L) {
            result *= base
        }
        base *= base
        exponent /= 2
    }
    return result
}

/**
 * Calculate the value of a^b mod m in O(log b) time using binary exponentiation.
 *
 * See: https://cp-algorithms.com/algebra/binary-exp.html#effective-computation-of-large-exponents-modulo-a-number
 * See: https://en.algorithmica.org/hpc/number-theory/exponentiation/
 */
fun binPow(a: Long, b: Long, m: Long): Long {
    var result = 1L
    var base = a % m
    var exponent = b
    while (exponent > 0) {
        if (exponent % 2 == 1L) {
            result =  (result * base) % m
        }
        base = (base * base) % m
        exponent /= 2
    }
    return result
}