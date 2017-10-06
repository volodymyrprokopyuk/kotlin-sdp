package org.vld.sdp.behavioral

/**
 * Component type
 */
typealias Fruit = String

/**
 * Aggregate Object/Container of Components implementation
 */
class Fruits(vararg val fruits: Fruit)

/**
 * Aggregate Object/Container of Components [Iterator] interface implementation
 */
class FruitsIterator(container: Fruits) : Iterator<Fruit> {
    // reuse the Fruits iterator
    private val iterator = container.fruits.iterator()
    // delegate to the Fruits iterator
    override fun hasNext(): Boolean = iterator.hasNext()
    override fun next(): Fruit = iterator.next()
}

/**
 * The `Fruits::iterator()` extension function allows the [Fruits] Aggregate Object/Container of Components
 * to be used in the `for (fruit in fruits) { ... }` loop
 */
operator fun Fruits.iterator(): Iterator<Fruit> = FruitsIterator(this)
