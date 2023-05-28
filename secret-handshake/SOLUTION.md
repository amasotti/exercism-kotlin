## Solutions

### [Solution 1](./src/main/kotlin/SecretHandshake.kt)

1. Convert to binary string (creating an ad-hoc extension function for `Int`)
2. Take the 5 right-most bits and reverse them (as per the challenge)
3. Iterate over the bits and add the corresponding action to the list of actions
   using a `when` expression, if the bit is `1` otherwise do nothing.

~~~kotlin
// Extension function to convert an Int to a binary string
fun Int.toBinary(): String {
    require(this >= 0) { "Only positive numbers are allowed" }
    return toUInt().toString(2)
}

// Solution 1
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
                0 -> secretHandshake.add(WINK)
                1 -> secretHandshake.add(DOUBLE_BLINK)
                2 -> secretHandshake.add(CLOSE_YOUR_EYES)
                3 -> secretHandshake.add(JUMP)
                4 -> secretHandshake.reverse()
            }
        }
    }

    return secretHandshake
}
~~~

### [Solution 2](./src/main/kotlin/HandshakeCalculator_2.kt)

*Proposed by GrahamLea, it's a clever solution that uses bitwise operations for achieving the same result*.
I haven't benchmarked it, but I'm pretty sure it's faster than my solution, since string operations are
always slower than bitwise operations.

~~~kotlin
// Infix extension function to check if a bit is set
private infix fun Int.hasBitSet(bit: Int): Boolean = ((this shr bit) and 0x1) == 1

// Solution 2
fun calculateHandshake(number: Int): List<Signal> {
    return mutableListOf<Signal>().apply {
        if (number hasBitSet 0) add(Signal.WINK)
        if (number hasBitSet 1) add(Signal.DOUBLE_BLINK)
        if (number hasBitSet 2) add(Signal.CLOSE_YOUR_EYES)
        if (number hasBitSet 3) add(Signal.JUMP)
        if (number hasBitSet 4) reverse()
    }
}
~~~

**How It Works**

1. The `hasBitSet` function is defined as an infix function on the `Int` type. It checks whether a specific bit in the
   integer value is set (1) or not (0) using bitwise operations. The `shr` is the bitwise shift right operator, and the
   `and` operator is used to mask the result to a single bit. The `0x1` is a hexadecimal literal for the binary value
   `0001` = `1`. So together this expression checks whether the bit at the given position is set or not.

2. The `calculateHandshake` function takes a decimal number as input and returns a list of `Signal` objects representing
   the secret handshake signals.

3. Within the `calculateHandshake` function, a `mutableListOf<Signal>` is created using the `apply` function, allowing
   for immediate operations on the list.

4. Each signal is conditionally added to the list based on whether the corresponding bit in the input number is set,
   using the `hasBitSet` function in an intuitive and readable manner.

5. If the fifth bit is set, indicating a reversal of the signals, the `reverse()` function is called on the list to
   reverse the order of the signals.

6. The final list of signals is returned as the result of the `calculateHandshake` function.

### [Solution 3](./src/main/kotlin/HandshakeCalculator_3.kt)

*Posted by hugueschabot, it's a brilliant solution that uses recursion and powers of 2 to achieve the same result*.
The file linked contains my modified version.

~~~kotlin
object HandshakeCalculator {
    fun calculateHandshake(n: Int): List<Signal> =
        if (n >= 16)
            calculateHandshake(n - 16).reversed()
        else if (n >= 8)
            calculateHandshake(n - 8) + listOf(Signal.JUMP)
        else if (n >= 4)
            calculateHandshake(n - 4) + listOf(Signal.CLOSE_YOUR_EYES)
        else if (n >= 2)
            calculateHandshake(n - 2) + listOf(Signal.DOUBLE_BLINK)
        else if (n >= 1)
            listOf(Signal.WINK)
        else
            listOf()
}
~~~

**How It Works**
The `calculateHandshake` function takes an integer `n` as input and returns a list of `Signal` objects representing a
secret handshake sequence.

The function utilizes a recursive approach and conditional statements to build the sequence of signals based on the
value of `n`.

Here's how the function works step by step:

1. The function checks if `n` is greater than or equal to 16. If `n` is greater than or equal to 16, it recursively
   calls `calculateHandshake` with `n - 16` to generate the sequence for the remaining value after subtracting 16. The
   resulting sequence is then reversed using the `reversed()` function to indicate the reversal of signals. Notice that
   this is not a tailrec function, so the reversal of the sequence is not optimized and happens after the recursive
    call returns.

2. If `n` is not greater than or equal to 16, the function moves to the next condition. It checks if `n` is greater than
   or equal to 8. If true, it recursively calls `calculateHandshake` with `n - 8` to generate the remaining sequence and
   adds `JUMP` to the end of the sequence using the `+` operator and the `listOf` function.

3. The function proceeds to check if `n` is greater than or equal to 4. If true, it recursively
   calls `calculateHandshake` with `n - 4` and appends `CLOSE_YOUR_EYES` to the resulting sequence.

4. Next, the function checks if `n` is greater than or equal to 2. If true, it recursively calls `calculateHandshake`
   with `n - 2` and adds `DOUBLE_BLINK` to the sequence.

5. Finally, the function checks if `n` is equal to 1. If true, it returns a list containing only `WINK`.

6. If none of the previous conditions are met, indicating that `n` is 0 or a negative value, the function returns an
   empty list.

By recursively applying these conditions, the `calculateHandshake` function builds the secret handshake sequence based
on the input value `n`.
