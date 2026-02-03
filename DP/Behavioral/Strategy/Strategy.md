# Strategy Pattern

### Purpose
The Strategy pattern is designed to encapsulate a "family" of algorithms and make them interchangeable at runtime. It separates the **behavior** (the algorithm) from the **context** (the object that uses it).

### What it Solves
1. **Conditional Explosion:** It eliminates massive `if/else` or `switch-case` blocks that check for "modes" or "types."
2. **Tight Coupling:** It prevents the client (Context) from being hard-coded to a specific implementation, which makes unit testing much easier.
3. **The Open/Closed Violation:** It allows you to add a new algorithm (like a new payment method or routing logic) by simply adding a new class, without touching the existing core logic.
4. **Code Duplication:** If different classes need the same logic, you can reuse the Strategy object instead of copy-pasting code.

### Real-World Analogy
Think of a **Power Socket**. The socket is the **Context**. The **Strategy** is the plug.
The socket doesn't care if you plug in a Lamp, a Laptop, or a Phone Charger. As long as the plug follows the "Interface" (the shape of the pins), the socket provides power. You can swap strategies (plugs) instantly without rewiring your house.

### When to use it?
* When you have many variations of an algorithm.
* When you need to choose a behavior at runtime based on user input.
* When you want to hide complex, algorithm-specific data structures from the client.

### The Problematic
Imagine a Navigation App. It calculates a route from Point A to Point B.
Initially, it only supports **Driving**. Later, you want to add **Walking**, **Public Transport**, and **Cycling**.
Without the Strategy pattern, your `RouteBuilder` class would be a mess of `if (mode == WALKING) { ... } else if ...`. Every time you add a new mode, you risk breaking the existing ones.

### The Solution
1. Create a `RouteStrategy` interface with a `buildRoute()` method.
2. Implement specific classes: `DrivingStrategy`, `WalkingStrategy`, etc.
3. The `Navigator` class holds a reference to the interface and calls `buildRoute()` without caring which mode is currently active.