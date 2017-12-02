package org.vld.sdp.behavioral

import org.assertj.core.api.Assertions.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StrategyTest {

    val transportCompany = TransportCompany()

    @DisplayName("Given a transport company and a group of tourists. When request a transport. Then return an appropriate transport based on the size of the tourist group")
    @ParameterizedTest(name = "{0} tourists -> {1}")
    @MethodSource("transportProvider")
    fun givenTransportCompanyAndGoupOfTourists_whenRequestTransport_thenReturnAppropriateTransport(
            groupSize: Int,
            expectedTransport: String
    ) {
        // Given & When
        // dynamically select the appropriate transport (strategy) based on the size of the tourist gourp
        val transport = transportCompany.requestTransport(groupSize)()
        // Then
        assertThat(transport).isEqualTo(expectedTransport)
    }

    fun transportProvider(): Stream<Arguments> = Stream.of(
            Arguments.of(4, "Go by Taxi"),
            Arguments.of(14, "Go by Bus")
    )
}
