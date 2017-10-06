package org.vld.sdp.behavioral

/**
 * Command interface order a dish
 */
typealias Order = () -> String

/**
 * Command interface implementation and Receiver/Implementor. Command stores the request arguments (name) in a closure
 */
fun cookStarter(name: String): Order = { "$name Starter" }

fun cookMainCourse(name: String): Order = { "$name Main Course" }

fun cookDessert(name: String): Order = { "$name Dessert" }

/**
 * Invoker implementation keeps the list of pending orders
 */
class Waiter(private val pendingOrders: MutableList<Order> = mutableListOf()) {
    /**
     * Accepts [orders] and queues the orders for execution
     */
    fun acceptOrder(vararg orders: Order) = pendingOrders.addAll(orders)

    /**
     * Serves orders by executing the orders through the Command interface
     */
    fun serveOrders(): List<String> = pendingOrders.map { it() }
}
