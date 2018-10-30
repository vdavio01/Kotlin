package Worksheet02.Builder

class SedanCarBuilder: CarBuilder {

    private var sedanCar = Car("","","","","","","","")
    override fun getCar(): String {
       return "-------------------------${sedanCar.carType}-------------------------\n" +
               "Body: ${sedanCar.bodyStyle}\n" +
               "Power: ${sedanCar.power}\n" +
               "Engine: ${sedanCar.engine}\n" +
               "Breaks: ${sedanCar.breaks}\n" +
               "Seats: ${sedanCar.seats}\n" +
               "Windows: ${sedanCar.windows}\n" +
               "Fuel Type: ${sedanCar.fuelType}"
    }


    override fun buildCarType() {
        sedanCar.carType = "SEDAN"
    }

    override fun buildBodyStyle() {
        sedanCar.bodyStyle = "External dimensions: overall length (inches): 202.9,\n" +
                "\toverall width (inches): 76.2, overall height (inches): 60.7,\n" +
                "\twheelbase (inches): 112.9, front track (inches): 65.3,\n" +
                "\trear track (inches): 65.5 and curb to curb turning circle (feet): 39.5"
    }

    override fun buildPower() {
        sedanCar.power = "285 hp @ 6,500 rpm; 253 ft lb of torque @ 4,000 rpm"
    }

    override fun buildEngine() {
        sedanCar.engine = "3.5L Duramax V 6 DOHC"
    }

    override fun buildBreaks() {
        sedanCar.breaks = "Four-wheel disc brakes: two ventilated. Electronic brake distribution"
    }

    override fun buildSeats() {
        sedanCar.seats = "Front seat centre armrest.Rear seat centre armrest.Split-folding rear seats"
    }

    override fun buildWindows() {
        sedanCar.windows = "Laminated side windows.Fixed rear window with defroster"
    }

    override fun buildFuelType() {
        sedanCar.fuelType = "  Diesel 19 MPG city, 29 MPG highway, 23 MPG combined and 437 mi. range"
    }
}