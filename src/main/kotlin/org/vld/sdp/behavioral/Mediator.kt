package org.vld.sdp.behavioral

/**
 * Colleague interface to be used by the Mediator implementation
 */
interface Aircraft {
    fun send(message: String): Unit?
    fun receive(message: String): Unit?
}

/**
 * Mediator interface to be used by Colleague implementation
 */
interface ControlTower {
    fun notifyAirplane(message: String): Unit?
    fun notifyHelicopter(message: String): Unit?
}

/**
 * Colleague interface implementation uses [ControlTower] mediator interface
 */
open class Airplane(private val controlTower: ControlTower) : Aircraft {
    override fun receive(message: String) {}
    /**
     * Notifies [Helicopter] using only the [ControlTower] Mediator interface
     */
    override fun send(message: String) = controlTower.notifyHelicopter(message)
}

/**
 * Colleague interface implementation uses [ControlTower] mediator interface
 */
open class Helicopter(private val controlTower: ControlTower) : Aircraft {
    override fun receive(message: String) {}
    /**
     * Notifies [Airplane] using only the [ControlTower] Mediator interface
     */
    override fun send(message: String) = controlTower.notifyAirplane(message)
}

/**
 * Mediator interface implementation works with the [Airplane] and the [Helicopter] instances
 * through the [Aircraft] Colleague interface
 */
class AirControlTower : ControlTower {
    var airplane: Aircraft? = null
    var helicopter: Aircraft? = null

    override fun notifyAirplane(message: String) = airplane?.receive(message)

    override fun notifyHelicopter(message: String) = helicopter?.receive(message)
}
