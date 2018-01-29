import org.junit.Before
import org.junit.Test
import kotlin.reflect.KClass
import kotlin.reflect.KVisibility
import kotlin.reflect.full.*
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.fail

class ClassDestroyer {
    private lateinit var ref: KClass<*>

    @Before
    fun setUp() {

        ref = TestingClass1 :: class
    }

    @Test
    fun moreThanFourFields(){

       assertEquals(4, ref.memberProperties.size)
    }

    @Test
    fun nonPrivateFields(){

        ref.memberProperties.forEach { assertTrue { it.visibility == KVisibility.PRIVATE }  }

    }

    @Test
    fun mutableListsAreNotAllowed(){

        val results =
                ref.declaredMemberProperties.filter{
                    (it.returnType.toString()
                            .startsWith("kotlin.collections.MutableList" ))
                }
        // not working
        //ref.members.filter { it is MutableList<*> }
        //ref.declaredMemberProperties.filter { it.returnType is MutableList<*> }
        //ref.declaredMemberProperties.filter { it is MutableList<*>}

        if(results.isNotEmpty()) {
            fail("Mutable Lists are not Allowed")
        }
    }

    @Test
    fun fewerThanTwoHelpFunctions() {

        val privateFunctions = ref.declaredMemberFunctions.filter { it.visibility == KVisibility.PRIVATE }

        if(privateFunctions.size < 2) {
            fail("You need at least two private helper functions")
        }
    }

    @Test
    fun exceptionsAreNotAllowed() {

        val classRef = Class.forName("TestingClass1")
        val myFunctionsWithException = classRef.declaredMethods.filter { it.exceptionTypes.isNotEmpty() }
        assertEquals(0, myFunctionsWithException.size)

    }

    @Test
    fun functionsThatReturnIntAreNotAllowed() {

        val classRef = Class.forName("TestingClass1")
        val myList = classRef.declaredMethods
                .filter { it.returnType == Int :: class.java }

        assertEquals(0, myList.size)
    }

    @Test
    fun zeroArgumentConstructorRequired() {

        assertEquals(1, ref.constructors.filter { it.parameters.isEmpty() }.size)


    }

}