package org.vld.sdp.behavioral

import org.assertj.core.api.Assertions.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InterpreterTest {

    val interpreter = Interpreter()

    @DisplayName("Given an expressiona and an interpreter. When interpret the expression. Then return the expression value")
    @ParameterizedTest(name = "{0} = {2}")
    @MethodSource("expressionProvider")
    fun givenExpressionAndInterpreter_whenInterpretExpression_thenReturnExpressionVaue(
            @Suppress("UNUSED_PARAMETER") expressionText: String,
            expression: Expression,
            expectedValue: Int
    ) {
        // Given & When
        // interpret an expression recursively to get the final expression value
        val value = interpreter.interpret(expression)
        // Then
        assertThat(value).isEqualTo(expectedValue)
    }

    fun expressionProvider(): Stream<Arguments> = Stream.of(
            Arguments.of("1", Constant(1), 1),
            Arguments.of("1+2", Add(Constant(1), Constant(2)), 3),
            Arguments.of("1+2*3", Add(Constant(1), Mul(Constant(2), Constant(3))), 7)
    )
}
