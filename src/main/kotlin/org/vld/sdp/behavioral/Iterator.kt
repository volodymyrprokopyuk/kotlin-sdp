package org.vld.sdp.behavioral

/**
 * Component type
 */
typealias Fruit = String

/**
 * Aggregate object/container of components implementation
 */
class Fruits(vararg val fruits: Fruit)

/**
 * Aggregate object/container of components [Iterator] implementation
 */
class FruitsIterator(private val container: Fruits) : Iterator<Fruit> {
    // reuse fruits iterator
    private val iterator = container.fruits.iterator()
    // delegate to iterator
    override fun hasNext(): Boolean = iterator.hasNext()
    override fun next(): Fruit = iterator.next()
}

/**
 * `iterator()` extension function on the [Fruits] type allows the [Fruits] aggregate
 * be used in the `for(fruit in fruits)` loop
 */
operator fun Fruits.iterator() = FruitsIterator(this)
