import org.junit.Assert.assertEquals
import org.junit.Test

import kotlin.test.assertFailsWith

class FunctionsTest {

    @Test // "Tail removes the first element"
    fun tailTest() {
        assertEquals(listOf(2, 3, 4), tail(listOf(1, 2, 3, 4)))

        assertEquals(emptyList<Int>(), tail(listOf(1)))

        assertFailsWith(IllegalArgumentException::class,
                "Tail function should throw illegal argument exception when called with empty list ",
                { tail(emptyList<Int>()) }
        )
    }

    @Test // "orig.setHead changes the first element of the listOf"
    fun setHeadTest() {
        assertEquals(listOf("0", "B", "C"), setHead(listOf("A", "B", "C"), "0"))

        assertEquals(listOf("a"), setHead(listOf(), "a"))
    }

    @Test // "orig.drop removes N elements from the front of the listOf"
    fun dropTest() {
        assertEquals(listOf(3), drop(listOf(1, 2, 3), 2))

        assertEquals(emptyList<Int>(), drop(listOf(1,2,3), 4))

        assertEquals(emptyList<Int>(), drop(listOf(1,2),2))

        assertEquals(listOf(4,5,6), drop(listOf(1,2,3,4,5,6), 3))

        assertEquals(listOf("b","c","d"), drop(listOf("a","b","c","d"), 1))
    }

    @Test // "init removes the last element"
    fun initTest() {
        assertEquals(listOf("A", "B", "C"), init(listOf("A", "B", "C", "D")))

        assertEquals(emptyList<String>(), init(listOf("A")))

        assertFailsWith(IllegalArgumentException::class,
                "Init function throws illegal argument exception when called with empty list ",
                { init(emptyList<Int>()) }
        )
    }

    @Test
    fun initTestSingle() {
        assertEquals(emptyList<String>(), init(listOf("A")))
    }

    @Test
    fun initTestEmpty() {
        assertFailsWith(IllegalArgumentException::class) {
            init(emptyList<String>())
        }
    }

    // Folding
    @Test // "orig.foldLeft computes the correct value"
    fun foldLeftTest() {
        assertEquals("Hello", foldLeft(listOf("H", "e", "l", "l", "o"), "", { x, y -> x + y }))
    }

    @Test // "sum produces the correct sum"
    fun sumTest() {
        //double
        assertEquals(0.0, sum(listOf(1.0, 2.0, 3.0, -3.0, -2.0, -1.0)), 0.01)
        //float
        assertEquals(0f, sum(listOf(1f,2f,3f,-3f,-2f,-1f)))
        //int
        assertEquals(0,sum(listOf(1,2,3,-3,-2,-1)))
        //long
        assertEquals(0L,sum(listOf(1L,2L,3L,-3L,-2L,-1L)))



    }

    @Test // "product produces the correct product"
    fun productTest() {
        assertEquals(120.0, product(listOf(1.0, 2.0, 3.0, 4.0, 5.0)), 0.01)
    }

    @Test // "orig.length calculates the orig.length"
    fun lengthTest() {
        assertEquals(5, length("Hello".toList()))
    }

    @Test // "orig.reverse reverses the listOf"
    fun reverseTest() {
        assertEquals("olleH".toList(), reverse("Hello".toList()))
    }

    @Test // "orig.flatten flattens the nested listOf"
    fun flattenTest() {
        assertEquals(listOf(1, 2, 3, 4, 5, 6), flatten(listOf(listOf(1, 2, 3), listOf(4, 5, 6))))
    }

    // Map and Filter
    @Test // "map creates a new listOf of the correct values"
    fun mapTest() {
        assertEquals((2 to 11).toList(), map((1 to 10).toList(), { x -> x + 1 }))
    }

    @Test // "orig.filter filters the listOf"
    fun filterTest() {
        assertEquals((1..5).toList(), filter((-5..5).toList(), { x: Int -> x > 0 }))
    }

    @Test // "orig.flatMap maps and flattens"
    fun flatMapTest() {
        assertEquals(listOf(1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5),
                flatMap((1..5).toList(), { x -> (x..5).toList() }))

    }

    // Combined

    @Test // "orig.maxAverage calculates the max average"
    fun maxAverageTest() {
        val listof = listOf(Triple(1.0, 2.5, 3.0), Triple(4.5, 5.0, 6.0), Triple(4.0, 3.25, 4.0))
        assertEquals(4.33, maxAverage(listof), 0.01)
    }

    @Test // "orig.variance calculates the correct orig.variance"
    fun varianceTest() {
        val v = variance(listOf(1.0, 2.0, 3.0, 4.0, 5.0))
        assertEquals("If you got 2.5, you divided by the wrong thing, probably.", 2.0, v, 0.01)
    }
}
