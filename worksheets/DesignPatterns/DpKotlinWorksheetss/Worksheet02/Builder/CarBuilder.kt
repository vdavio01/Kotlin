package Worksheet02.Builder

interface CarBuilder {
    fun buildCarType()
    fun buildBodyStyle()
    fun buildPower()
    fun buildEngine()
    fun buildBreaks()
    fun buildSeats()
    fun buildWindows()
    fun buildFuelType()
    fun getCar(): String
}