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

- **Dependency Injection**

- [**Factory Method**](src/main/kotlin/org/vld/sdp/creational/FactoryMethod.kt)
[(usage)](src/test/kotlin/org/vld/sdp/creational/FactoryMethodTest.kt) defines an interface for creating a *single
object*, but let subclasses decide which class to instantiate. Client works only with *interfaces* of the factory method
and a single product interface. Concrete factories are *singletons* that implement factory method interface

- **Lazy Initialization**

- **Multiton**

- **Object Pool**

- [**Prototype**](src/main/kotlin/org/vld/sdp/creational/Prototype.kt)
[(usage)](src/test/kotlin/org/vld/sdp/creational/PrototypeTest.kt) creates new objects *cloning prototypical instance*,
boosting performance and keeping memory footprint to a minimum. Client works only with *interfaces* of the prototype and
product interface

- **Resource Acquisition is Initialization**

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

- [**Decorator**](src/main/kotlin/org/vld/sdp/structural/Decorator.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/DecoratorTest.kt) attaches *additional behavior* to an individual
object *dynamically* keeping the same interface without affecting the behavior of other objects of the same
class. Implement the original object interface by delegating the request to the original object and adding behavior
before/after the original request. Multiple decorators can be stacked on top of each other

- [**Facade**](src/main/kotlin/org/vld/sdp/structural/Facade.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/FacadeTest.kt) defines a *higher-level simplified interface* that makes
a system/library easier to use. Facade hides the complexities of a larger system with dependencies and provides a
simpler interface to the client. Client works only with the facade interface

- [**Flyweight**](src/main/kotlin/org/vld/sdp/structural/Flyweight.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/FlyweightTest.kt) uses *sharing* to support *large number of similar
objects* efficiently. Shares the intrinsic/invariant object state in an external data structure. When a new object is
created provides the cached intrinsic/invariant object state and allows the extrinsic/variant object state to be set
through the flyweight interface

- **Front Controller**

- [**Proxy**](src/main/kotlin/org/vld/sdp/structural/Proxy.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/ProxyTest.kt) provides a placeholder/wrapper for another object for
*access control*, *request validation*, *response caching*. The real object and the proxy implement the same interface,
so the client cannot distingish between the real object and the proxy. The proxy uses delation to the real object

## Behavioral Patterns

Behavioral patterns provide simple way of implementing **interactions between objects**.

- [**Chain of Responsibility**](src/main/kotlin/org/vld/sdp/behavioral/ChainOfResponsibility.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/ChainOfResponsibilityTest.kt) chains the receiving objects/functions
(handlers) and pass the request along the chain until an object/function handles the request completely or
partially. Avoids coupling of the request sender to the request receiver allowing more than one receiver a chance to
handle the request

- [**Command**](src/main/kotlin/org/vld/sdp/behavioral/Command.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/CommandTest.kt) encapsulates an action with the request parameters as
an function/object. Allows action/request queueing, logging and undoable operations. The `Command` object stores the
request parameters and delegates the request to the `Receiver`. The `Invoker` object uses the `Command` interface and
provides request queueing, logging and undoable operation functionality

- **Interpreter**

- **Iterator**

- **Mediator**

- **Memento**

- **Observer**

- **State**

- **Strategy**

- **Template Method**

- **Visitor**
