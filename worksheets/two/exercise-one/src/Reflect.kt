import java.lang.reflect.Modifier


fun main(args: Array<String>) {
    if (args.size != 1) {
        println("Requires a class name as argument to program")
        System.exit(-1)
    }

    val className = readLine()
    val myClass =  Class.forName(className)

   // val myKotlinClass = className!! :: class
   // val functions = myKotlinClass :: memberFunctions.get()
    //functions.forEach { print(it.name) }



    println("${myClass.name} is ${if (Modifier.isInterface(myClass.modifiers))  "an interface" else "a class"}")
    println("${myClass.name} has ${myClass.constructors.size} constructor/s")
    val constructor = myClass.constructors
    constructor.forEach { println("The constructor requires ${it.parameterTypes.size} arguments") }



    constructor.forEach { println("Type of arguments : " ) ; it.parameterTypes.forEach { print("${it.name}, ") }; println() }
    println()
    println("${myClass.name} has ${myClass.declaredFields.size} fields")
    myClass.declaredFields.forEach { println("Field ${it.name} requires ${it.genericType}") }

    println("${myClass.name} has ${myClass.declaredMethods.size} methods")
    myClass.declaredMethods.forEach { println(it.name+ " method requires " + it.parameters.size + " parameters") }





}

class Person(var age: String, val firstName: String, val secondName: String) {



    fun gettingOlder(){
        age+=1
    }
}
