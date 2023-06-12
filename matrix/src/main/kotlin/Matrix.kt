import kotlin.math.log

class Matrix(matrixAsString: String) {

    private val rows: List<List<Int>>
    private val columns: List<List<Int>>

    /**
     * Parse matrix definition as string into rows and columns
     */
    init {
        rows = extractRows(matrixAsString)
        columns = rows.transpose()
    }


    private fun extractRows(matrixAsString: String): List<List<Int>> {
        return matrixAsString
            .lines()
            .map { row ->
                row
                    .trim()
                    .split(" ")
                    .map { it.toInt() }
            }
    }

    // Second attempt: Kotlin idiomatic / functional programming style
    private fun List<List<Int>>.transpose(): List<List<Int>> {

        return firstOrNull()?.indices?.map { col -> // for each column / row (assuming the matrix is rectangular)
            map { row -> row[col]}  } ?: emptyList()
    }

    fun column(colNr: Int): List<Int> = columns[colNr - 1]
    fun row(rowNr: Int): List<Int> = rows[rowNr - 1]

}
