object Accumulate {
    fun <T, R> accumulate(collection: List<T>, function: (T) -> R): List<R> {

        return if(collection.isNotEmpty()) listOf(function(collection[0])) + accumulate(collection.drop(1), function)
        else listOf()

        /**
         * Or return collection.map {function(it)} or return collection.map(function)
         */
    }
}


