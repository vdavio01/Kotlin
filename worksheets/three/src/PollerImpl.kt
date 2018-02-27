class PollerImpl(private val msR: MessageRenderer): Poller {

    override fun poll(sensor: Sensor): Boolean {

        return if(sensor.isTriggered()){
            msR.triggeredSensorMessage(sensor)
            true
        } else {
            msR.pollSensorMessage(sensor)
            false
        }

    }
}