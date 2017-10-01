package org.vld.sdp.behavioral

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StateTest {

    @Test
    @DisplayName("Given a vending machine. When proceed with the steps. Then handle the request in each step")
    fun givenVendingMachine_whenProceedWithSteps_thenHandleRequestInEachStep() {
        // Given
        val vendingMachine = VendingMachine()
        // When
        // proceed with each step of the vending machine
        vendingMachine.proceed() // execute show products step
        vendingMachine.proceed() // execute select product step
        vendingMachine.proceed() // execute deposit money step
        // collect the overall result of all the steps
        val result = vendingMachine.proceed() // execute deliver product step
        // Then
        val expectedResult = listOf("Show Products", "Select Product", "Deposit Money", "Deliver Product")
        assertThat(result).isEqualTo(expectedResult)
    }

}
