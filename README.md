# Software design patterns in [Kotlin](https://kotlinlang.org/)

## Creational patterns

Creational patterns **encapsulate knowledge about concrete classes** the system use,
**hide how instances of these classes are created** and **separate the system from how
the objects are composed and represented**.

- [**Abstract factory**](src/main/kotlin/org/vld/sdp/creational/AbstractFactory.kt)
[(usage)](src/test/kotlin/org/vld/sdp/creational/AbstractFactoryTest.kt)<br/>
**What**. Abstract Factory provides an interface for creating families of
related/dependent objects without specifying their concrete classes. Abstract Factory
abstracts and encapsulates the creation of a suite of products for a given
platform/family that the system depends on<br/>
**How**. `AbstractFactory` interface provides methods for creating all kinds of products
for a given platform/family. Client works only with the `AbstractFactory` and the
`Product` interfaces. The concrete implementations of the `AbstractFactory` interface
are singletons<br/>
**Example**. The system depends on a `Letter`=`Product` and a `Resume`=`Product`
instances. The system uses a `DocumentCreator`=`AbstractFactory` for creating the
concrete `Letter` and `Resume` instances from the two families: modern and fancy

- [**Builder**](src/main/kotlin/org/vld/sdp/creational/Builder.kt)
[(usage)](src/test/kotlin/org/vld/sdp/creational/BuilderTest.kt) #<br/>
**What**. Builder separates the construction of a complex object from its
representation, allowing the same step by step construction process to create various
representations<br/>
**How**. Client uses **(a)** a separate `Builder` object which receives each
initialization parameter step by step in a fluent interface or **(b)** a `Builder` DSL
initialization method which configures properties by direct property assignment or
function call and returns the resulting constructed complex object at once<br/>
**Example**. `Car.Builder` provides a builder DSL (`Car.build { ... }`) for building a
`Car` instance

- [**Dependency injection**](src/main/kotlin/org/vld/sdp/creational/DependencyInjection.kt)
[(usage)](src/test/kotlin/org/vld/sdp/creational/DependencyInjectionTest.kt) #<br/>
**What**. A class (client) accepts through an interface objects (services/dependencies)
the class requires from an injector instead of creating the objects directly<br/>
**How**. The `Injector` passes the `Service` object to the `Client` class via the
`Service` interface by the inversion of control. `Injector` decouples the `Client` from
creating the `Service` object directly. The `Injector` creates the `Service` object and
calls the `Client`. The `Client` does not know about the `Injector`. The `Client` works
only with the `Service` interfaces provided by the `Injector` via constructor injection
or setter injection<br/>
**Example**. The `Client` requires the `ConstructorInjectedDependency` and the
`SetterInjectedDependency` both implementing the `Service` interface. The `Injector`
creates the `Client` and sets up its dependent `Services` via the constructor injection
and the setter injection

- [**Factory method**](src/main/kotlin/org/vld/sdp/creational/FactoryMethod.kt)
[(usage)](src/test/kotlin/org/vld/sdp/creational/FactoryMethodTest.kt)<br/>
**What**. Factory method defines an interface for creating a single object, but let
subclasses decide which class to instantiate<br/>
**How**. `FactoryMethod` interface provides a method for creating a single
object. Client works only with the `FactoryMethod` and the `Product` interfaces. The
concrete implementations of the `FactoryMethod` interface are singletons<br/>
**Example**. The system depends on an `Article`=`Product` instances. The system uses
`ArticleCreator`=`FactoryMethod` for creating a single `Article` instance from the two
families: modern and fancy

- [**Prototype**](src/main/kotlin/org/vld/sdp/creational/Prototype.kt)
[(usage)](src/test/kotlin/org/vld/sdp/creational/PrototypeTest.kt) #<br/>
**What**. Prototype creates new objects by cloning prototypical instance, boosting
performance and keeping memory footprint to a minimum<br/>
**How**. Client works only with the `Product` interface and uses the `Product::clone()`
method for creating new instances of the `Product`<br/>
**Example**. The `ProkaryoteCell`=`Product` and the `EukaryoteCell`=`Product` implement
the `CellPrototype` interface. In order to create a new instance of the specific cell
the `CellPrototype::clone()` method is used

- [**Singleton**](src/main/kotlin/org/vld/sdp/creational/Singleton.kt)
[(usage)](src/test/kotlin/org/vld/sdp/creational/SingletonTest.kt)<br/>
**What**. Singleton ensures that a class has only one instance and provides a global
point of access to the instance. Singleton global variable like dependency is not
declared in any component interface, but is tightly coupled with all component
implementations. Replace Singleton pattern with Dependency Injection pattern based on
Dependency Inversion Principle<br/>
**How**. Make the class constructor private and provide one public static method that
always returns the same single instance of the class stored in a private static
variable<br/>
**Example**. The expression `object Singleton` defines a Singleton class and immediately
instantiate the class with the single point of access to the instance being the
`Singleton` class name

