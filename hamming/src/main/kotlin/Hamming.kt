object Hamming {

    fun compute(leftStrand: String, rightStrand: String): Int {

        require(leftStrand.length == rightStrand.length) { "left and right strands must be of equal length" }

        val test = leftStrand.zip(rightStrand)

        return leftStrand
            .zip(rightStrand)
            .count { it.first != it.second }
    }

//    fun compute2(leftStrand: String, rightStrand: String): Int {
//        require(leftStrand.length == rightStrand.length) { "left and right strands must be of equal length" }
//
//        var hammingDistance = 0
//        val leftstrandArr = leftStrand.toCharArray()
//        val rightstrandArr = rightStrand.toCharArray()
//        leftstrandArr.forEachIndexed() { index, char ->
//            if (char != rightstrandArr[index]) {
//                hammingDistance++
//            }
//        }
//        return hammingDistance
//    }
}
