class Anagram(private val word: String) {

    fun match(anagrams: Collection<String>): Set<String> {

        fun anagramChecker(str1: String, str2: String): Boolean {

            return if(str1 == str2) false
            else str1.length == str2.length &&
                    str1.toCharArray().sorted() == str2.toCharArray().sorted()

        }

        return anagrams.filter { anagramChecker(it.toLowerCase(), word.toLowerCase()) }.toSet()
    }
}