## Structural patterns

Structural patterns provide simple way of implementing **relationships between objects**.

- [**Adapter**](src/main/kotlin/org/vld/sdp/structural/Adapter.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/AdapterTest.kt)<br/>
**What**. Adapter converts the interface of the class without modifying class code into
another interface that client expects<br/>
**How**. Client works with the class through an implementation of the `Adapter`
interface that client expects and delegation to the class methods<br/>
**Example**. Client expects the `Phone`=`Adapter` interface. `XiaomiPhoneAdapter`
implements the `Phone` interface that client expects and delegates to the `XiaomiPhone`
class methods

- [**Bridge**](src/main/kotlin/org/vld/sdp/structural/Bridge.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/BridgeTest.kt)<br/>
**What**. Bridge decouples an abstraction from its implementation (two orthogonal
dimensions) allowing the two to vary independently<br/>
**How**. The `Abstraction` and its `Implementation` are defined and extended
independently. The `Abstraction` is implemented by delegating to its
`Implementation`<br/>
**Example**. The `Device`=`Abstraction` has two implementations `PhoneDevice` and
`TabletDevice`. The `Vendor`=`Implementation` has two implementations `XiaomiVendor` and
`NokiaVendor`. The `Device` implementations accept `Vendor` implementation. The
`Device::switchOn()` method delegates to the `Vendor::support(Device)` method

- [**Composite**](src/main/kotlin/org/vld/sdp/structural/Composite.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/CompositeTest.kt) #<br/>
**What**. Composite treats individual objects and composition of objects
uniformly. Composes objects into tree structures to represent part-whole
hierarchies<br/>
**How**. The `Leaf` and the `Composite` classes implement the `Component` interface. The
`Leaf` class implements the request directly while the `Composite` class forwards
recursively the request to composite's children<br/>
**Example**. The `Expression`=`Component` is a uniform `Component` interface. The
`Operand`=`Leaf` implements the request directly by returning the operand value. The
`Operation`=`Composite` implements the request recursively by evaluating its right and
left expressions and than applying the actual operation to the results of the left and
right expression evaluations

- [**Decorator**](src/main/kotlin/org/vld/sdp/structural/Decorator.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/DecoratorTest.kt) #<br/>
**What**. Decorator attaches additional behavior to an individual object dynamically
keeping the same interface without affecting the behavior of other objects of the same
class<br/>
**How**. The `Decorator` class implements the original `Component` interface by
delegating the request to the original object and adding behavior before/after the
original request. Multiple decorators can be stacked on top of each other<br/>
**Example**. The `SimpleCoffee` original class implements the `Coffee`=`Component`
interface. The `CoffeeWithSugar`=`Decorator` and the `CoffeeWithMilk`=`Decorator`
decorators implement the `Coffee` interface and accept the `Coffee` instance to delegate
to

- [**Facade**](src/main/kotlin/org/vld/sdp/structural/Facade.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/FacadeTest.kt)<br/>
**What**. Facade defines a higher-level simplified interface that makes a system/library
easier to use. Facade hides the complexities of a larger system with dependencies and
provides a simpler interface to the client<br/>
**How**. Client works only with the `Facade` higher-level simplified interface to
interact with the larger system<br/>
**Example**. The larger system `Desktop` implements the `Computer`=`Facade` interface
which is used by the client. The `Desktop` manages internally all the complexities
involved with the subsystems `Cpu`, `Ram` and `Ssd`

- [**Flyweight**](src/main/kotlin/org/vld/sdp/structural/Flyweight.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/FlyweightTest.kt)<br/>
**What**. Flyweight uses sharing to support a large number of similar objects
efficiently<br/>
**How**. Shares the `Invariant`/intrinsic object state in an external data
structure. When a new object is created the `FlyweightFactory` provides the cached
`Invariant`/intrinsic object state and allows the `Variant`/extrinsic object state to be
set through the `Flyweight` interface<br/>
**Example**. The `GlyphCode`=`Invariant` represents the intrinsic glyph state (code)
that can be cached and shared between glyphs. The `GlyphFlyweight`=`Invariant`+`Variant`
class implements the `Glyph`=`Flyweight` interface that allows extrinsic glyph state
(position) modification. The `GlyphFactory`=`FlyweightFactory` caches and shares
efficiently the `GlyphCode` instances

- [**Proxy**](src/main/kotlin/org/vld/sdp/structural/Proxy.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/ProxyTest.kt) #<br/>
**What**. Proxy provides a placeholder/wrapper for another object for access control,
request validation, response caching, etc.<br/>
**How**. The real object and the `Proxy` implement the same `Subject` interface, so the
client cannot distinguish between the real object and the `Proxy`. The `Proxy` uses
delegation to the real object</br>
**Example**. The real `Account` object implements the `Payment`=`Subject` interface
without any balance/amount validations. The `PaymentProxy`=`Proxy` implements the
`Payment` interface with the balance/amount validation. Client uses only the `Subject`
interface to work with both the real `Account` object or with the `PaymentProxy` proxy
object

