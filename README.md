# [Kotlin](https://kotlinlang.org/) Software Design Patterns Code Examples

## Creational Patterns

Creational patterns **encapsulate knowledge about concrete classes** the system use, **hide how instances of these
classes are created** and **separate the system from how the objects are composed and represented**.

- [**Abstract Factory**](src/main/kotlin/org/vld/sdp/creational/AbstractFactory.kt)
[(usage)](src/test/kotlin/org/vld/sdp/creational/AbstractFactoryTest.kt) provides an interface for creating *families of
related or dependent objects* without specifying their concrete classes. Client works only with *interfaces* of the
abstract factory and family products. Concrete factories are *singletons* that implement abstract factory interface

- [**Builder**](src/main/kotlin/org/vld/sdp/creational/Builder.kt)
[(usage)](src/test/kotlin/org/vld/sdp/creational/BuilderTest.kt) separates a construction of a complex object from its
representation, allowing the same construction process to create various representations. Client uses **(a)** separate
*builder object* which receives each initialization parameter step by step in a fluent interface or **(b)** *builder DSL
initialization method* which configures properties by direct property assignment or function call and returns the
resulting constructed complex object at once

- Dependency Injection

- [**Factory Method**](src/main/kotlin/org/vld/sdp/creational/FactoryMethod.kt)
[(usage)](src/test/kotlin/org/vld/sdp/creational/FactoryMethodTest.kt) defines an interface for creating a *single
object*, but let subclasses decide which class to instantiate. Client works only with *interfaces* of the factory method
and a single product interface. Concrete factories are *singletons* that implement factory method interface

- Lazy Initialization

- Multiton

- Object Pool

- [**Prototype**](src/main/kotlin/org/vld/sdp/creational/Prototype.kt)
[(usage)](src/test/kotlin/org/vld/sdp/creational/PrototypeTest.kt) creates new objects *cloning prototypical instance*,
boosting performance and keeping memory footprint to a minimum. Client works only with *interfaces* of the prototype and
product interface

- Resource Acquisition is Initialization

- [**Singleton**](src/main/kotlin/org/vld/sdp/creational/Singleton.kt)
[(usage)](src/test/kotlin/org/vld/sdp/creational/SingletonTest.kt) ensures that a class has *only one instance* and
provides a *global point of access* to it. Make the class constructor private and provide one public static method that
always returns the same single instance of the class stored in a private static variable

## Structural Patterns

Structural patterns provide simple way of implementing **relationships between objects**.

- [**Adapter**](src/main/kotlin/org/vld/sdp/structural/Adapter.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/AdapterTest.kt) converts the interface of a class without modifying its
code into another interface that client expects. Client works with the class through *adapter interface* and delegation
to the class methods

- [**Bridge**](src/main/kotlin/org/vld/sdp/structural/Bridge.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/BridgeTest.kt) decouples an abstraction from its implementation (*two
orthogonal dimensions*) allowing the two to vary independently. The abstraction and its implementation are defined and
extended independently. The abstraction is implemented by delegating to the implementation

- [**Composite**](src/main/kotlin/org/vld/sdp/structural/Composite.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/CompositeTest.kt) treats individual objects and composition of objects
uniformly. Composes objects into *tree structures* to represent part-whole hierarchies. `Leaf` and `Composite` classes
implement `Component` interface. `Leaf` class implements the request directly. `Composite` forwards recursively the
request to its children

- **Decorator**

- **Facade**

- **Flyweight**

- **Front Controller**

- **Proxy**

## Behavioral Patterns
