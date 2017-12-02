package org.vld.sdp.structural

import org.assertj.core.api.Assertions.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProxyTest {

    @Test
    @DisplayName("Given an account with enough balance. When pay amount. Then satisfy the payment")
    fun givenAccountWithEnoughBalance_whenPayAmount_thenSatisfyThePayment() {
        // Given
        val account = Account(100.0)
        val paymentProxy: Payment = PaymentProxy(account)
        // When & Then
        // client works with the Proxy only through the Payment interface
        assertThatCode { paymentProxy.pay(50.0) }.doesNotThrowAnyException()
    }

    @Test
    @DisplayName("Given an account with not enough balance. When pay amount. Then throw IllegalArgumentException")
    fun givenAccountWithNotEnoughBalance_whenPayAmount_thenThrowIllegalArgumentException() {
        // Given
        val account = Account(100.0)
        val paymentProxy: Payment = PaymentProxy(account)
        // When & Then
        // client works with the Proxy only through the Payment interface
        assertThatThrownBy { paymentProxy.pay(200.0) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageStartingWith("Not enough balance to satisfy the payment amount")
    }
}
