# Facade Pattern

### Purpose
The Facade pattern provides a simplified interface to a library, a framework, or any other complex set of classes.

### What it Solves
* **High Cognitive Load:** Instead of a developer needing to learn 10 different internal APIs to perform one task, they only need to learn one.
* **Tight Coupling:** It prevents the client code from becoming dependent on the internal "guts" of a third-party library or a complex subsystem.
* **Entry Point Management:** In large systems, it defines a clear "front door" for specific functionality.

### Facade vs. Proxy (The Difference)
* **Facade:** Simplifies a **complex interface** or multiple interfaces. It creates a *new* interface.
* **Proxy:** Represents a **single object** and usually has the *exact same* interface as that object. It’s about access control, not simplification.

[Image of Facade design pattern UML diagram]

### Real-World Analogy
Think of a **Waiter in a Restaurant**.
The kitchen is a complex subsystem with chefs, dishwashers, and station managers. You don't go into the kitchen to talk to the grill chef. You talk to the **Waiter (The Facade)**. You give them a simple order, and they coordinate the chaos in the back to bring you a meal.

### When to use it?
* When you need to provide a simple, limited interface to a complex subsystem.
* When you want to layer your subsystems. Use a facade to define an entry point to each level to reduce dependencies.
* When using a third-party library that is overly complex or poorly designed.

### Architecture Context
* **System Archi:** This is the logic behind **API Gateways** in Microservices. Instead of a mobile app calling the "Order Service," "Shipping Service," and "Inventory Service" individually, it calls the Gateway Facade.
* **Database ACID:** Think of a **Persistence Facade**. It hides the complexity of `EntityManager`, `TransactionManagers`, and `ConnectionPools`. The developer just calls `save(User)`, and the facade handles the **Atomic** start, flush, and commit.

### The Problematic
Imagine a **Home Theater**. To watch a movie, you have to:
1. Turn on the Dimmer and set it to 10%.
2. Turn on the Projector.
3. Set Projector input to "HDMI".
4. Turn on the Sound System.
5. Set Volume to 50.
6. Wake up the Streaming Player.
   If the client (User) has to do this every time, they will hate the system. If they forget to set the input, the "Movie" fails.

### The Solution
1. **Subsystem Classes:** The actual hardware (Lights, Projector, Sound).
2. **Facade:** A `SmartHomeFacade` with a single method: `watchMovie()`.
3. **Client:** Just presses "Watch Movie".