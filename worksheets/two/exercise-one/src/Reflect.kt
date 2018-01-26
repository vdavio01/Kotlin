fun main(args: Array<String>) {
    if (args.size != 1) {
        println("Requires a class name as argument to program")
        System.exit(-1)
    }

    val className = readLine()
    val myClass =  Class.forName(className)


    println("Class ${myClass.name} has ${myClass.constructors.size} constructor/s")
    val constructor = myClass.constructors
    constructor.forEach { println("${myClass.name} has ${constructor.size}.\nThe constructor requires ${it.parameterTypes.size} arguments") }
    println("Type of arguments : ")
    constructor.forEach { it.parameterTypes.forEach { print("${it.name}, ") } }
    println()
    println("${myClass.name} has ${myClass.declaredFields.size} fields")
    myClass.declaredFields.forEach { println("Field ${it.name} requires ${it.genericType}") }

    println("${myClass.name} has ${myClass.declaredMethods.size} methods")
    myClass.declaredMethods.forEach { println(it.name+ " method requires " + it.parameters.size + " parameters") }



}

class Person(var age: Int, val firstName: String, val secondName: String) {

    fun gettingOlder(){
        age+=1
    }
}
