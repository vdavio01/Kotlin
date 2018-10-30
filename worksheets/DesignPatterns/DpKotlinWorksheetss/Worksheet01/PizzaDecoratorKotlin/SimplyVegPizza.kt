package Worksheet01.PizzaDecoratorKotlin



class SimplyVegPizza : Pizza {
    override val description: String
        get() = "SimpleVegPizza (230)"
    override val price: Double
        get() = 230.0

      override fun toString(): String {
        return description
    }
}