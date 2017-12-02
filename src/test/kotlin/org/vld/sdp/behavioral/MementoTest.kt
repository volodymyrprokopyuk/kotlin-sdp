package org.vld.sdp.behavioral

import org.assertj.core.api.Assertions.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MementoTest {

    @Test
    @DisplayName("Given a counter. When increment the counter tree times without memento. Then return counter value incremented by three")
    fun givenCounter_whenIncrementCounterThreeTimesWithoutMemento_thenReturnCounterValueIncrementedByTree() {
        // Given
        val counter = Counter()
        // When
        // increment the counter three times without Memento
        counter.increment()
        counter.increment()
        counter.increment()
        // the counter values is incremented by tree
        val value = counter.value
        // Then
        val expectedValue = 3
        assertThat(value).isEqualTo(expectedValue)
    }

    @Test
    @DisplayName("Given a counter. When increment the counter tree times with memento in between. Then return counter value incremented by two")
    fun givenCounter_whenIncrementCounterThreeTimesWithMemento_thenReturnCounterValueIncrementedByTwo() {
        // Given
        val counter = Counter()
        // When
        // increment the counter three times
        counter.increment()
        // snapshot the counter state to a Memento in between
        val memento = counter.memento
        counter.increment()
        // restore the counter state from the Memento
        counter.memento = memento
        counter.increment()
        // the counter values is incremented by two not three
        val value = counter.value
        // Then
        val expectedValue = 2
        assertThat(value).isEqualTo(expectedValue)
    }
}
