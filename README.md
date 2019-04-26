# Software Design Patterns in [Kotlin](https://kotlinlang.org/)

## Creational Patterns

Creational patterns **encapsulate knowledge about concrete classes** the system use, **hide how instances of these
classes are created** and **separate the system from how the objects are composed and represented**.

- [**Abstract Factory**](src/main/kotlin/org/vld/sdp/creational/AbstractFactory.kt)
[(usage)](src/test/kotlin/org/vld/sdp/creational/AbstractFactoryTest.kt)<br/>
**What**. Abstract Factory provides an interface for creating families of related/dependent objects without specifying
their concrete classes. Abstract Factory abstracts and encapsulates the creation of a suite of products for a given
platform/family that the system depends on<br/>
**How**. `AbstractFactory` interface provides methods for creating all kinds of products for a given
platform/family. Client works only with the `AbstractFactory` and the `Product` interfaces. The concrete
implementations of the `AbstractFactory` interface are singletons<br/>
**Example**. The system depends on a `Letter`=`Product` and a `Resume`=`Product` instances. The system uses a
`DocumentCreator`=`AbstractFactory` for creating the concrete `Letter` and `Resume` instances from the two families:
modern and fancy

- [**Builder**](src/main/kotlin/org/vld/sdp/creational/Builder.kt)
[(usage)](src/test/kotlin/org/vld/sdp/creational/BuilderTest.kt)<br/>
**What**. Builder separates a construction of a complex object from its representation, allowing the same construction
step by step process to create various representations<br/>
**How**. Client uses **(a)** a separate `Builder` object which receives each initialization parameter step by step
in a fluent interface or **(b)** a `Builder` DSL initialization method which configures properties by direct property
assignment or function call and returns the resulting constructed complex object at once<br/>
**Example**. `Car.Builder` provides a builder DSL (`Car.build { ... }`) for building a `Car` instance

- [**Dependency Injection**](src/main/kotlin/org/vld/sdp/creational/DependencyInjection.kt)
[(usage)](src/test/kotlin/org/vld/sdp/creational/DependencyInjectionTest.kt)<br/>
**What**. A class (client) accepts through an interface the objects (services/dependencies) the class requires from an
injector instead of creating the objects directly<br/>
**How**. The `Injector` passes the `Service` object to the `Client` class via the `Service` interface by the inversion
of control. `Injector` decouples the `Client` from creating the `Service` object directly. The `Injector` creates the
`Service` object and calls the `Client`. The `Client` does not know about the `Injector`. The `Client` works only with
the `Service` interfaces provided by the `Injector` via constructor injection or setter injection<br/>
**Example**. The `Client` requires the `ConstructorInjectedDependency` and the `SetterInjectedDependency` both
implementing the `Service` interface. The `Injector` creates the `Client` and sets up its dependent `Services` via the
constructor injection and the setter injection

- [**Factory Method**](src/main/kotlin/org/vld/sdp/creational/FactoryMethod.kt)
[(usage)](src/test/kotlin/org/vld/sdp/creational/FactoryMethodTest.kt)<br/>
**What**. Factory method defines an interface for creating a single object, but let subclasses decide which class to
instantiate<br/>
**How**. `FactoryMethod` interface provides a method for creating a single object. Client works only with the
`FactoryMethod` and the `Product` interfaces. The concrete implementations of the `FactoryMethod` interface are
singletons<br/>
**Example**. The system depends on an `Article`=`Product` instances. The system uses `ArticleCreator`=`FactoryMethod`
for creating a single `Article` instance from the two families: modern and fancy

- [**Prototype**](src/main/kotlin/org/vld/sdp/creational/Prototype.kt)
[(usage)](src/test/kotlin/org/vld/sdp/creational/PrototypeTest.kt)<br/>
**What**. Prototype creates new objects by cloning prototypical instance, boosting performance and keeping memory
footprint to a minimum<br/>
**How**. Client works only with the `Product` interface and uses the `Product::clone()` method for creating new
instances of the `Product`<br/>
**Example**. The `ProkaryoteCell`=`Product` and the `EukaryoteCell`=`Product` implement the `CellPrototype`
interface. In order to create a new instance of the specific cell the `CellPrototype::clone()` method is used

