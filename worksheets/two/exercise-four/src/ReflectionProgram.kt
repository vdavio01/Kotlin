import kotlin.reflect.KClass
import kotlin.reflect.KVisibility
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.declaredMemberProperties

class Me {
    private var myAge = 32
    private var myFirstName = "Vasileios"
    private var mySurname = "Davios"


    fun birthday() {
        println("It's ${this.myFirstName}s birthday today!!!. He/She is now $myAge")
        myAge += 1
    }


     override fun toString(): String {
       return "$myFirstName $mySurname is $myAge old"
    }

}

fun main(args: Array<String>) {

    val rfp = ReflectionProgram1(Me :: class)
    rfp.showAll()
}


class ReflectionProgram1(myClass: KClass<*>) {

  val jClass = Class.forName("Me")

    fun setUp() {
        val myobj = Me()
        val otinanai = myobj.javaClass.getDeclaredField("myAge")
        val obj =jClass.getConstructor().newInstance() as Me
        val actualValue = otinanai
        val field = Me :: class.declaredMemberProperties

        println(actualValue)
    }


    val kClass = myClass

    fun showAll(){

        println(kClass)
        val smt = kClass.createInstance()
        val myProperties = kClass.declaredMemberProperties
        myProperties.forEach { it.apply { it.visibility.apply { KVisibility.PUBLIC } } }

        myProperties.forEach { println(it.visibility) }
        kClass.declaredMemberProperties.forEach { println("${it.name} is a ${it.returnType} ") }


    }
}