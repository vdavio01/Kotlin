class NotificationCentreImpl: NotificationCentre {
    override fun takeActions(sensor: Sensor) {
        when(sensor) {
            is FireSensors -> println("Calling Fire department and owner")
            is SmokeSensors -> println("Calling Fire department and owner")
            is SecuritySensors -> println("Calling Police department and owner")
        }
    }
}