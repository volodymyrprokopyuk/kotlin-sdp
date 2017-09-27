# [Kotlin](https://kotlinlang.org/) Software Design Patterns Code Examples

## Creational Patterns

Creational patterns **encapsulate knowledge about concrete classes** the system use, **hide how instances of these classes 
are created** and **separate the system from how the objects are composed and represented**.

- **Abstract Factory** provides an interface for creating families of related or dependent objects without specifying
their concrete classes. Client code works only with *interfaces* of abstract factory and family products. Concrete
factories are *singletons* that implement abstract factory interface
- **Builder** separates a construction of a complex object from its representation, allowing the same construction
process to create various representations. Client uses **(a)** separate *builder object* which receives each
initialization parameter step by step in a fluent interface or **(b)** *builder DSL initialization method* which
configures properties by direct property assignment or function call and returns the resulting constructed complex
object at once
- Dependency Injection
- Factory Method
- Lazy Initialization
- Multiton
- Object Pool
- Prototype
- Resource Acquisition is Initialization
- Singleton

## Structural Patterns

## Behavioral Patterns
