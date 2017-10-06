package org.vld.sdp.behavioral

/**
 * Element interface
 */
interface Phone {
    // visitor operation for every Visitor type
    // dynamic dispatch on the abstract Visitor interface type
    fun switchOnWiFi(wiFi: WiFi): String // WiFi visitor
    fun takePhoto(camera: Camera): String // Camera visitor
}

/**
 * Element interface implementation
 */
class XiaomiPhone : Phone {
    // dynamic Visitor dispatch trivial implementation
    override fun switchOnWiFi(wiFi: WiFi) = wiFi.switchOn(this)
    override fun takePhoto(camera: Camera) = camera.takePhoto(this)
}

/**
 * Element interface implementation
 */
class NokiaPhone : Phone {
    // dynamic Visitor dispatch trivial implementation
    override fun switchOnWiFi(wiFi: WiFi): String = wiFi.switchOn(this)
    override fun takePhoto(camera: Camera): String = camera.takePhoto(this)
}

/**
 * WiFi Visitor interface
 */
interface WiFi {
    // visit method overloaded for each Element type implements a new operation over all Elements
    // static dispatch on the concrete Element type
    fun switchOn(phone: XiaomiPhone): String
    fun switchOn(phone: NokiaPhone): String
}

/**
 * WiFi Visitor interface implementation
 */
class IntelWiFi : WiFi {
    override fun switchOn(phone: XiaomiPhone): String = "Switch on Intel WiFi on Xiaomi Phone"
    override fun switchOn(phone: NokiaPhone): String = "Switch on Intel WiFi on Nokia Phone"
}

/**
 * WiFi Visitor interface implementation
 */
class BroadcomWiFi : WiFi {
    override fun switchOn(phone: XiaomiPhone): String = "Switch on Broadcom WiFi on Xiaomi Phone"
    override fun switchOn(phone: NokiaPhone): String = "Switch on Broadcom WiFi on Nokia Phone"
}

/**
 * Camera Visitor interface
 */
interface Camera {
    // visit method overloaded for each Element type implements a new operation over all Elements
    // static dispatch on the concrete Element type
    fun takePhoto(phone: XiaomiPhone): String
    fun takePhoto(phone: NokiaPhone): String
}

/**
 * Camera Visitor interface implementation
 */
class SonyCamera : Camera {
    override fun takePhoto(phone: XiaomiPhone): String = "Take photo with Sony Camera on Xiaomi Phone"
    override fun takePhoto(phone: NokiaPhone): String = "Take photo with Sony Camera on Nokia Phone"
}

/**
 * Camera Visitor interface implementation
 */
class SamsungCamera : Camera {
    override fun takePhoto(phone: XiaomiPhone): String = "Take photo with Samsung Camera on Xiaomi Phone"
    override fun takePhoto(phone: NokiaPhone): String = "Take photo with Samsung Camera on Nokia Phone"
}