- [**Singleton**](src/main/kotlin/org/vld/sdp/creational/Singleton.kt)
[(usage)](src/test/kotlin/org/vld/sdp/creational/SingletonTest.kt)<br/>
**What**. Singleton ensures that a class has only one instance and provides a global point of access to the
instance. Singleton global variable like dependency is not declared in any component interface, but is tightly coupled
with all component implementations. Replace Singleton pattern with Dependency Injection pattern based on Dependency
Inversion Principle<br/>
**How**. Make the class constructor private and provide one public static method that always returns the same single
instance of the class stored in a private static variable<br/>
**Example**. The expression `object Singleton` defines a Singleton class and immediately instantiate the class with the
single point of access to the instance being the `Singleton` class name

## Structural Patterns

Structural patterns provide simple way of implementing **relationships between objects**.

- [**Adapter**](src/main/kotlin/org/vld/sdp/structural/Adapter.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/AdapterTest.kt)<br/>
**What**. Adapter converts the interface of the class without modifying class code into another interface that client
expects<br/>
**How**. Client works with the class through an implementation of the `Adapter` interface that client expects and
delegation to the class methods<br/>
**Example**. Client expects the `Phone`=`Adapter` interface. `XiaomiPhoneAdapter` implements the `Phone` interface that
client expects and delegates to the `XiaomiPhone` class methods

- [**Bridge**](src/main/kotlin/org/vld/sdp/structural/Bridge.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/BridgeTest.kt)<br/>
**What**. Bridge decouples an abstraction from its implementation (two orthogonal dimensions) allowing the two to vary
independently<br/>
**How**. The `Abstraction` and its `Implementation` are defined and extended independently. The `Abstraction` is
implemented by delegating to its `Implementation`<br/>
**Example**. The `Device`=`Abstraction` has two implementations `PhoneDevice` and `TabletDevice`. The
`Vendor`=`Implementation` has two implementations `XiaomiVendor` and `NokiaVendor`. The `Device` implementations accept
`Vendor` implementation. The `Device::switchOn()` method delegates to the `Vendor::support(Device)` method

- [**Composite**](src/main/kotlin/org/vld/sdp/structural/Composite.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/CompositeTest.kt)<br/>
**What**. Composite treats individual objects and composition of objects uniformly. Composes objects into tree
structures to represent part-whole hierarchies<br/>
**How**. The `Leaf` and the `Composite` classes implement the `Component` interface. The `Leaf` class implements the
request directly while the `Composite` class forwards recursively the request to composite's children<br/>
**Example**. The `Expression`=`Component` is a uniform `Component` interface. The `Operand`=`Leaf` implements the
request directly by returning the operand value. The `Operation`=`Composite` implements the request recursively by
evaluating its right and left expressions and than applying the actual operation to the results of the left and right
expression evaluations

- [**Decorator**](src/main/kotlin/org/vld/sdp/structural/Decorator.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/DecoratorTest.kt)<br/>
**What**. Decorator attaches additional behavior to an individual object dynamically keeping the same interface without
affecting the behavior of other objects of the same class<br/>
**How**. The `Decorator` class implements the original `Component` interface by delegating the request to the original
object and adding behavior before/after the original request. Multiple decorators can be stacked on top of each
other<br/>
**Example**. The `SimpleCoffee` original class implements the `Coffee`=`Component` interface. The
`CoffeeWithSugar`=`Decorator` and the `CoffeeWithMilk`=`Decorator` decorators implement the `Coffee` interface and
accept the `Coffee` instance to delegate to

- [**Facade**](src/main/kotlin/org/vld/sdp/structural/Facade.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/FacadeTest.kt)<br/>
**What**. Facade defines a higher-level simplified interface that makes a system/library easier to use. Facade hides the
complexities of a larger system with dependencies and provides a simpler interface to the client<br/>
**How**. Client works only with the `Facade` higher-level simplified interface to interact with the larger system<br/>
**Example**. The larger system `Desktop` implements the `Computer`=`Facade` interface which is used by the client. The
`Desktop` manages internally all the complexities involved with the subsystems `Cpu`, `Ram` and `Ssd`