## Behavioral patterns

Behavioral patterns provide simple way of implementing **interactions between objects**.

- [**Chain of responsibility**](src/main/kotlin/org/vld/sdp/behavioral/ChainOfResponsibility.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/ChainOfResponsibilityTest.kt) #<br/>
**What**. Chain of Responsibility chains the receiving objects/functions (handlers) and
pass the request along the chain until an object/function handles the request completely
or partially. Avoids coupling of the request sender to the request receiver allowing
more than one receiver a chance to handle the request<br/>
**How**. The `Request` represents the initial data, then intermediary results and
finally the final result. The `RequestHandler` functional interface processes the
`Request` partially or completely. The `ChainOfResponsibility` composes the
`RequestHandler`s and implements the `RequestHandler` functional interface to process
the `Request`</br>
**Example**. The `cashRequestHandlerChain`=`ChainOfResponsibility` composes the
`CashRequestHandler`=`RequestHandler` and implements the `RequestHandler` interface to
process the `CashRequest`=`Request`. The `CashRequest` has the initial amount to
represent with the set of notes. The `CashRequest` is used to handle intermediary
results by representing the remaining amount and a set of already processed notes. The
`CashRequest` finally represent the final result of the set of notes with the amount
remainder if any

- [**Command**](src/main/kotlin/org/vld/sdp/behavioral/Command.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/CommandTest.kt)<br/>
**What**. Command encapsulates an action with the request parameters as an
function/object and decouples the request for an action from the actual action
performer. Allows action/request queueing, logging and undoable operations<br/>
**How**. The `Command` object stores the request parameters and delegates the request to
the `Receiver` which performs the action. The `Invoker` object uses the `Command`
interface and provides request queueing, logging and undoable operation
functionality<br/>
**Example**. The `cookStarter()`, `cookMainCourse()` and `cookDessert()` functions
implement the `Order`=`Command`=`Receiver` interface and store the request arguments in
a closure. The `Waiter`=`Invoker` queues the `Order`s and serves the `Order`s by using
the `Order` interface

- [**Interpreter**](src/main/kotlin/org/vld/sdp/behavioral/Interpreter.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/InterpreterTest.kt)<br/>
**What**. Given a language (DSL), define a language grammar with an interpreter that use
the grammar to interpret the language sentences<br/>
**How**. Define an `Expression` class hierarchy for each `TerminalExpression` and
`NonterminalExpression` symbol in the language. The abstract syntax tree (AST) of the
language sentence is a `Composite` of `Expression`s and is used to evaluate the
sentence. The `TerminalExpression` interprets the expression directly. The
`NonterminalExpression` has a container of children `Expression`s and recursively
interprets every child `Expression`. Interpreter does not describe how to build an
AST. The AST can be build with a parser<br/>
**Example**. The `Constant`=`TerminalExpression`, the `Add`=`NonterminalExpression` and
the `Mul`=`NonterminalExpression` implement the `Expression` interface. The
`Interpreter` implements the `Expression` interpretation algorithm

- [**Iterator**](src/main/kotlin/org/vld/sdp/behavioral/Iterator.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/IteratorTest.kt) #<br/>
**What**. Iterator provides a way to access the elements of an aggregate
object/container of components sequentially without exposing the underlying
representation (data structure) of the aggregate. Iterator encapsulates the traversal
algorithm of a given aggregate object/container of components<br/>
**How**. The `ContainerIterator` implements the `Iterator` interface for the `Container`
of `Component`s to traverse sequentially the `Component`s of the `Container` without
exposing the underlying aggregate representation. Client access the `Component`s of the
`Container` only through the `Iterator` interface<br/>
**Example**. The `FruitsIterator`=`ContainerIterator` implements the `Iterator`
interface for the `Fruits`=`Container` of `Fruit`=`Component`

- [**Mediator**](src/main/kotlin/org/vld/sdp/behavioral/Mediator.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/MediatorTest.kt)<br/>
**What**. Mediator defines an object that encapsulates how a set of other objects
interact. Mediator promotes loose coupling between collaborators<br/>
**How**. The `Colleague`s interact with each other through the `Mediator` interface
without having any references to each other. The `Mediator` object has references to
every `Colleague` and interacts with a `Colleague` through a common `Colleague`
interface<br/>
**Example**. The `Airplane`=`Colleague` and the `Helicopter`=`Colleague` implement the
`Aircraft`=`Colleague` interface and accept the `ControlTower`=`Mediator`. The
`Airplane` and the `Helicopter` communicate with each other through the `ControlTower`
interface. The `ControlTower` has the references to the `Airplane` and the `Helicopter`
and forwards the messages through the `Aircraft` interface

