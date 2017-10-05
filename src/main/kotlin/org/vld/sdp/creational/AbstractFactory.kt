package org.vld.sdp.creational

/**
 * Letter Product interface
 */
interface Letter {
    val name: String
}

/**
 * Resume Product interface
 */
interface Resume {
    val name: String
}

/**
 * Document Creator Abstract Factory interface
 */
interface DocumentCreator {
    /**
     * Creates Letter Product
     */
    fun createLetter(name: String): Letter

    /**
     * Creates Resume Product
     */
    fun createResume(name: String): Resume
}

/**
 * Modern Letter Product interface implementation
 */
data class ModernLetter(override val name: String) : Letter

/**
 * Modern Resume Product interface implementation
 */
data class ModernResume(override val name: String) : Resume

/**
 * Modern Document Creator Abstract Factory interface implementation
 *
 * Modern Document Creator singleton encapsulates the knowledge about the modern documents product family
 */
object ModernDocumentCreator : DocumentCreator {
    // the only place where the concrete Modern Letter Product class is referenced
    override fun createLetter(name: String): Letter = ModernLetter(name)
    // the only place where the concrete Modern Resume Product class is referenced
    override fun createResume(name: String): Resume = ModernResume(name)
}

/**
 * Product interface implementation for fancy documents
 */
data class FancyLetter(override val name: String) : Letter

/**
 * Product interface implementation for fancy documents
 */
data class FancyResume(override val name: String) : Resume

/**
 * Fancy Document Creator Abstract Factory interface implementation
 *
 * Fancy Document Creator singleton encapsulates the knowledge about the fancy documents product family
 */
object FancyDocumentCreator : DocumentCreator {
    // the only place where the concrete Fancy Letter Product class is referenced
    override fun createLetter(name: String): Letter = FancyLetter(name)
    // the only place where the concrete Fancy Resume Product class is referenced
    override fun createResume(name: String): Resume = FancyResume(name)
}