- [**Flyweight**](src/main/kotlin/org/vld/sdp/structural/Flyweight.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/FlyweightTest.kt)<br/>
**What**. Flyweight uses sharing to support a large number of similar objects efficiently<br/>
**How**. Shares the `Invariant`/intrinsic object state in an external data structure. When a new object is created the
`FlyweightFactory` provides the cached `Invariant`/intrinsic object state and allows the `Variant`/extrinsic object
state to be set through the `Flyweight` interface<br/>
**Example**. The `GlyphCode`=`Invariant` represents the intrinsic glyph state (code) that can be cached and shared
between glyphs. The `GlyphFlyweight`=`Invariant`+`Variant` class implements the `Glyph`=`Flyweight` interface that
allows extrinsic glyph state (position) modification. The `GlyphFactory`=`FlyweightFactory` caches and shares
efficiently the `GlyphCode` instances

- [**Proxy**](src/main/kotlin/org/vld/sdp/structural/Proxy.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/ProxyTest.kt)<br/>
**What**. Proxy provides a placeholder/wrapper for another object for access control, request validation, response
caching, etc.<br/>
**How**. The real object and the `Proxy` implement the same `Subject` interface, so the client cannot distinguish
between the real object and the `Proxy`. The `Proxy` uses delegation to the real object</br>
**Example**. The real `Account` object implements the `Payment`=`Subject` interface without any balance/amount
validations. The `PaymentProxy`=`Proxy` implements the `Payment` interface with the balance/amount validation. Client
uses only the `Subject` interface to work with both the real `Account` object or with the `PaymentProxy` proxy object

## Behavioral Patterns

Behavioral patterns provide simple way of implementing **interactions between objects**.

- [**Chain of Responsibility**](src/main/kotlin/org/vld/sdp/behavioral/ChainOfResponsibility.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/ChainOfResponsibilityTest.kt)<br/>
**What**. Chain of Responsibility chains the receiving objects/functions (handlers) and pass the request along the chain
until an object/function handles the request completely or partially. Avoids coupling of the request sender to the
request receiver allowing more than one receiver a chance to handle the request<br/>
**How**. The `Request` represents the initial data, then intermediary results and finally the final result. The
`RequestHandler` functional interface processes the `Request` partially or completely. The `ChainOfResponsibility`
composes the `RequestHandler`s and implements the `RequestHandler` functional interface to process the `Request`
**Example**. The `cashRequestHandlerChain`=`ChainOfResponsibility` composes the `CashRequestHandler`=`RequestHandler`
and implements the `RequestHandler` interface to process the `CashRequest`=`Request`. The `CashRequest` has the initial
amount to represent with the set of notes. The `CashRequest` is used to handle intermediary results by representing the
remaining amount and a set of already processed notes. The `CashRequest` finally represent the final result of the set
of notes with the amount remainder if any

- [**Command**](src/main/kotlin/org/vld/sdp/behavioral/Command.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/CommandTest.kt)<br/>
**What**. Command encapsulates an action with the request parameters as an function/object and decouples the request for
an action from the actual action performer. Allows action/request queueing, logging and undoable operations<br/>
**How**. The `Command` object stores the request parameters and delegates the request to the `Receiver` which performs
the action. The `Invoker` object uses the `Command` interface and provides request queueing, logging and undoable
operation functionality<br/>
**Example**. The `cookStarter()`, `cookMainCourse()` and `cookDessert()` functions implement the
`Order`=`Command`=`Receiver` interface and store the request arguments in a closure. The `Waiter`=`Invoker` queues the
`Order`s and serves the `Order`s by using the `Order` interface

- [**Interpreter**](src/main/kotlin/org/vld/sdp/behavioral/Interpreter.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/InterpreterTest.kt)<br/>
**What**. Given a language (DSL), define a language grammar with an interpreter that use the grammar to interpret the
language sentences<br/>
**How**. Define an `Expression` class hierarchy for each `TerminalExpression` and `NonterminalExpression` symbol in the
language. The abstract syntax tree (AST) of the language sentence is a `Composite` of `Expression`s and is used to
evaluate the sentence. The `TerminalExpression` interprets the expression directly. The `NonterminalExpression` has a
container of children `Expression`s and recursively interprets every child `Expression`. Interpreter does not describe
how to build an AST. The AST can be build with a parser<br/>
**Example**. The `Constant`=`TerminalExpression`, the `Add`=`NonterminalExpression` and the
`Mul`=`NonterminalExpression` implement the `Expression` interface. The `Interpreter` implements the `Expression`
interpretation algorithm

