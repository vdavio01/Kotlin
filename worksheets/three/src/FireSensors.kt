class FireSensors(private val location: String) : SensorsWithBattery() {




    override fun isTriggered(): Boolean {
        reduceBattery(10)
        return random.nextInt(100) < 5
    }

    override fun getLocation() = location

    override fun getSensortype() = "Fire Sensor"


    fun getBatteryPercentage(): Double = remainingBattery()
}


