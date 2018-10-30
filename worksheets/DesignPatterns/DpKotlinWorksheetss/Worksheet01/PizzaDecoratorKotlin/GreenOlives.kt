package Worksheet01.PizzaDecoratorKotlin

class GreenOlives(val pizza: Pizza) : Pizza {
    override val description: String
        get() = pizza.description + ", Green Olives (5.47)"
    override val price: Double
        get() = pizza.price + 5.47



    override fun toString(): String {
        return description
    }
}