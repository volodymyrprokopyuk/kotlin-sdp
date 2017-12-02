package org.vld.sdp.creational

import org.assertj.core.api.Assertions.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DependencyInjectionTest {

    @Test
    @DisplayName("Given a client, services it depends on and an injector. When create client. Then return client with its dependent services")
    fun givenClientSerivcesAndInjector_whenCreateClient_thenReturnClientWithDependentServices() {
        // Given
        val injector = Injector()
        // When
        val client = injector.createClient()
        // Then
        assertThat(client.constructorInjectedService.name).isEqualTo("Constructor Injected Service")
        assertThat(client.setterInjectedService.name).isEqualTo("Setter Injected Service")
    }
}
