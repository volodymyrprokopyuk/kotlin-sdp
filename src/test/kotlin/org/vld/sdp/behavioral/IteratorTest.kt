package org.vld.sdp.behavioral

import org.assertj.core.api.Assertions.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IteratorTest {

    @Test
    @DisplayName("Given an aggregate with an iterator. When traverse the aggregate in the for loop. Then return the aggregate component values")
    fun givenAggregateWithIterator_whenTraverseAggregateInForLoop_thenReturnAggregateComponentValues() {
        // Given
        val fruits = Fruits("apple", "banana", "orange")
        // When
        val values: MutableList<Fruit> = mutableListOf()
        // by providing iterator extension function, Fruits can be used in the for loop
        for (fruit in fruits) values.add(fruit)
        // Then
        val expectedValues = listOf<Fruit>("apple", "banana", "orange")
        assertThat(values).isEqualTo(expectedValues)
    }
}
