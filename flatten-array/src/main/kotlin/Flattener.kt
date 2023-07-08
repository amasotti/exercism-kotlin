object Flattener {
    fun flatten(source: Collection<Any?>): List<Any> = source.flatMap { it -> when(it) {
       is Collection<*> -> flatten(it)
        else -> listOfNotNull(it)
    }
    }
}
