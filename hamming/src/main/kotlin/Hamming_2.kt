/**
 * Classic approach with for loop
 */
object Hamming_2 {

    fun compute(leftStrand: String, rightStrand: String): Int {

        require(leftStrand.length == rightStrand.length) { "left and right strands must be of equal length" }

        if (leftStrand === rightStrand) return 0

        var hammingDistance = 0
        for (i in leftStrand.indices) {
            if (leftStrand[i] != rightStrand[i]) {
                hammingDistance++
            }
        }

        return hammingDistance

    }
}