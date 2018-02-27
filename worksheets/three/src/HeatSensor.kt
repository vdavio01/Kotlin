class HeatSensor(private val location: String) : SecuritySensors() {
    override fun isTriggered(): Boolean {
        return rnd.nextInt(100) < 11
    }

    override fun getLocation() = location

    override fun getSensortype() = "Heat Sensor"


}