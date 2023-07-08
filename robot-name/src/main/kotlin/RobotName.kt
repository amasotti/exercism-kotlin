import java.lang.StringBuilder

class Robot {

    var name : String = generateUniqueName()
        private set

    fun reset() {
        name = generateUniqueName()
    }

    companion object {
        private val usedNames = mutableSetOf<String>()

        fun generateUniqueName(): String {
            var newRandomName: String
            do {
                newRandomName = generateRandomName()
            } while (usedNames.contains(newRandomName))
            usedNames.add(newRandomName)
            return newRandomName
        }


        private fun generateRandomName(): String {
            return buildString {
                repeat(2) { append(('A'..'Z').random()) }
                repeat(3) { append((0..9).random()) }
            }
        }

    }
}
