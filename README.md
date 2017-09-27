# [Kotlin](https://kotlinlang.org/) Software Design Patterns Code Examples

## Creational Patterns

Creational patterns **encapsulate knowledge about concrete classes** the system use, **hide how instances of these
classes are created** and **separate the system from how the objects are composed and represented**.

- [Abstract Factory](src/main/kotlin/org/vld/sdp/creational/AbstractFactory.kt) provides an interface for creating
*families of related or dependent objects* without specifying their concrete classes. Client works only with
*interfaces* of the abstract factory and family products. Concrete factories are *singletons* that implement abstract
factory interface
- [Builder](src/main/kotlin/org/vld/sdp/creational/Builder.kt) separates a construction of a complex object from its
representation, allowing the same construction process to create various representations. Client uses **(a)** separate
*builder object* which receives each initialization parameter step by step in a fluent interface or **(b)** *builder DSL
initialization method* which configures properties by direct property assignment or function call and returns the
resulting constructed complex object at once
- Dependency Injection
- [Factory Method](src/main/kotlin/org/vld/sdp/creational/FactoryMethod.kt) defines an interface for creating a *single
object*, but let subclasses decide which class to instantiate. Client works only with *interfaces* of the factory method
and a single product interface. Concrete factories are *singletons* that implement factory method interface
- Lazy Initialization
- Multiton
- Object Pool
- Prototype
- Resource Acquisition is Initialization
- [Singleton](src/main/kotlin/org/vld/sdp/creational/Singleton.kt) ensures that a class has *only one instance* and
provides a *global point of access* to it. Make the class constructor private and provide one public static method that
always returns the same single instance of the class stored in a private static variable

## Structural Patterns

## Behavioral Patterns
