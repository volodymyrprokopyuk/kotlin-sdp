package org.vld.sdp.creational

import org.assertj.core.api.Assertions.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SingletonTest {

    @Test
    @DisplayName("Given a singleton. When access the singleton. Then return the same singleton object")
    fun givenSingleton_whenAccessSingleton_thenReturnTheSameSingletonObject() {
        // Given & When
        // the global point of access to the singleton instance is the name of the instance class
        val singleton = Singleton
        // Then
        val expectedSingleton = Singleton
        assertThat(singleton).isSameAs(expectedSingleton)
    }
}
