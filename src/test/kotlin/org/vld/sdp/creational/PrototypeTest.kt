package org.vld.sdp.creational

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PrototypeTest {

    @DisplayName("Given a prototypical instance. When clone a new instance from the prototype. Return a new cloned instance")
    @ParameterizedTest(name = "{0}")
    @MethodSource("prototypeProvider")
    fun givenPrototype_whenClonePrototype_thenReturnNewClonedInstance(
            prototype: CellPrototype,
            expectedCell: CellPrototype
    ) {
        // Given & When
        // clone a new Cell instance from the actual prototype using only CellPrototype interface
        val cell = prototype.clone()
        // Then
        assertThat(cell).isEqualTo(expectedCell)
    }

    fun prototypeProvider(): Stream<Arguments> {
        val prokaryoteCell = ProkaryoteCell("Prokaryote Membrane", 123)
        val eukaryoteCell = EukaryoteCell("Eukaryote Membrane", 456)
        return Stream.of(
                Arguments.of(prokaryoteCell, prokaryoteCell.copy()),
                Arguments.of(eukaryoteCell, eukaryoteCell.copy())
        )
    }

}
