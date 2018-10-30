package Worksheet01.Factory

import java.util.*

fun main(args: Array<String>) {
    val factory = ConcreteCreator()


    val pr1 = factory.create(listOf(1,2,3))
    val pr2 = factory.create("sst")
    val pr3 = factory.create(1)
    val myListOfproducts = listOf(pr1, pr2, pr3)

    myListOfproducts.forEach{ println(it :: class.simpleName)}

}