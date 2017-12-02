package org.vld.sdp.behavioral

import org.assertj.core.api.Assertions.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TemplateMethodTest {

    @DisplayName("Given an abstract algorithm specialization. When perform the algorithm. Then perform the right actions")
    @ParameterizedTest(name = "{1}")
    @MethodSource("transportProvider")
    fun givenAbstractAlgorithmSpecialization_whenPerformAlgorithm_thenPerformRightActions(
            employee: Employee,
            expectedActions: List<String>
    ) {
        // Given & When
        // client uses abstract algorithm template interface and executes the specialized algorithm in one operation
        val actions = employee.act()
        // Then
        assertThat(actions).isEqualTo(expectedActions)
    }

    fun transportProvider(): Stream<Arguments> = Stream.of(
            Arguments.of(Developer(), listOf("Employee gets up", "Developer programs", "Employee sleeps")),
            Arguments.of(Architect(), listOf("Employee gets up", "Architect designs", "Employee sleeps"))
    )
}
