package org.vld.sdp.creational

import org.assertj.core.api.Assertions.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PrototypeTest {

    @DisplayName("Given a prototypical instance of a cell. When clone a new cell instance from the prototype. Return a new cloned cell instance")
    @ParameterizedTest(name = "{0}")
    @MethodSource("prototypeProvider")
    fun givenCellPrototype_whenCloneCellInstance_thenReturnNewClonedCellInstance(
            prototype: CellPrototype,
            expectedCell: CellPrototype
    ) {
        // Given & When
        // clone a new cell instance from the actual cell prototype using the `CellPrototype::clone()` method
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
