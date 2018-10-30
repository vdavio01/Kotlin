package Worksheet01.PizzaDecoratorKotlin



class RomaTomatoes(val pizza: Pizza) : Pizza {
    override val description: String
        get() = pizza.description + ", Roma Tomatoes($price)"
    override val price: Double
        get() = pizza.price + 5.20


    override fun toString(): String {
        return description
    }

}