interface Poller {

    fun poll(sensor: Sensor) : Boolean
}