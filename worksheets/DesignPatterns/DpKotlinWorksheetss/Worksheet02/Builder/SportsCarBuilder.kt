package Worksheet02.Builder

class SportsCarBuilder: CarBuilder {

    private val spCar = Car("","","","","","","","")
    override fun buildCarType() {
        spCar.carType = "SPORTS"
    }

    override fun buildBodyStyle() {
        spCar.bodyStyle = "External dimensions: overall length (inches): 192.3,\n" +
                "\toverall width (inches): 75.5, overall height (inches): 54.2,\n" +
                "\twheelbase (inches): 112.3, front track (inches): 63.7,\n" +
                "\trear track (inches): 64.1 and curb to curb turning circle (feet): 37.7"
    }

    override fun buildPower() {
        spCar.power = "323 hp @ 6,800 rpm; 278 ft lb of torque @ 4,800 rpm"
    }

    override fun buildEngine() {
        spCar.engine = "3.6L V 6 DOHC and variable valve timing"
    }

    override fun buildBreaks() {
        spCar.breaks = "Four-wheel disc brakes: two ventilated. Electronic brake distribution.\n" +
                "\tStability control"
    }

    override fun buildSeats() {
        spCar.seats = "Driver sports front seat with one power adjustments manual height,\n" +
                "\tfront passenger seat sports front seat with one power adjustments"
    }

    override fun buildWindows() {
        spCar.windows = "Front windows with one-touch on two windows"
    }

    override fun buildFuelType() {
        spCar.fuelType = "Petrol 17 MPG city, 28 MPG highway, 20 MPG combined and 380 mi. range"
    }

    override fun getCar(): String {
        return return "-------------------------${spCar.carType}-------------------------\n" +
                "Body: ${spCar.bodyStyle}\n" +
                "Power: ${spCar.power}\n" +
                "Engine: ${spCar.engine}\n" +
                "Breaks: ${spCar.breaks}\n" +
                "Seats: ${spCar.seats}\n" +
                "Windows: ${spCar.windows}\n" +
                "Fuel Type: ${spCar.fuelType}"
    }
}