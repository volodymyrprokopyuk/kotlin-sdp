package org.vld.sdp.behavioral

/**
 * Memento type to store to/retrieve from the Originator's state
 */
typealias CounterMemento = Int

/**
 * Originator implementation
 */
class Counter(private var count: Int = 0) {
    /**
     * Retrieves the [value] (read-only property) of the [Counter] [count] private property
     */
    val value: Int get() = count

    /**
     * Increments the private [count] property
     */
    fun increment(): Int = ++count

    /**
     * Stores the [Counter] internal state ([count] private property) to the [CounterMemento]
     * Restores the [Counter] internal state ([count] private property) from the [CounterMemento]
     */
    var memento: CounterMemento
        get() = count
        set(newCount) {
            count = newCount
        }
}