- [**Memento**](src/main/kotlin/org/vld/sdp/behavioral/Memento.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/MementoTest.kt)<br/>
**What**. Memento captures and externalizes an object's internal state without violating
encapsulation. Allows the object to be restored (undo/rollback) to the captured state
later<br/>
**How**. The `Caretaker` requests the `Originator` to snapshot `Originator`'s internal
state into the `Memento` object before using the `Originator`. To rollback the
`Originator`'s internal state the `Caretaker` returns back the `Memento` object to the
`Originator`<br/>
**Example**. The `Counter`=`Originator` object provides a `CounterMemento`=`Memento`
object to store to/retrieve from the `Counter` internal state. The incremental count of
the `Counter` object could be altered by using the `CounterMemento` object

- [**Observer**](src/main/kotlin/org/vld/sdp/behavioral/Observer.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/ObserverTest.kt) #<br/>
**What**. Observer defines a one-to-many dependency between objects where a state change
in one object `Subject` is automatically notified to all subjects' dependents
`Observers`<br/>
**How**. The `Subject` maintains a list of the `Observer`s which implements the
`Observer` interface. When the `Subject`'s state changes the `Subject` notifies all the
`Observer`s using the `Observer` interface. The `Subject` and the `Observer`s are
loosely coupled as the state change notification is done through the `Observer`
interface<br/>
**Example**. The `Bidder`=`Observer` implements the `BidObserver`=`Observer`
interface. The `Auctioneer`=`Subject` implements the `AuctioneerSubject`=`Subject`
interface. When the bid changes the `Auctioneer` notifies all the `Bidders` through the
`BidObserver` interface

- [**State**](src/main/kotlin/org/vld/sdp/behavioral/State.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/StateTest.kt)<br/>
**What**. State alters objects' behavior when object's state changes<br/>
**How**. The `State` interface implementation provides the request handling
functionality and sets the next `State`. `State` implements a state machine where each
individual state is a derived class of the `State` interface and each transition is
defined in state interface method invocation<br/>
**Example**. The `VendingMachine` internal state goes through the `ShowProducts`,
`SelectProduct`, `DepositMoney` and `DeliverProduct` `State`s by invoking the
`VendingMachine::proceed()` method which delegates to the current
`State::handleRequest()` method which handles the request and sets the next
`VendingMachine` `State`

- [**Strategy**](src/main/kotlin/org/vld/sdp/behavioral/Strategy.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/StrategyTest.kt) #<br/>
**What**. Strategy defines a family of interchangeable at runtime algorithms and
provides excellent support for the Open-Closed Principle<br/>
**How**. Define a set of interchangeable algorithms/strategies that implement the
`Strategy` interface. Based on the conditions at runtime dynamically select the
appropriate algorithm/strategy. Client works only with the `Strategy` interface<br/>
**Example**. The `TransportCompany` dynamically select the appropriate
algorithm/strategy `goByBus` or `goByTaxi` based on the size of the tourist group. Both
`goByBus` and `goByTaxi` implements the `Transport`=`Strategy` interface under which the
algorithms/strategies are provided to the client

- [**Template method**](src/main/kotlin/org/vld/sdp/behavioral/TemplateMethod.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/TemplateMethodTest.kt)<br/>
**What**. Template Method defines the skeleton of an algorithm (invariant) in one
operation deferring some steps (variable) to subclasses (inversion of control) and
preserving the overall structure of the algorithm<br/>
**How**. The abstract class defines the abstract algorithm `Template` with the overall
algorithm structure. The invariant algorithm steps are defined as final methods in the
abstract class and the variant steps are open for overriding in the `Template`
specializations<br/>
**Example**. The `Employee`=`Template` defines the overall algorithm structure, the
invariant and variant algorithm steps. The `Developer` and the `Architect` algorithm
specialization override the variable algorithm steps

- [**Visitor**](src/main/kotlin/org/vld/sdp/behavioral/Visitor.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/VisitorTest.kt)<br/>
**What**. Visitor separates an algorithm from an object structure on which the algorithm
operates. Visitor allows to add new operations through the `Visitor`s to the existing
object structure known as `Element`s without modifying the structure<br/>
**How**. The `Element` interface defines a visitor operation for every `Visitor` type
based on the abstract `Visitor` interface implementing the dynamic dispatch on the
abstract `Visitor` interface. Every `Visitor` interface defines the overloaded for each
`Element` type operation implementing the static dispatch on the concrete `Element`
type. Every `Visitor` interface implementation has the cross between the concrete
`Element` and the concrete `Visitor` implementing the double dispatch (dynamic on the
`Visitor` type and static on the `Element` type)<br/>
**Example**. The `XiaomiPhone` and the `NokiaPhone` implement the `Phone`=`Element`
interface for the dynamic dispatch on the abstract `Visitor` type (one operation for
each `Visitor` type). The `IntelWiFi` and the `BroadcomWiFi` implement the
`WiFi`=`Visitor` interface for the static dispatch on the concrete `Phone` type to
switch on the `WiFi` visitor operation. The `SonyCamera` and the `SamsungCamera`
implement the `Camera`=`Visitor` interface for the static dispatch on the concrete
`Phone` type to take phones with the `Camera` visitor operation. So the two visitor
operations (switch on WiFi and take photo) are implemented on the `Phone` `Element`
structure

