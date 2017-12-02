package org.vld.sdp.behavioral

import org.assertj.core.api.Assertions.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VisitorTest {

    val xiaomi = XiaomiPhone()
    val nokia = NokiaPhone()

    @DisplayName("Given a set of phones. When switch on WiFi from a provider. Then perform the right action")
    @ParameterizedTest(name = "{1}. {2}")
    @MethodSource("wifiProvider")
    fun givenSetOfPhones_whenSwitchOnWiFiFromProvider_thenPerformRightAction(
            wiFi: WiFi,
            expectedXiaomiAction: String,
            expectedNokiaAction: String
    ) {
        // Given & When
        val xiaomiAction = xiaomi.switchOnWiFi(wiFi)
        val nokiaAction = nokia.switchOnWiFi(wiFi)
        // Then
        assertThat(xiaomiAction).isEqualTo(expectedXiaomiAction)
        assertThat(nokiaAction).isEqualTo(expectedNokiaAction)
    }

    fun wifiProvider(): Stream<Arguments> = Stream.of(
            Arguments.of(IntelWiFi(), "Switch on Intel WiFi on Xiaomi Phone", "Switch on Intel WiFi on Nokia Phone"),
            Arguments.of(BroadcomWiFi(), "Switch on Broadcom WiFi on Xiaomi Phone", "Switch on Broadcom WiFi on Nokia Phone")
    )

    @DisplayName("Given a set of phones. When take photo with a camera from a provider. Then perform the right action")
    @ParameterizedTest(name = "{1}. {2}")
    @MethodSource("cameraProvider")
    fun givenSetOfPhones_whenTakePhotoWithCameraFromProvider_thenPerformRightAction(
            camera: Camera,
            expectedXiaomiAction: String,
            expectedNokiaAction: String
    ) {
        // Given & When
        val xiaomiAction = xiaomi.takePhoto(camera)
        val nokiaAction = nokia.takePhoto(camera)
        // Then
        assertThat(xiaomiAction).isEqualTo(expectedXiaomiAction)
        assertThat(nokiaAction).isEqualTo(expectedNokiaAction)
    }

    fun cameraProvider(): Stream<Arguments> = Stream.of(
            Arguments.of(SonyCamera(), "Take photo with Sony Camera on Xiaomi Phone", "Take photo with Sony Camera on Nokia Phone"),
            Arguments.of(SamsungCamera(), "Take photo with Samsung Camera on Xiaomi Phone", "Take photo with Samsung Camera on Nokia Phone")
    )
}