- [**Iterator**](src/main/kotlin/org/vld/sdp/behavioral/Iterator.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/IteratorTest.kt)<br/>
**What**. Iterator provides a way to access the elements of an aggregate object/container of components sequentially
without exposing aggregate underlying representation (data structure). Iterator encapsulates the traversal algorithm of
a given aggregate object/container of components<br/>
**How**. The `ContainerIterator` implements the `Iterator` interface for the `Container` of `Component`s to traverse
sequentially the `Component`s of the `Container` without exposing the underlying aggregate representation. Client access
the `Component`s of the `Container` only through the `Iterator` interface<br/>
**Example**. The `FruitsIterator`=`ContainerIterator` implements the `Iterator` interface for the `Fruits`=`Container`
of `Fruit`=`Component`

- [**Mediator**](src/main/kotlin/org/vld/sdp/behavioral/Mediator.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/MediatorTest.kt)<br/>
**What**. Mediator defines an object that encapsulates how a set of other objects interact. Mediator promotes loose
coupling between the colleagues<br/>
**How**. The `Colleague`s interact with each other through the `Mediator` interface without having any references to
each other. The `Mediator` object has references to every `Colleague` and interacts with a `Colleague` through a
common `Colleague` interface<br/>
**Example**. The `Airplane`=`Colleague` and the `Helicopter`=`Colleague` implement the `Aircraft`=`Colleague` interface
and accept the `ControlTower`=`Mediator`. The `Airplane` and the `Helicopter` communicate with each other through the
`ControlTower` interface. The `ControlTower` has the references to the `Airplane` and the `Helicopter` and forwards the
messages through the `Aircraft` interface

- [**Memento**](src/main/kotlin/org/vld/sdp/behavioral/Memento.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/MementoTest.kt)<br/>
**What**. Memento captures and externalizes an object's internal state without violating encapsulation. Allows the
object to be restored (undo/rollback) to the captured state later<br/>
**How**. The `Caretaker` requests the `Originator` to snapshot `Originator`'s internal state into the `Memento` object
before using the `Originator`. To rollback the `Originator`'s internal state the `Caretaker` returns back the `Memento`
object to the `Originator`<br/>
**Example**. The `Counter`=`Originator` object provides a `CounterMemento`=`Memento` object to store to/retrieve from
the `Counter` internal state. The incremental count of the `Counter` object could be altered by using the
`CounterMemento` object

- [**Observer**](src/main/kotlin/org/vld/sdp/behavioral/Observer.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/ObserverTest.kt)<br/>
**What**. Observer defines a one-to-many dependency between objects where a state change in one object `Subject` is
automatically notified to all subjects' dependents `Observers`<br/>
**How**. The `Subject` maintains a list of the `Observer`s which implements the `Observer` interface. When the
`Subject`'s state changes the `Subject` notifies all the `Observer`s using the `Observer` interface. The `Subject` and
the `Observer`s are loosely coupled as the state change notification is done through the `Observer` interface<br/>
**Example**. The `Bidder`=`Observer` implements the `BidObserver`=`Observer` interface. The `Auctioneer`=`Subject`
implements the `AuctioneerSubject`=`Subject` interface. When the bid changes the `Auctioneer` notifies all the `Bidders`
through the `BidObserver` interface

- [**State**](src/main/kotlin/org/vld/sdp/behavioral/State.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/StateTest.kt)<br/>
**What**. State alters objects' behavior when object's state changes<br/>
**How**. The `State` interface implementation provides the request handling functionality and sets the next
`State`. `State` implements a state machine where each individual state is a derived class of the `State` interface and
each transition is defined in state interface method invocation<br/>
**Example**. The `VendingMachine` internal state goes through the `ShowProducts`, `SelectProduct`, `DepositMoney` and
`DeliverProduct` `State`s by invoking the `VendingMachine::proceed()` method which delegates to the current
`State::handleRequest()` method which handles the request and sets the next `VendingMachine` `State`

