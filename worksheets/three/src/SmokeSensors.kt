

class SmokeSensors(private val location : String) : SensorsWithBattery() {


    override fun isTriggered(): Boolean {
        reduceBattery(20)
        return random.nextInt(100) < 10

    }

    override fun getLocation() = location


    override fun getSensortype() = "Smoke Sensor"


    fun getBatteryPercentage(): Double = remainingBattery()
}