package org.vld.sdp.behavioral

/**
 * Vending machine state interface
 */
interface State {
    fun handleRequest(): List<String>
}

/**
 * Vending machine implementation
 */
class VendingMachine(var state: State? = null) {

    init {
        // set the initial vending machine state to show products step
        state = ShowProducts(this, listOf())
    }

    /**
     * Handles the request as per the current state
     */
    fun proceed(): List<String> = state?.handleRequest() ?: listOf()

}

/**
 * Show products step implementation
 */
class ShowProducts(val vendingMachine: VendingMachine, val request: List<String>) : State {
    override fun handleRequest(): List<String> {
        // handle the request
        val result = request + "Show Products"
        // set the next step on the vending machine state
        vendingMachine.state = SelectProduct(vendingMachine, result)
        return result
    }
}

/**
 * Select product step implementation
 */
class SelectProduct(val vendingMachine: VendingMachine, val request: List<String>) : State {
    override fun handleRequest(): List<String> {
        // handle the request
        val result = request + "Select Product"
        // set the next step on the vending machine state
        vendingMachine.state = DepositMoney(vendingMachine, result)
        return result
    }
}

/**
 * Deposit money step implementation
 */
class DepositMoney(val vendingMachine: VendingMachine, val request: List<String>) : State {
    override fun handleRequest(): List<String> {
        // handle the request
        val result = request + "Deposit Money"
        // set the next step on the vending machine state
        vendingMachine.state = DeliverProduct(vendingMachine, result)
        return result
    }
}

/**
 * Deliver product step implementation
 */
class DeliverProduct(val vendingMachine: VendingMachine, val request: List<String>) : State {
    override fun handleRequest(): List<String> {
        // handle the request
        val result = request + "Deliver Product"
        // set the next step on the vending machine state (set again the show products step)
        vendingMachine.state = ShowProducts(vendingMachine, result)
        return result
    }
}