- [**Strategy**](src/main/kotlin/org/vld/sdp/behavioral/Strategy.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/StrategyTest.kt)<br/>
**What**. Strategy defines a family of interchangeable at runtime algorithms and provides excellent support for the
Open-Closed Principle<br/>
**How**. Define a set of interchangeable algorithms/strategies that implement the `Strategy` interface. Based on the
conditions at runtime dynamically select the appropriate algorithm/strategy. Client works only with the `Strategy`
interface<br/>
**Example**. The `TransportCompany` dynamically select the appropriate algorithm/strategy `goByBus` or `goByTaxi` based
on the size of the tourist group. Both `goByBus` and `goByTaxi` implements the `Transport`=`Strategy` interface under
which the algorithms/strategies are provided to the client

- [**Template Method**](src/main/kotlin/org/vld/sdp/behavioral/TemplateMethod.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/TemplateMethodTest.kt)<br/>
**What**. Template Method defines the skeleton of an algorithm (invariant) in one operation deferring some steps
(variable) to subclasses (inversion of control) and preserving the overall structure of the algorithm<br/>
**How**. The abstract class defines the abstract algorithm `Template` with the overall algorithm structure. The
invariant algorithm steps are defined as final methods in the abstract class and the variant steps are open for
overriding in the `Template` specializations<br/>
**Example**. The `Employee`=`Template` defines the overall algorithm structure, the invariant and variant algorithm
steps. The `Developer` and the `Architect` algorithm specialization override the variable algorithm steps

- [**Visitor**](src/main/kotlin/org/vld/sdp/behavioral/Visitor.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/VisitorTest.kt)<br/>
**What**. Visitor separates an algorithm from an object structure on which the algorithm operates. Visitor allows to add
new operations through the `Visitor`s to the existent object structure known as `Element`s without modifying the
structure<br/>
**How**. The `Element` interface defines a visitor operation for every `Visitor` type based on the abstract `Visitor`
interface implementing the dynamic dispatch on the abstract `Visitor` interface. Every `Visitor` interface defines the
overloaded for each `Element` type operation implementing the static dispatch on the concrete `Element` type. Every
`Visitor` interface implementation has the cross between the concrete `Element` and the concrete `Visitor` implementing
the double dispatch (dynamic on the `Visitor` type and static on the `Element` type)<br/>
**Example**. The `XiaomiPhone` and the `NokiaPhone` implement the `Phone`=`Element` interface for the dynamic dispatch
on the abstract `Visitor` type (one operation for each `Visitor` type). The `IntelWiFi` and the `BroadcomWiFi` implement
the `WiFi`=`Visitor` interface for the static dispatch on the concrete `Phone` type to switch on the `WiFi` visitor
operation. The `SonyCamera` and the `SamsungCamera` implement the `Camera`=`Visitor` interface for the static dispatch
on the concrete `Phone` type to take phones with the `Camera` visitor operation. So the two visitor operations (switch
on WiFi and take photo) are implemented on the `Phone` `Element` structure

# Fundamental Software Design Principles

- **KISS - Keep It Simple, Stupid**. Do the simplest thing that could possibly work. Avoid unnecessary
  complexity. Maintain balance between code simplicity and system flexibility, extensibility
- **YAGNI - You Aren't Gonna Need It**. Do not write code that is not necessary at the moment, but might be necessary in
  the future. Do the simplest thing that could possibly work
- **DRY - Don't Repeat Yourself**. Avoid duplication. Every piece of knowledge must have a single, unambiguous,
  authoritative representation within the system. The modification of any single element of the system does not require
  a change in other logically unrelated elements
- **Information Hiding**. One piece of code that calls another piece of code should not know internals about that other
  piece of code. This make it possible to change internal parts of the called piece of code without being forced to
  change the calling piece of code accordingly. Expose as little as possible of the internal implementation details of a
  module to promote Loose Coupling between modules. Provide a stable interface to module functionality that will protect
  the clients of the module from changes in module implementation. A module implements the Information Hiding principle
  by applying the encapsulation technique
