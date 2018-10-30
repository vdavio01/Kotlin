import org.springframework.beans.factory.BeanFactory
import org.springframework.context.support.ClassPathXmlApplicationContext
import java.util.*

object SensorSystem {
    
    private val ROOT = System.getProperty("user.dir")

    private val beanFactory: BeanFactory
    @Throws(Exception::class)
    get() = ClassPathXmlApplicationContext("file:$ROOT/worksheets/three/beans.xml")


    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val factory = beanFactory
        val controlUnit = factory.getBean("controlUnit") as ControlUnit
        val securityControlUnit = beanFactory.getBean("securityControlUnit") as SecurityControlUnit
        val scanner = Scanner(System.`in`)
        var input = ""
        do {
            print("Type \"poll\" to poll all sensors once or \"exit\" to exit: ")
            input = scanner.nextLine()
            if (input == "poll") {
                controlUnit.pollSensors()
                securityControlUnit.pollSensors()
            }
        } while (input != "exit")
    }


}
