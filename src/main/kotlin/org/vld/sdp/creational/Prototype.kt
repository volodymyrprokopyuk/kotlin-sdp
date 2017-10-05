package org.vld.sdp.creational

/**
 * Cell Product and Prototype interface
 */
interface CellPrototype {
    val membrane: String
    val ribosomes: Int
    /**
     * Clones a new [CellPrototype] instance from the actual prototype
     */
    fun clone(): CellPrototype
}

/**
 * Prokaryote Cell Product and Prototype interface implementation
 *
 * Data class automatically generates the `copy()` method which is used for prototypical cloning
 */
data class ProkaryoteCell(override val membrane: String, override val ribosomes: Int) : CellPrototype {
    override fun clone(): CellPrototype = copy()
}

/**
 * Eukaryote Cell Product and Prototype interface implementation
 *
 * Data class automatically generates the `copy()` method which is used for prototypical cloning
 */
data class EukaryoteCell(override val membrane: String, override val ribosomes: Int) : CellPrototype {
    override fun clone(): CellPrototype = copy()
}
