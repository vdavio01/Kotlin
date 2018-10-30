package Worksheet02.Builder

fun main(args: Array<String>){


    var carBuilder: CarBuilder = SedanCarBuilder()
    var director = CarDirector(carBuilder)
    director.build()

    println(carBuilder.getCar())

    carBuilder = SportsCarBuilder()
    director = CarDirector(carBuilder)
    director.build()
    println(carBuilder.getCar())
}