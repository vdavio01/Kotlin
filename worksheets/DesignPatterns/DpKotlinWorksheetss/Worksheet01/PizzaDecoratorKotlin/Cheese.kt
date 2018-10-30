package Worksheet01.PizzaDecoratorKotlin

class Cheese(val pizza: Pizza) : Pizza {
    override val description: String
        get() = pizza.description + ", Cheese (20.72)"
    override val price: Double
        get() = pizza.price + 20.72


    override fun toString(): String {
        return description
    }

}