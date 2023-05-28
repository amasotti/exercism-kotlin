import kotlin.math.log

class Matrix(private val matrixAsString: String) {

    /**
     * The rows and columns of the matrix as lists of integers.
     */
    private val rows: List<List<Int>> = extractRows()
    private val columns: List<List<Int>> = rows.transpose()


    private fun extractRows(): List<List<Int>> {
        return this.matrixAsString
            .lines()
            .map { row ->
                row
                    .trim()
                    .split(" ")
                    .map { it.toInt() }
            }
    }


// First attempt at transpose
//    private fun List<List<Int>>.transpose2(): List<List<Int>> {
//        if (isEmpty()) return emptyList()
//
//        val nRows = first().size
//        val nCols = size
//
//        val transposed = MutableList(nRows) { MutableList<Int>(nCols) { this[0][0] } }
//
//        for (i in 0 until nRows) {
//            for (j in 0 until nCols) {
//                transposed[i][j] = this[j][i]
//            }
//        }
//
//        return transposed
//    }

    // Second attempt: Kotlin idiomatic / functional programming style
    private fun List<List<Int>>.transpose(): List<List<Int>> {

        return if (isEmpty()) emptyList()
        else first().indices.map { col -> // for each column / row (assuming the matrix is rectangular)
            map { row -> row[col]} // map each row to the value in the column
        }
    }


    fun column(colNr: Int): List<Int> {
        return columns[colNr - 1]
    }

    fun row(rowNr: Int): List<Int> {
        return rows[rowNr - 1]
    }
}
