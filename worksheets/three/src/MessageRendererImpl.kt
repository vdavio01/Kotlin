class MessageRendererImpl: MessageRenderer {
    override fun triggeredSensorMessage(sensor: Sensor) {
        println("A ${sensor.getSensortype()} sensor was triggered at ${sensor.getLocation()}")
    }

    override fun pollSensorMessage(sensor: Sensor) {
        println("Polled ${sensor.getSensortype()} at ${sensor.getLocation()} successfully")
    }


}