class MotionSensor(private val location: String): SecuritySensors() {

    override fun isTriggered(): Boolean {
        return rnd.nextInt(100) < 15
    }

    override fun getLocation() = location

    override fun getSensortype() = "Motion Sensor"
}