* Adapter Design pattern - (SDP)

It is useful to connect two class with different interface.
The adapter pattern is typically used when we have an existing class that need to be reused but it's interface doesn't match the one expected by the client.

Ex- Integrating new payment gateway, multiple player of music

Forward:
1. For multiple third party make Universal Adapter with type as Object.

* Observer Design pattern - (BDP)

It is useful to notify list of observers about any state change, facilitating a publish-subscribe model.
Needed - observer interface and subject interface.

Ex - notify user for publish latest news, update temperature to connected displays.

* Strategy design pattern -  (BDP)

Define a family of algorithms, encapsulate each one as a separate class, and make them interchangeable.

The pattern enables a client to choose an algorithm at runtime from the available strategies without modifying
the context in which they are used. This promotes flexibility and makes it easy to add new algorithms or
modify existing ones without altering the client code.

* Singleton Design pattern - (CDP)

Ensures a class has only one instance and provides a global point of access to that instance.
This is useful when exactly one instance of a class is required to coordinate actions throughout the system.

Eg- payment Gateway manager

* Factory Design Pattern  -  (CDP)

Instead of directly instantiating objects with the new keyword, the factory pattern delegates
the responsibility to a Factory Class.

provides an interface for creating objects,
but allows subclasses or specific classes to alter the type of objects that will be created.

This promotes loose coupling by reducing dependencies between the
client code and the concrete classes it needs to instantiate.

* Builder Design Pattern - (CDP)

1. allows for the step-by-step creation of complex objects.
2. It provides a clear and flexible way to construct objects, especially when they have many
optional parameters or require multiple steps for initialization.
3. The Builder pattern promotes immutability, as it can be designed so that once an object is built,
it cannot be modified.

Eg.Transaction has some optional and some required parameter and once created it should not get modified.

* Decorator Design Pattern - (SDP)

1. Allows behavior to be added to individual objects, either statically or dynamically,
without affecting the behavior of other objects from the same class.

Ex - Burger pizza

* Composite Design Pattern - (SDP)
allows you to compose objects into tree-like structures to represent part-whole hierarchies.

* Proxy Design Pattern - (SDP)

Provides object to control access to another object.
It acts as an intermediary between the client and the actual object,
allowing for additional functionality (like lazy initialization, access control, logging, etc.)
to be added without modifying the actual object.

* Iterator Desing Pattern  - (BDP)

provides a way to access eleemnt of a collection sequentially without exposing the
underlying representation of the collection.