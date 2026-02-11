# Abstract Factory Pattern

### Purpose
The Abstract Factory pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes.

### What it Solves
* **Dependency Mismatch:** It prevents the mistake of mixing "Windows" buttons with "Mac" scrollbars. It enforces consistency across a suite of products.
* **Concrete Coupling:** The client code never touches the `new` keyword for specific classes. It only knows about the abstract interfaces.
* **Constraint Enforcement:** It centralizes the logic for "what goes with what," making it easy to swap an entire visual or functional theme at once.

### Abstract Factory vs. Factory Method (The Difference)
* **Factory Method:** Focuses on creating **one** product. It uses inheritance (subclasses override the method).
* **Abstract Factory:** Focuses on creating a **family** of products. It uses composition (the client is "injected" with a factory object).

### Real-World Analogy
Think of a **Furniture Store (IKEA vs. Luxury Italian)**.
You want to furnish a room. If you choose the **IKEA Factory**, you get a Lack table and a Poäng chair. They fit together in style and price. If you choose the **Luxury Factory**, you get a marble table and a leather chair. The Abstract Factory ensures you don't accidentally get a marble table with a cheap plastic chair—it maintains the "Style" of the room.

### When to use it?
* When a system should be independent of how its products are created, composed, and represented.
* When a system should be configured with one of multiple families of products.
* When a family of related product objects is designed to be used together, and you need to enforce this constraint.

### Architecture Context
* **System Archi:** Used heavily in **Cross-Platform UI Frameworks** (like Qt or early Java AWT). The code asks for a "Button," and the Abstract Factory decides whether to produce a `WindowsButton` or a `LinuxButton` based on the OS.
* **Database ACID:** Think of **Multi-Dialect Persistence**. A `MySQLFactory` produces `MySQLConnection`, `MySQLCommand`, and `MySQLTransaction`. This ensures that your transaction management is compatible with your connection type, maintaining **Consistency** and **Durability**.

### The Problematic
Imagine a **Phone Store**. You want to assemble a "Starter Kit" for a customer.
In the **Bad Code**, you have a messy list of items. If the customer wants an "Apple Kit," the developer has to manually remember to create an `IPhone`, an `AppleWatch`, and a `LightningCable`. If they accidentally write `new SamsungPhone()`, the kit is broken. The "Logic" is scattered across the app.

### The Solution
1. **Abstract Products:** Interfaces for `Phone`, `Watch`.
2. **Concrete Products:** `IPhone`, `Galaxy`, `AppleWatch`, `GalaxyWatch`.
3. **Abstract Factory:** Interface `EcosystemFactory` (defines `createPhone()`, `createWatch()`).
4. **Concrete Factories:** `AppleFactory`, `SamsungFactory`.