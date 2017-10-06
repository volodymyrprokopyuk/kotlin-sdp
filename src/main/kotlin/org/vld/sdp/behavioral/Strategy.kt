package org.vld.sdp.behavioral

/**
 * Strategy interface
 */
typealias Transport = () -> String

/**
 * Strategy interface implementation
 */
fun goByBus() = "Go by Bus"

/**
 * Strategy interface implementation
 */
fun goByTaxi() = "Go by Taxi"

/**
 * Transport Company selects at runtime the right transport strategy based on the size of a tourist group
 */
class TransportCompany {
    fun requestTransport(groupSize: Int): Transport = if (groupSize <= 4) ::goByTaxi else ::goByBus
}
