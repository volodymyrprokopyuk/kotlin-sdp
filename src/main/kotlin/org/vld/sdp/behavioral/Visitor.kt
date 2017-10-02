package org.vld.sdp.behavioral

/**
 * Element interface
 */
interface Phone {
    // visitor operation for every visitor type
    // dynamic dispatch on visitor type
    fun switchOnWiFi(wiFi: WiFi): String // WiFi visitor
    fun takePhoto(camera: Camera): String // Camera visitor
}

/**
 * Element implementation
 */
class XiaomiPhone : Phone {
    // dynamic visitor dispatch trivial implementation
    override fun switchOnWiFi(wiFi: WiFi) = wiFi.switchOn(this)
    override fun takePhoto(camera: Camera) = camera.takePhoto(this)
}

/**
 * Element implementation
 */
class NokiaPhone : Phone {
    // dynamic visitor dispatch trivial implementation
    override fun switchOnWiFi(wiFi: WiFi): String = wiFi.switchOn(this)
    override fun takePhoto(camera: Camera): String = camera.takePhoto(this)
}

/**
 * WiFi visitor interface
 */
interface WiFi {
    // visit method overloaded for each element type implements a new operation over all elements
    // static dispatch on element type
    fun switchOn(phone: XiaomiPhone): String
    fun switchOn(phone: NokiaPhone): String
}

/**
 * WiFi visitor implementation
 */
class IntelWiFi : WiFi {
    override fun switchOn(phone: XiaomiPhone): String = "Switch on Intel WiFi on Xiaomi Phone"
    override fun switchOn(phone: NokiaPhone): String = "Switch on Intel WiFi on Nokia Phone"
}

/**
 * WiFi visitor implementation
 */
class BroadcomWiFi : WiFi {
    override fun switchOn(phone: XiaomiPhone): String = "Switch on Broadcom WiFi on Xiaomi Phone"
    override fun switchOn(phone: NokiaPhone): String = "Switch on Broadcom WiFi on Nokia Phone"
}

/**
 * Camera visitor interface
 */
interface Camera {
    // visit method overloaded for each element type implements a new operation over all elements
    // static dispatch on element type
    fun takePhoto(phone: XiaomiPhone): String
    fun takePhoto(phone: NokiaPhone): String
}

/**
 * Camera visitor implementation
 */
class SonyCamera : Camera {
    override fun takePhoto(phone: XiaomiPhone): String = "Take photo with Sony Camera on Xiaomi Phone"
    override fun takePhoto(phone: NokiaPhone): String = "Take photo with Sony Camera on Nokia Phone"
}

/**
 * Camera visitor implementation
 */
class SamsungCamera : Camera {
    override fun takePhoto(phone: XiaomiPhone): String = "Take photo with Samsung Camera on Xiaomi Phone"
    override fun takePhoto(phone: NokiaPhone): String = "Take photo with Samsung Camera on Nokia Phone"
}
