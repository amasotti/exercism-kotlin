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
            val letters = ('A'..'Z').random().toString() + ('A'..'Z').random().toString()
            val numbers = ( 0..9).random().toString() + (0..9).random().toString() + (0..9).random().toString()
            return letters + numbers
        }

    }
}