# Fundamental software design principles

- **KISS - Keep It Simple, Stupid**. Do the simplest thing that could possibly
  work. Avoid unnecessary complexity. Maintain balance between code simplicity and
  system flexibility, extensibility
- **YAGNI - You Aren't Gonna Need It**. Do not write code that is not necessary at the
  moment, but might be necessary in the future. Do the simplest thing that could
  possibly work
- **DRY - Don't Repeat Yourself**. Avoid duplication. Every piece of knowledge must have
  a single, unambiguous, authoritative representation within the system. The
  modification of any single element of the system does not require a change in other
  logically unrelated elements
- **Abstraction principle**. Function (interpretation) and structure (representation)
  should be independent. It should be possible to use a value or a procedure whthout
  knowing how it is implemented. It should be possible to change the implementation
  without breaking the client code
    - **Data abstraction** (abstract data types, ADT). Hide the representation of a data
      type behind an interface (constructors, selectors, [mutators], type predicate)
    - **Procedure abstraction** (higher-order functions, HOF). Define the generic
      algorithm in a function that takes as a parameter(s) other function(s) to perform
      specific task(s). Examples: map, filter, fold (fundamental iterator), unfold
      (fundamental constructor)
- **Information hiding**. Information should only be made available on a need-to-know
  basis. **Locality principle** scopes should be as small as possible. One piece of code
  that calls another piece of code should not know internals about that other piece of
  code. This make it possible to change internal parts of the called piece of code
  without being forced to change the calling piece of code accordingly. Expose as little
  as possible of the internal implementation details of a module to promote Loose
  Coupling between modules. Provide a stable interface to module functionality that will
  protect the clients of the module from changes in module implementation. A module
  implements the Information Hiding principle by applying the encapsulation technique
- **High cohesion**. High Cohesion is a degree to which the components inside a module
  belongs together. A module has High Cohesion when the module responsibility is clearly
  defined and the module has as few dependencies as possible. Single Responsibility
  Principle fosters High Cohesion
- **Loose coupling**. Each module in the system has as little knowledge as possible
  about other modules in the system. Use interfaces to implement Loose Coupling between
  modules. High Cohesion fosters Loose Coupling
- **Robustness principle**. Be conservative in what you do (produce outputs compliant
  with the specification). Be liberal in what you accept from others (validate and
  sanitize inputs as long as the meaning is clear)
- **Top-down approach**. Mostly used in Object-Oriented Programming (OOP) with
  interfaces and abstract classes. Decomposition a system into the compositional
  subsystems. An overview of the system is formulated specifying but not detailing any
  first-level subsystems. Each subsystem is then refined in yet greater detail, until
  the entire specification is reduced to base elements. Emphasize on complete
  understanding of the system. No coding can begin until a sufficient level of detail
  has been reached in design phase
- **Bottom-up approach**. Mostly used in Functional Programming (FP) with function
  composition. Composition of basic elements together into a more complex system. The
  individual base elements of a system are first specified in great detail. These
  elements are then linked together to form larger subsystems, until a complete
  top-level system is formed. Emphasized coding and early testing, which can begin as
  soon as the first module has been specified. There is a risk of how the modules can be
  linked together to form a top-level system
- **RAII - Resource Acquisition Is Initialization**. Smart Pointer: constructor
  acquires, destructor releases. Smart Pointer is scope-based resource management. When
  a resource gets out of scope via normal execution or thrown exception the resource is
  deallocated automatically by the Smart Pointer destructor. RAII only works for
  resources acquired and released by stack-allocated objects where there is well-defined
  static object lifetime
- **OOP - Object-Oriented Programming**. OOP is like biological cells: messaging, state
  hiding, late binding. Object has well encapsulated structure (properties) and provides
  behavior (methods) through well defined interface. Abstraction, responsibilities and
  modularization are the keys to master complexity
- **FCoI - Favor Composition + Delegation over Inheritance**. Composition is black box
  reuse through an interface and promotes loose coupling. Inheritance is white box reuse
  through public/protected members
- **ADP - Acyclic Dependency Principle**. Circular dependencies should be
  avoided. Dependency Inversion Principle or creation of a new package with common
  components breaks the circular dependencies
