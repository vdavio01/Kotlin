object WordCount {

    fun phrase(phrase: String): Map<String, Int> {

        val myListOfStrings = phrase.toLowerCase()
                .replace(Regex("[^\\w']"), " ")
                .trim().split(Regex("\\s+"))
        return removeQuotation(myListOfStrings).groupBy { it }.mapValues { it.value.size }

    }

    private fun removeQuotation(list: List<String>): List<String> {
        return list.map{it.removePrefix("'").removeSuffix("'")}
    }

}