package org.vld.sdp.structural

/**
 * Glyph code data class for sharing (in the [GlyphFactory]) the intrinsic/invariant object state
 */
data class GlyphCode(val code: String)

/**
 * Glyph Flyweight interface for the extrinsic/variable object state modification
 */
interface Glyph {
    // position is the extrinsic/variable object state that can be modified
    var position: Int
    fun show(): String
}

/**
 * Glyph Flyweight interface implementation combines the intrinsic/invariant shared object state [GlyphCode]
 * with the extrinsic/variant object state to be passed through or interacted with the [Glyph] interface
 */
class GlyphFlyweight(private val code: GlyphCode, override var position: Int = 0) : Glyph {
    override fun show(): String = code.code
}

/**
 * Glyph Factory shares efficiently the [GlyphCode] cached instances with the intrinsic/invariant object state
 */
class GlyphFactory(private val glyphCodes: MutableMap<String, GlyphCode> = mutableMapOf()) {
    /**
     * Retrieves a [GlyphCode] based on the provided [code]
     *
     * If the [GlyphCode] does not exist creates a new [GlyphCode]
     * Returns [Glyph] based on the shared [GlyphCode] instance
     */
    fun retrieveGlyph(code: String): Glyph {
        // create Glyph Code if it does not exists
        if (code !in glyphCodes) glyphCodes[code] = GlyphCode(code)
        // create and return a new Glyph with the shared cached Glyph Code which corresponds to the requested code
        return GlyphFlyweight(glyphCodes[code] ?: GlyphCode(code))
    }
}
