package org.vld.sdp.structural

/**
 * Component interface
 */
interface Expression {
    fun evaluate(): Int
}

/**
 * Leaf implements Component interface directly
 */
class Operand(val value: Int) : Expression {
    override fun evaluate(): Int = value
}

/**
 * Composite implements Component interface recursively
 */
class Operation(val left: Expression, val right: Expression, val operate: (Int, Int) -> Int) : Expression {
    // recursively evaluate left and right expressions, than apply the operation
    override fun evaluate(): Int = operate(left.evaluate(), right.evaluate())
}
