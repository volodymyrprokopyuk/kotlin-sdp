package org.vld.sdp.behavioral

/**
 * Definition of the skeleton/structure of the algorithm
 */
abstract class Employee {
    // invariant step of the algorithm is defined in the abstract class final method
    fun getUp(): String = "Employee gets up"

    // variable step of the algorithm is defined in the abstract method and is open for overwriting
    abstract fun work(): String

    fun sleep(): String = "Employee sleeps"

    fun act(): List<String> = listOf(getUp(), work(), sleep())
}

/**
 * Concrete algorith implementation
 */
class Developer : Employee() {
    // redefine the variable step of the algorithm
    override fun work(): String = "Developer programs"
}

/**
 * Concrete algorith implementation
 */
class Architect : Employee() {
    // redefine the variable step of the algorithm
    override fun work(): String = "Architect designs"
}
