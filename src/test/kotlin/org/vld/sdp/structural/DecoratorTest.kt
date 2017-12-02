package org.vld.sdp.structural

import org.assertj.core.api.Assertions.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DecoratorTest {

    @DisplayName("Given an decorated coffee object. When taste coffee. Then return decorated coffee taste")
    @ParameterizedTest(name = "{1}")
    @MethodSource("coffeeProvider")
    fun givenDecoratedCoffee_whenTasteCoffee_thenReturnDecoratedCoffeeTaste(coffee: Coffee, expectedTaste: String) {
        // Given & When
        // client works only with the Coffee interface for both simple coffee and decorated coffee instances
        val taste = coffee.taste()
        // Then
        assertThat(taste).isEqualTo(expectedTaste)
    }

    fun coffeeProvider(): Stream<Arguments> = Stream.of(
            // basic Coffee interface implementation
            Arguments.of(SimpleCoffee(), "Coffee"),
            // decorated Coffee is compliant with the Coffee interface
            Arguments.of(CoffeeWithSugar(SimpleCoffee()), "Sweet Coffee with Sugar"),
            // decorators can be stacked on top of each other each time adding new behavior
            Arguments.of(CoffeeWithMilk(CoffeeWithSugar(SimpleCoffee())), "Tasty Sweet Coffee with Sugar with Milk")
    )
}