- **LoD - Law of Demeter**. The Principle of Least Knowledge/Dependencies - don't talk
  to strangers, only talk to your immediate neighbors. LoD fosters Loose Coupling and
  Information Hiding

# SOLID principles

- **SRP - Single Responsibility Principle**. Software unit should have only one single
  and well defined responsibility, only one reason to change. High Cohesion fosters SRP
- **OCP - Open-Closed Principle**. Software unit should be open for extension
  (inheritance, Strategy or Decorator design patterns), but closed for modification
  (interface with multiple polymorphic implementations)
- **LSP - Liskov Substitution Principle**. Hierarchy is used to build specialized types
  from a more general type. Polymorphism means that one single interface provides access
  to objects of different types. Subtype must be completely substitutable for its
  supertype. Preconditions cannot be strengthened in a subtype. Postconditions cannot be
  weakened in a subtype. Supertype invariants must be preserved in a subtype
- **ISP - Interface Segregation Principle**. Segregate one broad single interface into a
  set of smaller and highly cohesive interfaces so other program components depend only
  on small cohesive interfaces instead of depending on a single broad interface, and
  other program components won't be required to implement all the functionality of the
  broad interface
- **DIP - Dependency Inversion Principle**. Avoid tight coupling between modules with
  the mediation of an abstraction (interface) layer. Each module should depend on an
  abstraction (interface), not other modules directly. The abstraction (interface)
  provides the behavior needed by the module through possibly multiple
  implementations. Common features should be consolidated in a shared abstractions
  exposed through interfaces. Dependency Inversion Principle fosters testability of
  components

# UNIX principles

- Make each program do one thing and do it well
- To do a new job build afresh rather than complicate old programs by adding new
  features
- Expect the output of every program to become the input to another program. Write
  programs to handle text streams, because text is a universal interface. Don't clutter
  the output with extraneous information. Don't insist for interactive input and allow
  for scripting
- Favor composability over monolithic design
- Design and build software to be tried early. Build prototype as soon as
  possible. Don't hesitate to throw away bad design and rebuild from scratch
- Use tools or even build tools for repetitive task automation

# Unix philosophy

- Modularity. Write simple parts connected by clean interfaces
- Clarity. Clarity is better than cleverness
- Composition. Design programms to be connected to other programs
- Separation. Separate policies from mechanisms. Separate interfaces from engines
- Simplicity. Design for simplicity. Add complexity only where you must
- Parsimony. Write a big program only when nothgin else will do
- Transparency. Design for visibility to make issue resolution easier
- Representation. Fold knowledge into data, so program logic can be simple and robust
- Silence. When a program has nothing surprising to say, it should say nothing
- Failure. When a program must fail, fail noisily as soon as possible
- Generation. Write programs to write programs when you can
- Optimization. Prototype before polishing. Get it working before you optimize it
- Extensibility. Design for the future, because it will be here sooner than you think

# 12-factor SaaS cloud application

1. **Codebase**. One codebase tracked in revision control, many deployments
    - Use revision control system (Git) to track changes to the codebase
    - Set up one repository per app/service
    - Single codebase is deployed into multiple environments (dev, test, staging,
      production) with different level of maturity/testing
1. **Dependencies**. Explicitly declare and isolate dependencies
    - Use dependency management system (Yarn)
    - Always explicitly define dependency versions (package.json)
    - Isolate locally installed dependencies from interference with system-wide packages
    - Only the language runtime and a dependency manager are required to run the
      app/service
    - Explicitly include (into Docker image) all system tools (curl, imagemagick) that
      app/service depends on
1. **Configuration**. Store configuration in the environment
    - Keep strict separation of the environment-specific configuration from the codebase
    - Do not store any credentials and secretes in the codebase
    - Store environment-specific configuration in the environment variables set up by
      IaC deployment scripts
1. **Backing services**. Treat backing services as attached resources accessible via URI
    - Most of the apps/services use database, queues, cache, email systems, cloud
      services (resources)
    - App/service can easily swap backing service by changing the resource URI provided
      by the environment-specific configuration without any codebase changes
1. **Build, release, run**. Strictly separate build and run stages
    - Codebase is transformed into a deployment through the below stages
    - Build stage transforms a source code repository (Git) into an executable artifact
      (Docker image). Fetch specific tag, download dependencies, compile an executable
      artifact
    - Release stage combines the environment-independent executable artifact with the
      environment-specific configuration. Every release is immutable and should be
      uniquely tagged. Any change must create a new release
    - Run stage launches the app/service in an environment
1. **Processes**. Execute the app as one or more stateless, share-nothing processes
    - Any data that needs to persist must be stored in a stateful backing service
    - Process memory and file system can be used only as a temporary cache
    - Every app/service process should be idempotent
