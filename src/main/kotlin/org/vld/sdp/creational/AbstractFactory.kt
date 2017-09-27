package org.vld.sdp.creational

/**
 * Letter product interface
 */
interface Letter {
    val name: String
}

/**
 * Resume product interface
 */
interface Resume {
    val name: String
}

/**
 * Document Creator abstract factory interface
 */
interface DocumentCreator {
    /**
     * Creates Letter product
     */
    fun createLetter(name: String): Letter

    /**
     * Creates Resume product
     */
    fun createResume(name: String): Resume
}

/**
 * Modern Letter concrete product
 */
data class ModernLetter(override val name: String) : Letter

/**
 * Modern Resume concrete product
 */
data class ModernResume(override val name: String) : Resume

/**
 * Modern Document Creator concrete factory singleton encapsulates knowledge about Modern documents product family
 */
object ModernDocumentCreator : DocumentCreator {
    // the only place where concrete Modern Letter product is referenced
    override fun createLetter(name: String): Letter = ModernLetter(name)
    // the only place where concrete Modern Resume product is referenced
    override fun createResume(name: String): Resume = ModernResume(name)
}

/**
 * Fancy Letter concrete product
 */
data class FancyLetter(override val name: String) : Letter

/**
 * Fancy Resume concrete product
 */
data class FancyResume(override val name: String) : Resume

/**
 * Fancy Document creator concrete factory singleton encapsulates knowledge about Fancy documents product family
 */
object FancyDocumentCreator : DocumentCreator {
    // the only place where concrete Fancy Letter product is referenced
    override fun createLetter(name: String): Letter = FancyLetter(name)
    // the only place where concrete Fancy Resume product is referenced
    override fun createResume(name: String): Resume = FancyResume(name)
}

