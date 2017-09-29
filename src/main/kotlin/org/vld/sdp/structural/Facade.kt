package org.vld.sdp.structural

/**
 * CPU subsystem
 */
class Cpu {
    fun start(): String = "CPU started"
}

/**
 * RAM subsystem
 */
class Ram {
    fun load(): String = "RAM loaded"
}

/**
 * SSD subsystem
 */
class Ssd {
    fun read(): String = "SSD read"
}

/**
 * Computer facade interface
 */
interface Computer {
    fun switchOn(): String
}

/**
 * Computer facade interface implementation
 */
class Desktop(private val cpu: Cpu, private val ram: Ram, private val ssd: Ssd) : Computer {
    // hide complexities and dependencies of a larger system
    override fun switchOn(): String = "${cpu.start()}, ${ram.load()}, ${ssd.read()}"
}
