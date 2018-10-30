package Worksheet01.PizzaDecoratorKotlin

class SimplyNonVegPizza : Pizza {
    override val description: String
        get() = "SimpleVegPizza (350)"
    override val price: Double
        get() = 350.0


    override fun toString(): String {
        return description
    }

}

fun main(args: Array<String>){
    var pizza = SimplyNonVegPizza()

}