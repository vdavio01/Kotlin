package Worksheet01.PizzaDecoratorKotlin

class Meat(val pizza: Pizza) : Pizza {
    override val description: String
        get() = pizza.description + ", Meat(14.25)"
    override val price: Double
        get() = pizza.price + 14.25


    override fun toString(): String {
        return description
    }
}
