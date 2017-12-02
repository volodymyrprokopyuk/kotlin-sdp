package org.vld.sdp.structural

import org.mockito.Mockito.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AdapterTest {

    @Test
    @DisplayName("Given a Xiaomi phone and Xiaomi phone adapter. When switch on phone. Then the Xiaomi phone is turned on")
    fun givenXiaomiPhoneAndXiaomiPhoneAdapter_whenSwitchOnPhone_thenTurnOnXiaomiPhone() {
        // Given
        val mockedXiaomiPhone: XiaomiPhone = mock(XiaomiPhone::class.java)
        val phone: Phone = XiaomiPhoneAdapter(mockedXiaomiPhone)
        // When
        // client works with the Xiaomi Phone through the Xiaomi Phone Adapter implementation
        // of the Phone interface that client expects
        phone.switchOn()
        // Then
        // `XiaomiPhone::turnOn()` method is called
        verify(mockedXiaomiPhone).turnOn()
    }
}
