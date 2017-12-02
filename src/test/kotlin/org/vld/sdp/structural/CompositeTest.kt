package org.vld.sdp.structural

import org.assertj.core.api.Assertions.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CompositeTest {

    @DisplayName("Given an expression. When evaluate expression. Then return expression value")
    @ParameterizedTest(name = "{0} = {2}")
    @MethodSource("expressionProvider")
    fun givenExpression_whenEvaluateExpression_thenReturnExpressionValue(
            @Suppress("UNUSED_PARAMETER") expressionText: String,
            expression: Expression,
            expectedValue: Int
    ) {
        // Given & When
        // treat a simple Operand (Leaf) the same way as a complex Operation (Composite)
        // through uniform Expression interface (Component)
        val value = expression.evaluate()
        // Then
        assertThat(value).isEqualTo(expectedValue)
    }

    fun expressionProvider(): Stream<Arguments> {
        val add: (Int, Int) -> Int = { x, y -> x + y }
        val mul: (Int, Int) -> Int = { x, y -> x * y }
        return Stream.of(
                // Expressions have tree structure
                Arguments.of("1", Operand(1), 1),
                Arguments.of("1+2", Operation(Operand(1), Operand(2), add), 3),
                Arguments.of("1+2*3", Operation(Operand(1), Operation(Operand(2), Operand(3), mul), add), 7)
        )
    }
}
