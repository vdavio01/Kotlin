
fun main(args: Array<String>) {

    val input = readLine()!!.split(' ')
    if (input.size < 2) {
        println("Requires a class name and a list of arguments")
        System.exit(-1)
    }

    val argumentList = input.subList(1,input.size)
    val className = input[0]
    ReflectionProgram(className, argumentList)

}

class ReflectionProgram(className: String, argsList :List<String>) {



    init{
        val constructorList =

        // "call the appropriate constructors that take a string as their only argument."
        // Create a map with the constructors and the Class of the required arguments for each one of them
                Class.forName(className).constructors
                        .filter { it.parameters.size == 1 }
                        .map { it to it.parameterTypes }.toMap()

        when(constructorList.size) {
            0 -> showErrorMessage()
            else -> {
                val desiredConstructors =
                // remove the redundant constructors
                //.all or .any will also work since the constructor has only 1 argument
                        constructorList.toMutableCopy()
                                .filter { it.value[0] == String :: class.java }

                argsList.forEach { arg ->
                    //Create and Display an object for each argument inside our list
                    desiredConstructors.forEach {
                        printOutObject(it.key.newInstance(arg) as Persons)
                    }
                }

            }
        }

    }

    private fun printOutObject(obj: Persons) {
        println(obj.firstName)
    }

    private fun showErrorMessage() {
        println("Can't find an appropriate constructor")
    }


    // from immutable map to HashMap
    private fun <K, V> Map<K, V>.toMutableCopy() = HashMap(this)


}



class Persons(val firstName: String, val secondName: String, val age: Int) {

    constructor(firstName: String, secondName: String): this(firstName, "N/A", 20)

    constructor(firstName: String, age: Int): this(firstName, "", age)

    constructor(firstName: String): this(firstName, "N/A",20)


}


