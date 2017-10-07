package org.vld.sdp.behavioral

/**
 * Expression interface is an abstract sealed class
 */
sealed class Expression

/**
 * Terminal Expression interface implementation. Constant value
 */
class Constant(val value: Int) : Expression()

/**
 * Nonterminal Expression interface implementation. Addition operation
 */
class Add(val left: Expression, val right: Expression) : Expression()

/**
 * Nonterminal Expression interface implementation. Multiplication operation
 */
class Mul(val left: Expression, val right: Expression) : Expression()

/**
 * Expression Interpreter implementation
 */
class Interpreter {
    /**
     * Interprets [extension] and returns [expression] value
     */
    fun interpret(expression: Expression): Int = when (expression) {
        // recursively interpret the left and the right expressions of the nonterminal expression
        // and then apply the multiplication operation
        is Mul -> interpret(expression.left) * interpret(expression.right)
        // recursively interpret the left and the right expressions of the nonterminal expression
        // and then apply the addition operation
        is Add -> interpret(expression.left) + interpret(expression.right)
        // directly interpret the value of the terminal expression
        is Constant -> expression.value
    }
}
