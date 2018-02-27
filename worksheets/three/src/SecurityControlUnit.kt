import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class SecurityControlUnit(sensors: List<Sensor>, poller: Poller, notificationCentre: NotificationCentreImpl) :
        ControlUnit(sensors, poller, notificationCentre) {



    private fun checkTime() : Boolean {
        val ten = LocalTime.of(22,0)
        val six = LocalTime.of(6,0)
        val now = LocalDateTime.now()
        val today = LocalDate.now()


        return now.isAfter(LocalDateTime.of(today, ten)) || now.isBefore(LocalDateTime.of(today, six))
    }

    override fun pollSensors() {
        if(checkTime()) super.pollSensors()
        else println("During visiting hours Security Sensors are deactivated")
    }

}