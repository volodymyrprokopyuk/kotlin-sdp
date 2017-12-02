package org.vld.sdp.behavioral

import org.assertj.core.api.Assertions.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CommandTest {

    @Test
    @DisplayName("Given a set of dishes and a waiter. When order dishes. Then serve ordered dishes")
    fun givenSetOfDishesAndWaiter_whenOrderDishes_thenServeOrderedDishes() {
        // Given
        // create and configure orders as Command objects. The request arguments (name) are stored in a closure
        val starter: Order = cookStarter("Salad")
        val mainCourse: Order = cookMainCourse("Chicken")
        val dessert: Order = cookDessert("Fruit")
        val waiter = Waiter()
        // When
        // queue the orders for execution, waiter provides order queueing functionality
        waiter.acceptOrder(starter, mainCourse, dessert)
        // execute orders using the Command interface without knowing the concrete Receivers/Implementors
        val dishes = waiter.serveOrders()
        // Then
        val expectedDishes = listOf("Salad Starter", "Chicken Main Course", "Fruit Dessert")
        assertThat(dishes).isEqualTo(expectedDishes)
    }
}
