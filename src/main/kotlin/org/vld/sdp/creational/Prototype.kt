package org.vld.sdp.creational

/**
 * Cell prototype and product interface
 */
interface CellPrototype {
    val membrane: String
    val ribosomes: Int
    /**
     * Clones new Cell instance from the actual prototype
     */
    fun clone(): CellPrototype
}

/**
 * Prokaryote Cell product. Data class automatically generates `copy()` method
 * which is used for prototypical cloning
 */
data class ProkaryoteCell(override val membrane: String, override val ribosomes: Int) : CellPrototype {
    override fun clone(): CellPrototype = copy()
}

/**
 * Eukaryote Cell product. Data class automatically generates `copy()` method
 * which is used for prototypical cloning
 */
data class EukaryoteCell(override val membrane: String, override val ribosomes: Int) : CellPrototype {
    override fun clone(): CellPrototype = copy()
}
