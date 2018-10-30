package Worksheet02.Builder

class CarDirector(private val carBuilder: CarBuilder): Director {

    override fun build() {
        carBuilder.buildCarType()
        carBuilder.buildBodyStyle()
        carBuilder.buildPower()
        carBuilder.buildEngine()
        carBuilder.buildBreaks()
        carBuilder.buildSeats()
        carBuilder.buildWindows()
        carBuilder.buildFuelType()
    }
}