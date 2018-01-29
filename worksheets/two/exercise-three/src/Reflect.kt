import java.io.IOException


class TestingClass1() {

    constructor(name: String, surname: String, age: Int): this () {
        this.name = name
        this.surname = surname
        this.age = age
    }
    private var name = "Vasilis"
    private var surname = "Davios"
    private var age = 32
    private val country = "Greece"
    private val team = "Olympiakos"

    private var myImmutableList = listOf(1,2,3)
    private var myMutableList = mutableListOf("str1","str2","str3")

    @Throws (IllegalArgumentException :: class, IOException :: class)
    private fun simpleAddition(x: Int, y : Int): Int{
        if(x < 5 || y <  5) throw IllegalArgumentException("Each argument must be greater than 5")
        else return x + y
    }


    private fun simpleDivision(x: Int, y: Int) = x / y
    fun simpleModulo(x: Int, y: Int) = x % y

}