- **High Cohesion**. High Cohesion is a degree to which the components inside a module belongs together. A module has
  High Cohesion when the module responsibility is clearly defined and the module has as few dependencies as
  possible. Single Responsibility Principle fosters High Cohesion
- **Loose Coupling**. Each module in the system has as little knowledge as possible about other modules in the
  system. Use interfaces to implement Loose Coupling between modules. High Cohesion fosters Loose Coupling
- **Robustness principle**. Be conservative in what you do (produce outputs compliant with the specification). Be
  liberal in what you accept from others (validate and sanitize inputs as long as the meaning is clear)
- **Top-down approach**. Mostly used in Object-Oriented Programming (OOP) with interfaces and abstract
  classes. Decomposition a system into the compositional subsystems. An overview of the system is formulated specifying
  but not detailing any first-level subsystems. Each subsystem is then refined in yet greater detail, until the entire
  specification is reduced to base elements. Emphasize on complete understanding of the system. No coding can begin
  until a sufficient level of detail has been reached in design phase
- **Bottom-up approach**. Mostly used in Functional Programming (FP) with function composition. Composition of basic
  elements together into a more complex system. The individual base elements of a system are first specified in great
  detail. These elements are then linked together to form larger subsystems, until a complete top-level system is
  formed. Emphasized coding and early testing, which can begin as soon as the first module has been specified. There is
  a risk of how the modules can be linked together to form a top-level system
- **RAII - Resource Acquisition Is Initialization**. Smart Pointer: constructor acquires, destructor releases. Smart
  Pointer is scope-based resource management. When a resource gets out of scope via normal execution or thrown exception
  the resource is deallocated automatically by the Smart Pointer destructor. RAII only works for resources acquired and
  released by stack-allocated objects where there is well-defined static object lifetime
- **OOP - Object-Oriented Programming**. OOP is like biological cells: messaging, state hiding, late binding. Object has
  well encapsulated structure (properties) and provides behavior (methods) through well defined interface. Abstraction,
  responsibilities and modularization are the keys to master complexity
- **FCoI - Favor Composition + Delegation over Inheritance**. Composition is black box reuse through an interface and
  promotes loose coupling. Inheritance is white box reuse through public/protected members
- **ADP - Acyclic Dependency Principle**. Circular dependencies should be avoided. Dependency Inversion Principle or
  creation of a new package with common components breaks the circular dependencies
- **LoD - Law of Demeter**. The Principle of Least Knowledge/Dependencies - don't talk to strangers, only talk to your
  immediate neighbors. LoD fosters Loose Coupling and Information Hiding

# SOLID Principles

- **SRP - Single Responsibility Principle**. Software unit should have only one single and well defined responsibility,
  only one reason to change. High Cohesion fosters SRP
- **OCP - Open-Closed Principle**. Software unit should be open for extension (inheritance, Strategy or Decorator design
  patterns), but closed for modification (interface with multiple polymorphic implementations)
- **LSP - Liskov Substitution Principle**. Hierarchy is used to build specialized types from a more general
  type. Polymorphism means that one single interface provides access to objects of different types. Subtype must be
  completely substitutable for its supertype. Preconditions cannot be strengthened in a subtype. Postconditions cannot be
  weakened in a subtype. Supertype invariants must be preserved in a subtype
- **ISP - Interface Segregation Principle**. Segregate one broad single interface into a set of smaller and highly
  cohesive interfaces
- **DIP - Dependency Inversion Principle**. Avoid tight coupling between modules with the mediation of an abstraction
  (interface) layer. Each module should depend on an abstraction (interface), not other modules directly. The
  abstraction (interface) provides the behavior needed by the module through possibly multiple implementations. Common
  features should be consolidated in a shared abstractions exposed through interfaces. Dependency Inversion Principle
  fosters testability of components

# UNIX Principles

- Make each program do one thing and do it well
- To do a new job build afresh rather than complicate old programs by adding new features
- Expect the output of every program to become the input to another program. Write programs to handle text streams,
  because text is a universal interface. Don't clutter the output with extraneous information. Don't insist for
  interactive input and allow for scripting
- Favor composability over monolithic design
- Design and build software to be tried early. Build prototype as soon as possible. Don't hesitate to throw away bad
  design and rebuild from scratch
- Use tools or even build tools for repetitive task automation
