package Worksheet01.PizzaDecoratorKotlin

class Ham(val pizza: Pizza) : Pizza {
    override val description: String
        get() = pizza.description + ", Ham(18.12)"
    override val price: Double
        get() = pizza.price + 18.12


    override fun toString(): String {
        return description
    }

}