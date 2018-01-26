import java.lang.reflect.Constructor


fun main(args: Array<String>) {
    if (args.size < 2) {
        println("Requires a class name and a list of arguments")
        System.exit(-1)
    }

    val className = readLine()
    val creator = ReflectionProgram(Class.forName(className), "Vasileios", "Davios", "Greece" )
    val myObj = creator.createObject()

    if(myObj!=Unit) {
        println((myObj as testingReflectionClass).firstName)
    }

}

class ReflectionProgram(private val inputClass: Class<*>, private val arg1: String, private val arg2: String, private val arg3: String) {

    private fun printError(errorMessage: String) {
        println(errorMessage)
    }

    fun createObject(): Any  {


        val constructorList = inputClass.constructors
                .filter { it.parameterCount == 3 }
                .filter { it.parameterTypes.all { it == String :: class.java } }

        val constructor = constructorList.first() // Only one constructor can have this signature
        inputClass.getConstructor(String:: class.java).newInstance("vasilis")

        return when(constructor) {
            is Constructor<out Any> -> constructor.newInstance(arg1, arg2, arg3)
            else -> printError("We can't find the appropriate constructor")

        }
    }

}

class testingReflectionClass(val firstName: String, val secondName: String, placeOfBirth: String)


