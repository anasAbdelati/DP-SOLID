# Mediator Pattern

### Purpose
The Mediator pattern defines an object that encapsulates how a set of objects interact. It promotes loose coupling by keeping objects from referring to each other explicitly.

### What it Solves
1. **The "Everything-Knows-Everything" Problem:** Without a mediator, every object needs a reference to every other object it interacts with, creating a tangled web of dependencies.
2. **Hard Maintenance:** If you change one class, you might break 5 others that were tightly coupled to it.
3. **Complex Coordination:** It centralizes the logic for complex interactions (e.g., "If Button A is clicked, disable Textbox B and clear Checkbox C").

### Real-World Analogy
Think of an **Airport Control Tower**.
* The **Planes** are the objects.
* The **Control Tower** is the **Mediator**.
  Planes do not talk to each other directly to decide who lands first. If they did, it would be chaos. Instead, every Pilot talks only to the Tower. The Tower coordinates the landing slots and safety, keeping the Pilots "decoupled" from each other’s complex maneuvers.

### When to use it?
* When a set of objects communicate in well-defined but complex ways.
* When you want to reuse an object, but it’s too tied to other objects.
* In UI development, to coordinate many widgets (buttons, lists, inputs) in a single window.

### The Problematic
Imagine a **Chat Room**. If User A wants to send a message, they shouldn't have to hold a list of every other user (`UserB`, `UserC`, `UserD`) and call `receive()` on each one. If a new user joins, User A shouldn't have to update their internal list.

### The Solution
1. Create a `ChatMediator` interface.
2. Users only hold a reference to the `Mediator`.
3. When a User sends a message, they give it to the `Mediator`.
4. The `Mediator` handles the logic of who should receive it.