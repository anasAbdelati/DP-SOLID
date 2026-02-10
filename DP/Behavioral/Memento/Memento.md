# Memento Pattern

### Purpose
The Memento pattern provides the ability to restore an object to its previous state (undo via rollback) without revealing the details of its implementation (encapsulation).

### What it Solves
* **Encapsulation Violation:** It allows you to save an object's state without making all its private fields public. Only the "Originator" can see its own state.
* **The Snapshot Dilemma:** It separates the "state storage" from the "business logic." The object doesn't need to know how to manage its own history.
* **Rollback Mechanics:** It provides a clean way to implement "Undo" or "Revert" operations in complex systems.

### Memento vs. State (The Difference)
* **State:** Changes the object's **behavior** based on its current condition (e.g., a "VendingMachine" behaves differently if it is "OutOfStock").
* **Memento:** Captures a **snapshot** of the object at a point in time to return to it later. It’s a "Time Machine," not a "Mood Swing."

### Real-World Analogy
Think of a **Video Game Quicksave**.
You are about to fight a Boss. You hit "Save" (The Memento). The game engine captures your health, ammo, and position (The State). You fight the Boss and lose. You hit "Load" (The Caretaker). The game restores your character to the exact moment before the fight started. The character itself doesn't "know" how to save to the hard drive; it just provides the data.

### When to use it?
* When you need to implement Undo/Redo functionality.
* When a direct "Getter/Setter" approach to saving state would expose private internal fields that should stay hidden.
* When you need to take "Checkpoints" in a multi-step transaction or workflow.

### Architecture Context
* **System Archi:** This is the logic behind **Distributed Transactions** and **Sagas**. If a microservice fails halfway through a process, the system uses Mementos (compensating transactions) to revert the local databases to their original state.
* **Database ACID:** Directly relates to **Durability** and the **Write-Ahead Log (WAL)**. Before a DB changes a page in memory, it records the previous state. If the system crashes, it uses those logs (Mementos) to recover.

### The Problematic
Imagine a **Credit Scoring Engine**. It calculates a user's creditworthiness based on 50 variables. A Senior Analyst wants to "experiment" by changing variables (income, debt-to-ratio) to see the result. If they don't like the new score, they want to hit "Revert." If you just copy the object, you expose all those 50 private variables to the UI layer, breaking encapsulation.

### The Solution
1. **Originator:** The class whose state we want to save (The CreditEngine).
2. **Memento:** A "dumb" object that holds the state. It's usually an inner class or has restricted access.
3. **Caretaker:** The object that keeps track of the Mementos (The History/Undo Stack).