class Matrix(private val matrixAsString: String) {

    private val rows: List<List<Int>>
    private val columns: List<List<Int>>

    init {
        rows = extractRows()
        columns = rows.transpose()
    }

    private fun extractRows(): List<List<Int>> {
        return this.matrixAsString
            .lines()
            .map { row -> row
                .trim()
                .split(" ")
                .map { it.toInt() }
            }
    }


    private fun List<List<Int>>.transpose(): List<List<Int>> {
        if (isEmpty()) return emptyList()

        val nRows = first().size
        val nCols = size

        val transposed = MutableList(nRows) { MutableList<Int>(nCols) { this[0][0] } }

        for (i in 0 until nRows) {
            for (j in 0 until nCols) {
                transposed[i][j] = this[j][i]
            }
        }

        return transposed
    }


        fun column(colNr: Int): List<Int> {
            return columns[colNr - 1]
        }

        fun row(rowNr: Int): List<Int> {
            return rows[rowNr - 1]
        }
}
