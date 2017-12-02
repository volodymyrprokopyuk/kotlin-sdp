package org.vld.sdp.structural

/**
 * Xiaomi phone concrete implementation incompatible with the [Phone] interface expected by a client
 */
open class XiaomiPhone {
    /**
     * Turns on Xiaomi phone
     */
    open fun turnOn() {
    }
}

/**
 * Phone interface expected by a client
 */
interface Phone {
    /**
     * Switches on any phone
     */
    fun switchOn()
}

/**
 * Xiaomi Phone Adapter to expected by a client the [Phone] interface
 */
class XiaomiPhoneAdapter(val xiaomiPhone: XiaomiPhone) : Phone {
    /**
     * Switches on Xiaomi phone by delegating to `Xiaomi::turnOn()` method
     */
    override fun switchOn() = xiaomiPhone.turnOn()
}
