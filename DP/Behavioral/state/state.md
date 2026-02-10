# State Pattern

### Purpose
The State pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class.

### What it Solves
1. **The "If-Else" Hell:** It replaces massive, complex conditional statements that check for the current state of an object before performing an action.
2. **State Transition Logic:** It localizes state-specific behavior into separate classes, making transitions explicit rather than hidden in messy logic.
3. **Organized Evolution:** Adding a new state (e.g., adding a "Suspended" state to a User account) only requires adding one new class, rather than hunting down every `switch` statement in your project.

### Real-World Analogy
Think of a **Vending Machine**.
* If it has **No Money**, pressing the "Select Product" button does nothing.
* If it has **Money Inserted**, pressing the same button dispenses a product.
* If it is **Out of Stock**, the button might trigger an error light.
  The "Press Button" action is the same, but the **Behavior** changes completely based on the machine's internal **State**.

### When to use it?
* When an object’s behavior depends on its state, and it must change its behavior at runtime depending on that state.
* When you find yourself writing methods that start with a giant `switch` or `if/else` based on a `status` variable.

### The Problematic
Imagine a `Document` in a workflow. It can be in `Draft`, `Moderation`, or `Published` states.
Without the State pattern, your `Document` class would have a `publish()` method full of logic: "If I am in Draft, move to Moderation. If I am in Moderation, move to Published. If I am already Published, do nothing."

### The Solution
1. Create a `State` interface that defines the allowed actions (`publish`, `render`, etc.).
2. Create concrete classes: `DraftState`, `ModerationState`, `PublishedState`.
3. The `Document` (Context) simply delegates the work to its current state object: `currentState.publish()`.