interface Sensor {
    /**
     * returns true/false for whether the sensor is triggered or not.
     * Different sensors have different rules applied to them.
     */
    fun isTriggered(): Boolean

    /**
     * returns a description of the location of the sensor such as "Lobby", "1st floor", or "In the auditorium".
     */
    fun getLocation(): String

    /**
     * returns a textual description of the sensor type such as "Fire sensor" or "Smoke sensor".
     */
    fun getSensortype(): String

    /**
     * Since we have sensor that don't have battery we violate interface segregation principle thus we will move
     * the getBatteryPercentage function to an abstract class
     */

    //fun getBatteryPercentage(): Double
}