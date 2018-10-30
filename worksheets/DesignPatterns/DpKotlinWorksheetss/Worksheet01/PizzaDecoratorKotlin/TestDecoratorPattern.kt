package Worksheet01.PizzaDecoratorKotlin

import java.text.DecimalFormat

fun main(args: Array<String>) {
    var pizza: Pizza = SimplyVegPizza()
    pizza = RomaTomatoes(pizza)
    pizza = GreenOlives(pizza)
    pizza = Spinach(pizza)
    printPizza(pizza)
    pizza = SimplyNonVegPizza()
    pizza = Meat(pizza)
    pizza = Cheese(pizza)
    pizza = Cheese(pizza)
    pizza = Ham(pizza)
    printPizza(pizza)

}

fun printPizza(pizza: Pizza) {
    val dformat = DecimalFormat("#.##")
    println("Desc: ${pizza.description}")
    println("Price: ${dformat.format(pizza.price)}")
}