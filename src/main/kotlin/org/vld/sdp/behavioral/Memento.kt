package org.vld.sdp.behavioral

/**
 * Memento type
 */
typealias CounterMemento = Int

/**
 * Originator implementation
 */
class Counter(private var count: Int = 0) {
    fun increment(): Int = ++count
    fun decrement(): Int = --count
    val value: Int get() = count
    var memento: CounterMemento
        get() = count
        set(newCount) {
            count = newCount
        }
}
