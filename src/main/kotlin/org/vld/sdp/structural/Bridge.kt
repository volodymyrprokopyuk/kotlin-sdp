package org.vld.sdp.structural

/**
 * Abstraction: Phone, Tablet devices. [Device] abstraction and [Vendor] implementation are orthogonal dimensions
 */
interface Device {
    val type: String
    fun switchOn(): String
}

/**
 * Implementation: Xiaomi, Nokia vendors. [Device] abstraction and [Vendor] implementation are orthogonal dimensions
 */
interface Vendor {
    val brand: String
    /**
     * Vendor supports the provided [device]
     */
    fun support(device: Device): String
}

/**
 * Abstraction variant. Phone [Device] abstraction uses [Vendor] implementation
 */
class PhoneDevice(val vendor: Vendor, override val type: String = "Phone") : Device {
    // abstraction delegates to its implementation through the implementation interface
    override fun switchOn(): String = vendor.support(this)
}

/**
 * Abstraction variant. Tablet [Device] abstraction uses [Vendor] implementation
 */
class TabletDevice(val vendor: Vendor, override val type: String = "Tablet") : Device {
    // abstraction delegates to its implementation through the implementation interface
    override fun switchOn(): String = vendor.support(this)
}

/**
 * Implementation variant
 */
class XiaomiVendor(override val brand: String = "Xiaomi") : Vendor {
    // implementation uses Device abstraction
    // combination of Device/Vendor implementations is here
    override fun support(device: Device): String = "$brand supports ${device.type}"
}

/**
 * Implementation variant
 */
class NokiaVendor(override val brand: String = "Nokia") : Vendor {
    // implementation uses Device abstraction
    // combination of Device/Vendor implementations is here
    override fun support(device: Device): String = "$brand supports ${device.type}"
}
