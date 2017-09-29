package org.vld.sdp.structural

/**
 * Component interface
 */
interface Coffee {
    fun taste(): String
}

/**
 * Component implementation
 */
class SimpleCoffee : Coffee {
    // implement basic behavior
    override fun taste() = "Coffee"
}

/**
 * Component decorator
 */
class CoffeeWithSugar(private val coffee: Coffee) : Coffee {
    // provide additional behavior
    override fun taste(): String = "Sweet ${coffee.taste()} with Sugar"
}

/**
 * Component decorator
 */
class CoffeeWithMilk(private val coffee: Coffee) : Coffee {
    // provide additional behavior
    override fun taste(): String = "Tasty ${coffee.taste()} with Milk"
}
