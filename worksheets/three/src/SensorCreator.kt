class SensorCreator {

    fun createHazardSensors(amount: Int): ArrayList<Sensor> {

        val hazardList=
                (1..amount).flatMap { listOf(FireSensors("Floor ($it)"),
                        SmokeSensors("Floor ($it)"))}.toList()
        return ArrayList(hazardList)
    }

    fun createSecuritySensors(amount:Int): ArrayList<Sensor> {
        val securitySensorsList =
                (1..amount).flatMap { listOf(HeatSensor("Floor ($it)"), MotionSensor("Floor($it)")) }
        return ArrayList(securitySensorsList)
    }
}