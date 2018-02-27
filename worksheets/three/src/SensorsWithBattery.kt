import java.util.*

abstract class SensorsWithBattery : Sensor {
    private var battery = 100.0
    val random = Random()
    fun reduceBattery(reducedBy: Int) {
        if(battery-reducedBy <0) battery = 0.0
        else battery-=reducedBy
    }


    fun remainingBattery() : Double = battery
}