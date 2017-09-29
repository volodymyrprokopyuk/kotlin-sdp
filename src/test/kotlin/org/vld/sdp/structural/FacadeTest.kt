package org.vld.sdp.structural

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FacadeTest {

    @Test
    @DisplayName("Given a computer facade. When switch on computer. Then orchestarte and manage computer subsystems")
    fun givenComputerFacade_whenSwitchOnComputer_thenOrchestrateAndManagerComputerSubsystems() {
        // Given
        val computer: Computer = Desktop(Cpu(), Ram(), Ssd())
        // When
        // client works only with Computer facade interface
        val result = computer.switchOn()
        // Then
        val expectedResult = "CPU started, RAM loaded, SSD read"
        assertThat(result).isEqualTo(expectedResult)
    }

}
