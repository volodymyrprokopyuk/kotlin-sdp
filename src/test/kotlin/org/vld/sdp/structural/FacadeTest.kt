package org.vld.sdp.structural

import org.assertj.core.api.Assertions.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FacadeTest {

    @Test
    @DisplayName("Given a computer facade. When switch on the computer. Then orchestarte and manage the computer subsystems")
    fun givenComputerFacade_whenSwitchOnComputer_thenOrchestrateAndManagerComputerSubsystems() {
        // Given
        val computer: Computer = Desktop(Cpu(), Ram(), Ssd())
        // When
        // client works only with Computer higher-level, simplified Facade interface
        val result = computer.switchOn()
        // Then
        val expectedResult = "CPU started, RAM loaded, SSD read"
        assertThat(result).isEqualTo(expectedResult)
    }
}
