package org.vld.sdp.creational

/**
 * Product interface
 */
interface Letter {
    val name: String
}

/**
 * Product interface
 */
interface Resume {
    val name: String
}

/**
 * Abstract Factory interface
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
 * Product interface implementation for modern documents
 */
data class ModernLetter(override val name: String) : Letter

/**
 * Product interface implementation for modern documents
 */
data class ModernResume(override val name: String) : Resume

/**
 * Abstract Factory interface implementation for modern documents
 *
 * Abstract Factory singleton encapsulates knowledge about modern documents product family
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
 * Abstract Factory interface implementation for fancy documents
 *
 * Abstract Factory singleton encapsulates knowledge about fancy documents product family
 */
object FancyDocumentCreator : DocumentCreator {
    // the only place where the concrete Fancy Letter Product class is referenced
    override fun createLetter(name: String): Letter = FancyLetter(name)
    // the only place where the concrete Fancy Letter Product class is referenced
    override fun createResume(name: String): Resume = FancyResume(name)
}
