package org.vld.sdp.behavioral

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.Mockito.* // ktlint-disable no-wildcard-imports

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MediatorTest {

    @Test
    @DisplayName("Given a control tower, an airplane and a helicopter. When the airplane sends a message to the helicopter. Then the helicopter receives the message")
    fun givenControlTowerAirplaneAndHelicopter_whenAirplaneSendsMessageToHelicopter_thenHelicopterReceivesMessage() {
        // Given
        val controlTower = AirControlTower()
        val airplane: Aircraft = Airplane(controlTower)
        val mockedHelicopter: Aircraft = mock(Helicopter::class.java)
        controlTower.airplane = airplane
        controlTower.helicopter = mockedHelicopter
        // When
        // the airplane sends a message to the helicopter through the control tower mediator
        // without haveing any reference to the helicopter
        airplane.send("Hi from Airplane")
        // Then
        // the helicopter receives the message sent from the airplane throuth the control tower mediator
        // without haveing any reference to the airplane
        verify(mockedHelicopter).receive("Hi from Airplane")
    }

    @Test
    @DisplayName("Given a control tower, an airplane and a helicopter. When the helicopter sends a message to the airplane. Then the airplane receives the message")
    fun givenControlTowerAirplaneAndHelicopter_whenHelicopterSendsMessageToAirplane_thenAirplaneReceivesMessage() {
        // Given
        val controlTower = AirControlTower()
        val mockedAirplane: Aircraft = mock(Airplane::class.java)
        val helicopter: Aircraft = Helicopter(controlTower)
        controlTower.airplane = mockedAirplane
        controlTower.helicopter = helicopter
        // When
        // the helicopter sends a message to the airplane through the control tower mediator
        // without haveing any reference to the airplane
        helicopter.send("Hi from Helicopter")
        // Then
        // the airplane receives the message sent from the helicopter throuth the control tower mediator
        // without haveing any reference to the helicopter
        verify(mockedAirplane).receive("Hi from Helicopter")
    }
}
