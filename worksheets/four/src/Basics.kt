import java.math.BigInteger

/**
 * This file contains the functions you need
 * to implement. Please make sure to read the documentation associated
 * with each function and provide a sensible implementation.
 */

/**
 * Write a function called add that takes two Int parameters
 * and returns their sum.
 *
 * @param a operand a
 * @param b operand b
 * @return the sum
 */
fun add(a: Int, b: Int): Int = a + b

/**
 * Write a function that returns the inclusive Range from start to end.
 *
 * HINT: Look at the Scaladoc for Int/RichInt to find the answer.
 *
 * @param start the start of the range
 * @param end the end of the range
 * @return the inclusive Range from start to end
 */
fun inRange(start: Int, end: Int): IntRange = start..end

/**
 * Write a function that returns a Range of odd n odd integers starting at 1.
 *
 * HINT: Look at the Scaladoc for Int/RichInt to find the answer.
 *
 * @param n the number of odd integers in the range
 * @return a Range of odd integers, excluding the last add integer
 */
fun oddRange(n: Int): IntProgression  = 1..n step 2

/**
 * Write a function that returns the minimum integer in the Array r.
 *
 * Your implementation must conform to the following rules:
 *
 * - You must use a while loop.
 * - You may use both immutable (val) and mutable (var) variables.
 * - You must use an if expression.
 *
 * @param r the array of integers
 * @return the minimum integer in the array
 */
fun minWhile(r: Array<Int>): Int {
    var min = r[0]
    var i = 0
    while (i < r.size) {
        if(r[i] < min) {
            min = r[i]
        }
        i++
    }
    return min
}

/**
 * Write a function that returns the minimum integer in the Array r.
 *
 * Your implementation must conform to the following rules:
 *
 * - You must use a for loop (not for comprehension).
 * - You may use both immutable (val) and mutable (var) variables.
 * - You may not use an if expression.
 *
 * @param r the array of integers
 * @return the minimum integer in the array
 */
fun minFor(r: Array<Int>): Int {
    var min = r[0]

    for(i in r ) {
        when {
            min > i -> min = i
        }
    }
    return min
}

/**
 * Write a function called minRecursive that returns the minimum integer in the Array r.
 *
 * Your implementation must conform to the following rules:
 *
 * - You may not use any loops.
 * - You may not use any mutable (var) or immutable (val) variables.
 *
 * HINT: You might want to look at the Scaladoc for Array to see some
 * useful methods you can use to solve this.
 *
 * @param r the array of integers
 * @return the minimum integer in the array
 */
fun minRecursive(r: Array<Int>): Int {
    //return r.reduce { x, y -> when{x >= y -> y else -> x} }
    return when {

        r.size == 1 -> r[0]
        r[0] >= r[1] -> minRecursive(r.copyOfRange(1,r.size))
        else -> {
            r[1] = r[0]
            minRecursive(r.copyOfRange(1,r.size))
        }
    }
}

/**
 * Return the base 36 equivalent of the BitInt b.
 *
 * HINT: Poke around Scaladoc to find a way of doing this in Scala.
 *
 * @param b a big integer
 * @return the base 36 equivalent
 */
fun base36(b: BigInteger): String = b.toString(36)


/**
 * Splits the String s in half.
 *
 * This function returns a tuple (f, e), where the f is the first
 * half of the string and e is the last half of the string.
 *
 * For example,
 *   splitInHalf("abcfun") => ("abc", "fun")
 *   splitInFalf("abcde")  => ("ab", "cde")
 *
 * Your implementation must conform to the following rules:
 *
 * - You may not use any loops.
 * - You may not use recursion.
 * - You may not use any mutable (var) or immutable (val) variables.
 *
 * HINT: You might find something useful in the String and StringOps Scaladoc.
 *
 * @param s the string to split
 * @return the split string as a tuple
 */
fun splitInHalf(s: String): Pair<String, String> {

    return Pair(s.substring(0 until s.length/2), s.substring(s.length/2 until s.length))
    // return when{
    //    s.length % 2 == 0 -> Pair(s.dropLast(s.length/2), s.drop(s.length/2))
    //     else -> Pair(s.dropLast(s.length/2 +1), s.drop(s.length/2))
    // }
}

/**
 * Determines if the given string s is a palindrome.
 *
 * Your implementation must conform to the following rules:
 *
 * 
 * - You may not use any other loops.
 * - You may not use any mutable (var) variables.
 *
 * You should normalize the string s before determining if
 * it is a palindrome. That is, you should not distinguish
 * between upper and lowercase, you should not consider
 * spaces, and you should eliminate the punctuation
 * characters . ? , ; ! - '.
 *
 * HINT: You should consult the Scaladoc for String and
 * StringOps to help you with your solution.
 *
 * @param s the potential palindrome
 * @return true if s is a palindrome; false otherwise
 */
fun isPalindrome(s: String): Boolean  {
    val newS = s.toLowerCase().replace(Regex("\\p{Punct}"),"").replace(Regex("\\s+"),"")
    return newS == newS.reversed()
}


/**
 * Counts the number of space delimited words in the provided array of strings.
 *
 * This function takes an array of strings that represent lines in a text file.
 * This function must return a Map from String to Int where the String is a
 * word found across all lines and the Int is the number of times that word
 * was seen. For example:
 *
 * wordCount(Array("this is a sentence.", "this is a sentence too!"))
 *
 * would return
 *
 * Map("this" -> 2,
 *     "is" -> 2,
 *     "a" -> 2,
 *     "sentence." -> 1,
 *     "sentence" -> 1,
 *     "too!" -> 1)
 *
 * You may assume that all words are delimited by spaces. You need not worry
 * about punctuation. You can implement this however you wish.
 *
 * @param lines the lines of a text file
 * @return a map from words to the number of times that word was seen
 */
fun wordCounter(lines: Array<String>): Map<String, Int> {

    return lines.flatMap { it.split(' ') }
            .groupBy { it }
            .mapValues { it.value.size }

    // val listOFListOFStrings = mutableListOf<List<String>>()
    // lines.forEach { listOFListOFStrings.add(it.split(Regex("\\s")) }
    // listOFListOFStrings.flatMap{ it}.groupBy {it}.mapValues {it.value.size}

}



