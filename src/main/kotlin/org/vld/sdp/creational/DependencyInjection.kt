package org.vld.sdp.creational

/**
 * Service interface that [Client] depends on
 */
interface Service {
    val name: String
}

/**
 * Service interface implementation for the Constructor Injection
 */
class ConstructorInjectedService(override val name: String = "Constructor Injected Service") : Service

/**
 * Service interface implementation fo the Setter Injection
 */
class SetterInjectedService(override val name: String = "Setter Injected Service") : Service

/**
 * Client depends on the [constructorInjectedService] and on the [setterInjectedService]
 *
 * Client only dependes on the [Service] interface
 */
class Client(val constructorInjectedService: Service) {
    lateinit var setterInjectedService: Service
}

/**
 * Injector implements the Dependency Injection via the Constructor Injection and Setter Injection
 */
class Injector {
    /**
     * Creates the [Client] with all its dependent services set up
     */
    fun createClient(): Client {
        // creat the services the client depends on
        val constructorInjectedService: Service = ConstructorInjectedService()
        val setterInjectedService: Service = SetterInjectedService()
        // create the client and provide the dependent service via the constructor injection
        val client = Client(constructorInjectedService)
        // set the client dependent service via the setter injection
        client.setterInjectedService = setterInjectedService
        // return the clien with all its dependencies set up
        return client
    }
}
