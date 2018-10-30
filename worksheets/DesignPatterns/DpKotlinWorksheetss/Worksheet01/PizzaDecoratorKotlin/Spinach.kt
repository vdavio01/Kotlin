package Worksheet01.PizzaDecoratorKotlin



class Spinach(val pizza: Pizza) : Pizza {
    override val description: String
        get() = pizza.description + ", Spinach (7.92)"
    override val price: Double
        get() = pizza.price + 7.92



    override fun toString(): String {
        return description
    }

}