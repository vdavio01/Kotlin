open class ControlUnit(private val sensors: List<Sensor>, private val poller: Poller,
                       private val notificationCentre: NotificationCentre) {

    open fun pollSensors() {

        sensors.forEach { if(poller.poll(it)) takeAction(it) }
    }


    private fun takeAction(sensor: Sensor) {
        notificationCentre.takeActions(sensor)
    }
}