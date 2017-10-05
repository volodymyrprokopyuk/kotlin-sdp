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

- [**Prototype**](src/main/kotlin/org/vld/sdp/creational/Prototype.kt)
[(usage)](src/test/kotlin/org/vld/sdp/creational/PrototypeTest.kt) creates new objects *cloning prototypical instance*,
boosting performance and keeping memory footprint to a minimum. Client works only with *interfaces* of the prototype and
product interface

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

- [**Iterator**](src/main/kotlin/org/vld/sdp/behavioral/Iterator.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/IteratorTest.kt) provides a way to acces the elements of an aggregate
object/container sequentially without exposing aggregate underlying representation (data structure). Iterator
encapsulates the traversal algorithm of a given aggregate object/container

- [**Mediator**](src/main/kotlin/org/vld/sdp/behavioral/Mediator.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/MediatorTest.kt) defines an object the encapsulates how a set of
objects interact. Mediator promotes *loose coupling between colleagues*. Colleagues interact with each other through
the mediator object

- [**Memento**](src/main/kotlin/org/vld/sdp/behavioral/Memento.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/MementoTest.kt) captures and externalizes an *object's internal state*
without violating encapsulation. Allows the object to be restored (undo/rollback) to this state later. `Caretaker`
requests the `Originator` to stapshot its internal state into the `Memento` object before using the `Originator`. To
rollback the `Originator`'s internal state the `Caretaker` returns back the `Memento` object to the `Originator`

- [**Observer**](src/main/kotlin/org/vld/sdp/behavioral/Observer.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/ObserverTest.kt) defines a one-to-many dependency between objects where
a state change in one object (subject) is automatically notified to all subjects' dependents (observers). The subject
and the observers are loosely coupled as the state change notification is done through the `Observer` interface

- [**State**](src/main/kotlin/org/vld/sdp/behavioral/State.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/StateTest.kt) alters objects' behavior when object's state
changes. State implements a *state machine* where each individual state is a derived class of the state interface and
each transition is a defined in state interface mathod invokation

- [**Strategy**](src/main/kotlin/org/vld/sdp/behavioral/Stragegy.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/StragegyTest.kt) defines a family of interchangeable at run-time
algorithms

- [**Template Method**](src/main/kotlin/org/vld/sdp/behavioral/TemplateMethod.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/TemplateMethodTest.kt) defines the skeleton of an algorithm (invariant)
in one operation deferring some steps (variable) to subclasses (inversion of control) and preserving the overall
structure of the alrogithm

- [**Visitor**](src/main/kotlin/org/vld/sdp/behavioral/Visitor.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/VisitorTest.kt) separates an algorithm from an object structure on
which the algorithm operates. Allows to add new operations through visitors to the existent object structure known as
elements without modifying the structure. Visitor implements *double dispatch* based on concrete `Visitor` and concrete
`Element`
