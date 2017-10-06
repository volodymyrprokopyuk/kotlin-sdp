package org.vld.sdp.structural

/**
 * Payment Subject interface to be implemented by the real object [Account] and the proxy [PaymentProxy]
 */
interface Payment {
    fun pay(amount: Double)
}

/**
 * Account real Subject interface implementation
 */
class Account(var balance: Double) : Payment {
    /**
     * Subtracts the amount directly from the balance without any balance/amount validation
     */
    override fun pay(amount: Double) {
        balance -= amount
    }
}

/**
 * Payment Subject interface Proxy implementation
 */
class PaymentProxy(private val account: Account) : Payment {
    /**
     * Checks the account balance and delegates the [Payment] operation to the [Account] real object
     * if the balance can satisfy the payment [amount] otherwise throws IllegalArgumentException
     */
    override fun pay(amount: Double) {
        if (account.balance < amount)
            throw IllegalArgumentException("Not enough balance to satisfy the payment amount: $amount")
        else account.pay(amount)
    }
}
