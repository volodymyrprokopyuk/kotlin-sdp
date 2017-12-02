package org.vld.sdp.creational

import org.assertj.core.api.Assertions.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BuilderTest {

    // builder DSL
    val expectedCar: Car = Car.build {
        // direct assignment to variable Car Builder properties
        make = "BMW"
        model = "X5"
        year = 2017
    }

    @Test
    @DisplayName("Given a car builder. When build a car. Then return a car instance")
    fun givenCarBuilder_whenBuildCar_thenReturnCarInstance() {
        // Given & When
        // builder DSL
        val car = Car.build {
            // call Car Builder functions to initialize variable Car Builder properties
            make { "BMW" }
            model { "X5" }
            year { 2017 }
        }
        // Then
        assertThat(car).isEqualTo(expectedCar)
    }
}
