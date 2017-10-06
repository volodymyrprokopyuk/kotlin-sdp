package org.vld.sdp.structural

/**
 * CPU subsystem/dependency of a larger [Computer] system
 */
class Cpu {
    fun start(): String = "CPU started"
}

/**
 * RAM subsystem/dependency of a larger [Computer] system
 */
class Ram {
    fun load(): String = "RAM loaded"
}

/**
 * SSD subsystem/dependency of a larger [Computer] system
 */
class Ssd {
    fun read(): String = "SSD read"
}

/**
 * Computer Facade higher-level, simplified interface to a larger [Computer] system
 */
interface Computer {
    fun switchOn(): String
}

/**
 * Computer Facade higher-level, simplified interface implementation
 */
class Desktop(private val cpu: Cpu, private val ram: Ram, private val ssd: Ssd) : Computer {
    // hide complexities and dependencies of a larger system
    override fun switchOn(): String = "${cpu.start()}, ${ram.load()}, ${ssd.read()}"
}
