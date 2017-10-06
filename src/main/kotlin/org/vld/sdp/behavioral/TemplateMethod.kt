package org.vld.sdp.behavioral

/**
 * Template abstract class defines the skeleton/structure of the algorithm
 */
abstract class Employee {
    // invariant step of the algorithm is defined in the abstract class final method
    fun getUp(): String = "Employee gets up"

    // variable step of the algorithm is defined in the abstract method and is open for overriding
    abstract fun work(): String

    // invariant step of the algorithm is defined in the abstract class final method
    fun sleep(): String = "Employee sleeps"

    // the overall algorithm structure is defined in one operation in the abstract class final method
    fun act(): List<String> = listOf(getUp(), work(), sleep())
}

/**
 * Abstract Template specialization
 */
class Developer : Employee() {
    // redefine the variable step of the algorithm
    override fun work(): String = "Developer programs"
}

/**
 * Abstract Template specialization
 */
class Architect : Employee() {
    // redefine the variable step of the algorithm
    override fun work(): String = "Architect designs"
}
