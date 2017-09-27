package org.vld.sdp.creational

/**
 * Car with a private constructor. Car instances must be built through a `Car.build()` builder method
 */
data class Car private constructor(val make: String, val model: String, val year: Int) {

    /**
     * Car private constructor to be used from `Car.build()` builder method
     */
    private constructor(builder: Builder): this(builder.make, builder.model, builder.year)

    companion object {
        /**
         * Builds a Car Builder instance as defined in the [init] method and then builds a Car instance
         * using private Car's constructor and based on the initialized in the [init] method Car Builder properties
         */
        fun build(init: Builder.() -> Unit): Car = Builder(init).build()
    }

    /**
     * Car Builder with private constructor
     */
    class Builder private constructor() {

        /**
         * Car Builder constructor for applying initialization logic to the Car Builder instance
         */
        constructor(init: Builder.() -> Unit): this() {
            init()
        }

        // variable Car Builder properties to be initialized in the init method
        var make: String = ""
        var model: String = ""
        var year: Int = 0

        fun make(init: Builder.() -> String) = apply { make = init() }

        fun model(init: Builder.() -> String) = apply { model = init() }

        fun year(init: Builder.() -> Int) = apply { year = init() }

        /**
         * Calls private Car's constructor by passing the Car Builder instance
         * with initialized properties for Car initialization
         */
        fun build(): Car = Car(this)

    }

}
