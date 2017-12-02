package org.vld.sdp.structural

import org.assertj.core.api.Assertions.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BridgeTest {

    @DisplayName("Given a device and a vendor. When switch on the device of the vendor. Then the vendor supports the device")
    @ParameterizedTest(name = "{1}")
    @MethodSource("deviceVendorProvider")
    fun givenDeviceAndVendor_whenSwitchOnVendorDevice_thenVendorSupportsDevice(
            device: Device,
            expectedSupport: String
    ) {
        // Given & When
        // Abstractions: Phone and Tablet devices. Implementations: Xiaomi and Nokia vendors
        // client only uses the Device Abstraction interface
        val support = device.switchOn()
        // Then
        assertThat(support).isEqualTo(expectedSupport)
    }

    fun deviceVendorProvider(): Stream<Arguments> {
        // Implementations
        val xiaomi: Vendor = XiaomiVendor()
        val nokia: Vendor = NokiaVendor()
        // instantiate Abstractions (Phone and Tablet devices) by providing Implementations (Xiaomi and Nokia vendors)
        return Stream.of(
                Arguments.of(PhoneDevice(xiaomi), "Xiaomi supports Phone"),
                Arguments.of(PhoneDevice(nokia), "Nokia supports Phone"),
                Arguments.of(TabletDevice(xiaomi), "Xiaomi supports Tablet"),
                Arguments.of(TabletDevice(nokia), "Nokia supports Tablet")
        )
    }
}
