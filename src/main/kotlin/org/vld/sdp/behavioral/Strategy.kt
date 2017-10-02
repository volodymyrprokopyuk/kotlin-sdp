package org.vld.sdp.behavioral

/**
 * Strategy interface
 */
typealias Transport = () -> String

/**
 * Concrete strategy implementation
 */
fun goByBus() = "Go by Bus"

/**
 * Concrete strategy implementation
 */
fun goByTaxy() = "Go by Taxi"

/**
 * Transport company selects the right transport strategy based on the size of a tourist group
 */
class TransportCompany {
    fun requestTransport(groupSize: Int): Transport = if (groupSize <= 4) ::goByTaxy else ::goByBus
}
