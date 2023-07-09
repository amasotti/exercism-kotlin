data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(private val matrix: List<List<Int>>) {

    val saddlePoints: Set<MatrixCoordinate> by lazy { findSaddlePoints() }

    /**
     * Utility function to transpose a matrix (same as in Matrix exercise)
     */
    private fun List<List<Int>>.transpose(): List<List<Int>> {
        return firstOrNull()?.indices?.map { col -> // for each column / row (assuming the matrix is rectangular)
            map { row -> row[col]}  } ?: emptyList()
    }

    private fun findSaddlePoints(): Set<MatrixCoordinate> {

        // Find the max in each row and the min in each column as per task description
        val maxInRow = matrix.map { it.maxOrNull() }
        val minInCol = matrix.transpose().map { it.minOrNull() }

        fun isSaddlePoint(coordinate: MatrixCoordinate): Boolean {
            return matrix[coordinate.row - 1][coordinate.col - 1] == maxInRow[coordinate.row - 1] &&
                    matrix[coordinate.row - 1][coordinate.col - 1] == minInCol[coordinate.col - 1]
        }


        // Loop through all coordinates and check if the value is the max in the row and the min in the column
        val saddlePoints = matrix.indices.flatMap { row ->
            matrix[row].indices.map { col ->
                MatrixCoordinate(row + 1, col + 1) // +1 because the task description is 1-indexed -.-'
            }.filter { coordinate -> isSaddlePoint(coordinate) }
        }.toSet()

        return saddlePoints
    }
}