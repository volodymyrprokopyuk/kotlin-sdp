package org.vld.sdp.behavioral

/**
 * Vending Machine State interface
 */
interface State {
    fun handleRequest(): List<String>
}

/**
 * Vending Machine implementation
 */
class VendingMachine {

    // set the initial Vending Machine state to the Show Products step
    var state: State = ShowProducts(this, listOf())

    /**
     * Handles the request as per the current state and set the next Vending Machine state
     */
    fun proceed(): List<String> = state.handleRequest()
}

/**
 * Show Products step implementation
 */
class ShowProducts(private val vendingMachine: VendingMachine, private val request: List<String>) : State {
    override fun handleRequest(): List<String> {
        // handle the request
        val result = request + "Show Products"
        // set the next Vending Machine step
        vendingMachine.state = SelectProduct(vendingMachine, result)
        return result
    }
}

/**
 * Select Product step implementation
 */
class SelectProduct(private val vendingMachine: VendingMachine, private val request: List<String>) : State {
    override fun handleRequest(): List<String> {
        // handle the request
        val result = request + "Select Product"
        // set the next Vending Machine step
        vendingMachine.state = DepositMoney(vendingMachine, result)
        return result
    }
}

/**
 * Deposit Money step implementation
 */
class DepositMoney(private val vendingMachine: VendingMachine, private val request: List<String>) : State {
    override fun handleRequest(): List<String> {
        // handle the request
        val result = request + "Deposit Money"
        // set the next Vending Machine step
        vendingMachine.state = DeliverProduct(vendingMachine, result)
        return result
    }
}

/**
 * Deliver Product step implementation
 */
class DeliverProduct(private val vendingMachine: VendingMachine, private val request: List<String>) : State {
    override fun handleRequest(): List<String> {
        // handle the request
        val result = request + "Deliver Product"
        // set the next Vending Machine step
        vendingMachine.state = ShowProducts(vendingMachine, result)
        return result
    }
}
