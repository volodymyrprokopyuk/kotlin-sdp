package org.vld.sdp.structural

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FlyweightTest {


    @Test
    @DisplayName("Given a glyph factory. When retrieve the same glyph twice. Then return the shared/cached glyph")
    fun givenGlyphFactory_whenRetrieveTheSameGlyphTwice_thenReturnSharedCachedGlyph() {
        // Given
        val glyphFactory: GlyphFactory = GlyphFactory()
        // When
        // client works with Glyph Factory which shares/caches the intrinsic/invariant object state (GlyphCode)
        val glyph1 = glyphFactory.retrieveGlyph("a")
        glyph1.position = 1
        val glyph2 = glyphFactory.retrieveGlyph("h")
        glyph2.position = 2
        val glyph3 = glyphFactory.retrieveGlyph("a")
        glyph3.position = 3
        // client works with glyphs only through Glyph interface
        // which only allows the extrinsic/variant object state modification and the interaction with the objct
        val word = listOf(glyph2, glyph3, glyph1).sortedBy(Glyph::position).map(Glyph::show).reduce { word, glyph ->
            word + glyph
        }
        // Then
        assertThat(word).isEqualTo("aha")
    }

}