1. **Port binding**. Export services via port binding + protocol
    - Avoid executing apps/services inside a web server container (Tomcat, Apache
      module)
    - App/service should be completely self-contained and does not rely on any web
      server execution environment
    - App/service should export HTTP/AMQP/Redis as a service (Restify.js) by binding to
      a port
    - In production a load balancer (NGINX) routes requests from a public-facing
      hostname to the port-bound app/service
1. **Concurrency**. Scale out via the process model
    - User first-class, share-nothing Unix processes/daemons (horizontal scalability)
      for each type of work load (HTTP requests, background workers, database)
    - App/service should rely on OS process manager (systemd)
1. **Disposability**. Maximize robustness with fast startup and graceful shutdown
    - App/service should be disposable: can be started on stopped at a moment's notice
      that facilitates fast elastic scaling and robust production deployments
    - App/service should minimize startup time
    - App/service should shut down gracefully on SIGTERM:
        - For HTTP cease listening, let current request to finish, and then exit
        - For AMPQ return current idempotent job to a queue
1. **Dev/prod parity**. Keep development, staging, and production as similar as possible
    - App/service delivery pipeline shout be completely automated and use CI/CD
    - Use the same Docker images in all environments (dev, stage, prod)
1. **Logs**. Treat logs as event streams
    - Instrumentalize app/service with logs to get insights, telemetry, and
      observability
    - Logs are the stream of time-ordered events collected in centralized log
      aggregation system (Elasticsearch)
    - App/serer should only emit all structured (JSON) logs to the STDOUT
    - Execution environment manages to augment and forward logs to the centralized log
      aggregation system (Elasticsearch) for introspection, real-time analysis, and
      alerting
1. **Admin processes**. Run admin/management task as one-off processes
    - IaC admin source code and dependencies should ship with the app/service source
      code to avoid sync issues

# Security by design principles

- **Information security in rest**
    - Confidentiality - ensure that only an authorized user has access to data
    - Integrity - ensure that data is not altered by an unauthorized user
    - Availability - ensure that data is available only to an authorized user
- **Information security in transit**. Alice sends a message to Bob
    - Confidentiality - only Bob can read the message
    - Integrity - Eve cannot alter the message
    - Authenticity - only Alice could have sent the message
- **Least privilege**. A subject should have the least amount of privilege (CPU/RAM
  quotas, file system/network access, data access permissions, business transaction
  limits, time-based constraints) explicitly granted to perform its business process
  with the objective to limit intentional or unintentional damage to data. The right
  should be granted just before performing the operation and should be immediately
  revoked on a completion or failure of the operation. The function of the subject (and
  not the identity) should control the assignment of rights. Example: if a user only
  needs to read a file, then he should not be granted permission to write the file
- **Establish secure defaults. Security baseline in terms of functionality**. Delivered
  out of the box functionality should be secure by default, and it should be up to the
  user to reduce security and increase risk if they are allowed. Example: user password
  expiration and complexity should be enabled by default, user might be allowed to
  simplify password management
- **Fail-safe defaults. Bottom line of user initial privileges**. Prefer explicitly
  granted access over access exclusion. By default a user do not have access to any
  resource until access to a resource has been granted explicitly, so on an operation
  failure the system security is not compromized
- **Fail securely**. When a system fails, it should fail to a state where the security
  of a system is not compromised. Automatically release resources, decrease privileges,
  and maybe logout from the account on operation failure
- **Defense in depth**. Multiple security controls at each architectural level that
  approach risk from different perspectives are better as it makes much more difficult
  to exploit vulnerabilities. Example: secure coding, explicit resource and privileges
  management, security tests, input data validation/sanitization, secure deployment,
  proactive application monitoring and auditing, continuous security and risk
  assessment. Example: administrative web interface should be protected a) by
  authentication, b) only accessible from internal network, c) with enabled audit
  logging
- **Complete mediation**. Every access to every resource must be checked for
  authentication and authorization via system-wide central point of access
  control. Subsequent accesses to the same resource should also be checked and not
  cached. Performance (caching) vs security (explicit check of every request) trade off
- **Separation of duties**. Do not grant multiple unrelated privileges to a single
  account. Require collaboration of multiple accounts to perform important operations
  securely in order to prevent fraud or error. Example: application administrators
  should not be super users of the application; an administrator should not be able to
  perform business operations on behalf of an application user
- **Separation of privilege**. Every security control should be based on more than a
  single condition in order to remove a single point of failure. Example: when approving
  a request validate that a) user status is active b) user is authorized to access the
  resource. Multi-factor authentication (something you know, you have, you are)
- **Economy of mechanism. Keep security simple**. Avoid complex approaches to security
  controls as it is much easier to spot functional defects and security flaws in simple
  designs and it is very difficult to identify problems in complex designs. Complexity
  does not add security
