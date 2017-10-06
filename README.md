# [Kotlin](https://kotlinlang.org/) Software Design Patterns Code Examples

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

- **Dependency Injection**

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
instance<br/>
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
`Vendor`=`Implementation` has two implementations `XiaomiVendoer` and `NokiaVendor`. The `Device` implementations accept
`Vendor` implementation. The `Device::switchOn()` method delegates to the `Vendor::support(Device)` method

- [**Composite**](src/main/kotlin/org/vld/sdp/structural/Composite.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/CompositeTest.kt)<br/>
**What**. Composite treats individual objects and composition of objects uniformly. Composes objects into tree
structures to represent part-whole hierarchies<br/>
**How**. The `Leaf` and the `Composite` classes implement the `Component` interface. The `Leaf` class implements the
request directly while the `Composite` class forwards recursively the request to composite's children<br/>
**Example**. The `Expression`=`Component` is a uniform `Component` interface. The `Operand`=`Leaf` implements the
request directly by returning the operand value. The `Operation`=`Composite` implements the request recustively by
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
accept the `Coffe` instance to delegate to

- [**Facade**](src/main/kotlin/org/vld/sdp/structural/Facade.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/FacadeTest.kt)<br/>
**What**. Facade defines a higher-level simplified interface that makes a system/library easier to use. Facade hides the
complexities of a larger system with dependencies and provides a simpler interface to the client<br/>
**How**. Client works only with the `Facade` highter-level simplified interface to interact with the larger system<br/>
**Example**. The larger system `Desktop` implements the `Computer`=`Facade` interface which is used by the client. The
`Desktop` manages internally all the complexities involved with the subsystems `Cpu`, `Ram` and `Ssd`

- [**Flyweight**](src/main/kotlin/org/vld/sdp/structural/Flyweight.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/FlyweightTest.kt)<br/>
**What**. Flyweight uses sharing to support a large number of similar objects efficiently<br/>
**How**. Shares the `Invariant`/intrinsic object state in an external data structure. When a new object is created the
`FlyweightFactory` provides the cached `Invariant`/intrinsic object state and allows the `Variant`/extrinsic object
state to be set through the `Flyweight` interface<br/>
**Example**. The `GlyphCode`=`Invariant` repserents the intrinsic glyph state (code) that can be cached and shared
between glyphs. The `GlyphFlyweight`=`Invariant`+`Variant` class implements the `Glyph`=`Flyweight` interface that
allows extrinsic glyph state (position) motification. The `GlyphFactory`=`FlyweightFactory` caches and shares
efficiently the `GlyphCode` instances

- [**Proxy**](src/main/kotlin/org/vld/sdp/structural/Proxy.kt)
[(usage)](src/test/kotlin/org/vld/sdp/structural/ProxyTest.kt)<br/>
**What**. Proxy provides a placeholder/wrapper for another object for access control, request validation, response
caching, etc.<br/>
**How**. The real object and the `Proxy` implement the same `Subject` interface, so the client cannot distinguish
between the real object and the `Proxy`. The `Proxy` uses delegation to the real object</br>
**Example**. The real `Account` object implements the `Payment`=`Subject` interface without any balance/amount
valiadtions. The `PaymentProxy`=`Proxy` implements the `Payment` interface with the balance/amount validation. Client
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
**What**. Command encapsulates an action with the request parameters as an function/object. Allows action/request
queueing, logging and undoable operations<br/>
**How**. The `Command` object stores the request parameters and delegates the request to the `Receiver`. The `Invoker`
object uses the `Command` interface and provides request queueing, logging and undoable operation functionality<br/>
**Example**. The `cookStarter()`, `cookMainCourse()` and `cookDessert()` functions `Order`=`Command`=`Receiver` objects
by storing the request arguments in closure. The `Waiter`=`Invoker` queues the `Order`s and serves the `Order`s by using
the `Order` interface

- **Interpreter**

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
**How**. The `State` inteface implementation provides the request handling functionality and sets the next
`State`. `State` implements a state machine where each individual state is a derived class of the `State` interface and
each transition is defined in state interface method invocation<br/>
**Example**. The `VendingMachine` internal state goes through the `ShowProducts`, `SelectProduct`, `DepositMoney` and
`DeliverPoduct` `State`s by invoking the `VendingMachine::proceed()` method which deletates to the current
`State::handleRequest()` method which handles the request and sets the next `VendingMachine` `State`

- [**Strategy**](src/main/kotlin/org/vld/sdp/behavioral/Stragegy.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/StragegyTest.kt) defines a family of interchangeable at run-time
algorithms

- [**Template Method**](src/main/kotlin/org/vld/sdp/behavioral/TemplateMethod.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/TemplateMethodTest.kt) defines the skeleton of an algorithm (invariant)
in one operation deferring some steps (variable) to subclasses (inversion of control) and preserving the overall
structure of the algorithm

- [**Visitor**](src/main/kotlin/org/vld/sdp/behavioral/Visitor.kt)
[(usage)](src/test/kotlin/org/vld/sdp/behavioral/VisitorTest.kt) separates an algorithm from an object structure on
which the algorithm operates. Allows to add new operations through visitors to the existent object structure known as
elements without modifying the structure. Visitor implements double dispatch based on concrete `Visitor` and concrete
`Element`