- **Open design. Avoid security by obscurity**. Security of a system should not be
  dependent on the secrecy of its design or implementation. Prefer well tested public
  security standards over homegrown hidden security controls. Keeping passwords in
  secret does not violate this principle as a password is not an algorithm. It is better
  to know the security level of standard security controls rather than not know at all
  the security level of homegrown not extensively tested security controls. Examples:
  OAuth 2.0. Linux source code is publicly available, yet when properly secured, Linux
  is hard secure operating system
- **Least common mechanism**. Mechanisms to access a resource should not be shared
  between multiple subjects to gain access to a resource. Example: provide different
  login pages for different types of users; if one of the login pages is compromized,
  other login pages are not impacted. Sharing the access from Internet to a web site
  between attackers and legit users gives place to DoS attack
- **Minimize attack surface area**. Asses risks introduced by a new feature, then adapt
  feature design and define security controls to minimize the attack surface
  area. Example: a search function of an online help feature may be vulnerable to a SQL
  injection attack; expose the feature only to authorized users, use data validation and
  escaping, or eliminate search function from the feature design by providing a better
  structured user interface to reduce the attack surface area
- **Psychological acceptability**. Security controls should not make resources more
  difficult to access than if the security controls were not present. The more user
  friendly the interface is, the less likely a user will make a mistake when configuring
  and using a security control and expose the system to security breaches. Error
  messages should be descriptive and actionable but not convey unnecessary design
  details that may be used to compromise the system
- **Do not trust services**. Do not assume that third party partners have the same or
  higher security policies then yours. Put necessary security controls on third party
  services
- **Fix security issues correctly**. Once a security issue has been identified, a)
  understand the root cause of it and determine the scope of it b) develop a fix for it
  c) implement required tests for it d) add monitoring and auditing of it
- **Weakest link**. A chain is only as strong as its weakest link. Focus on the weakest
  component in a system

## Object-oriented design principles (message-passing paradigm)

- **Uniform metaphor**. A system should be designed around a powerful metaphor that can
  be uniformly applied in all areas. Large applications are viewed in the same way as
  the fundamental units from which the system is built. Examples: lists/functions in
  Scheme, relations/queries in SQL, objects/messages in Smalltalk
- **Good design**. A system should be build with a minimum set of unchangeable
  parts. The unchangeable parts should be as general as possible. All parts of a system
  should be held in a uniform framework with a uniform interface
- **Modulatiry**. No component in a system should depend on the internal details of any
  other component. Component interdependencies in a system should be minimized
- **Factoring via inheritance**. Each component in a system should be defined only in
  one place. Use inheritance to provide well-factored design and avoid
  repetition. Inheritance propagates default behavior through increasingly more
  specific hierarchy of classes
- **Classification**. Group similar components into class hierarchy to reduce
  complexity. Class abstraction describes a) message protocol that the object recognizes
  (explicit communication) b) internal state of the object (implicit
  communication). Object is a concrete instance of a class
- **Objects**. Use object-oriented model for storage. Objects are created by sending a
  message to their classes. Objects are automatically disposed when they are not needed
  any more and automatically reclaimed by a GC
    - **Protocol** (explicit communication) is a set of messages that the object can
      respond
    - **State** (implicit communication) defines object-specific response to a
      message. All access to the internal state of an object is exclusively performed
      via message protocol (message-passing)
- **Messages**. Use message-oriented model for processing. Computing should be intrinsic
  capability of objects that can be uniformly invoked by sending
  messages. Message-passing metaphor decouples the intent (message) from actual
  execution (method)
  - **Message** = operation + arguments
- **Polymorphism**. A system should specify only behavior (via message protocol) of
  objects, not their representation

## Philosophy of clarity in programming

- Most programs are more complex than thay need to be because of bad design
- Data structures, and not algorithms, are central to programming
- Optimize only after the implementation when a bottleneck is found
- Use consistent identificator names with minimum length, maximum information in a
  context

## Description of software feature

### User story (high level, user perspective)

**User story** describes in an informal language a software feature from the end user
perspective

```
As a <role, user, who>
I want <capability, goal, what>,
so that <benefit, reason, why>
```

### Gherkin feature with scenarios (detailed BDD, test perspective)

**Gherkin feature with scenarios** specifies expected software behavior in a logical
language that a user can understand

```gherkin
Feature: <feature name> (collection of scenarios)
    <feature description>
    Scenario: <scenario> (colleciton of steps)
        Given: <precondition>
        When: <action>
        Then: <result>
```

### Use case (actor interaction with a system)

**Use case** describes in text + diagram interaction between an actor (human or external
system) and a system to achieve a goal

```
Title: <active verb one-liner>
Actor: <primary actory>
Goal: <goal in context>
Precondition: <initial system state>
Trigger: <actor action>
Success: <main success scenario>
Extensions: <alternative scenarios and enhancements>
```
