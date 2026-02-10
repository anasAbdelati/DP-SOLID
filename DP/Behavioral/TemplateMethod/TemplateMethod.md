# Template Method Pattern

### Purpose
The Template Method pattern defines the skeleton of an algorithm in a base class but lets subclasses override specific steps of the algorithm without changing its overall structure.

### What it Solves
1. **Code Duplication:** When multiple classes follow the same multi-step process with only minor variations, this pattern pulls the common steps into a single parent class.
2. **Standardization:** It enforces a specific sequence of steps. Subclasses cannot change the "order" of the algorithm, only the "detail" of individual steps.
3. **The Hollywood Principle:** "Don't call us, we'll call you." The parent class controls the flow and calls the child class's methods when needed.

### Real-World Analogy
Think of **Building a House**.
The general process is always: 1. Build Foundation, 2. Build Pillars, 3. Add Windows/Doors.
* A **Glass House** and a **Wooden House** both follow this exact template.
* You cannot add windows before the foundation.
* The "Template" (the architectural blueprint) defines the order, while the specific "Material" (Glass or Wood) is decided by the specific builder.

### When to use it?
* When you have a fixed sequence of steps for an algorithm.
* When you want to provide "hooks" (optional steps) that subclasses can implement if they want.
* In Frameworks (like **Spring** or **Angular**) where the framework handles the lifecycle (OnInit, OnDestroy) and you just fill in the logic.

### The Problematic
Imagine a data processing system that reads files (CSV or PDF), parses them, and saves them to a Database.
Without this pattern, the `CSVProcessor` and `PDFProcessor` classes would both have identical code for `openFile()` and `saveToDatabase()`. If you change the database logic, you have to update it in every single processor class.

### The Solution
1. Create an abstract class `DataProcessor` with a `final` method called `process()`.
2. This `process()` method calls `readData()`, `parseData()`, and `saveData()`.
3. `readData` and `saveData` are implemented in the base class (common logic).
4. `parseData` is abstract, forcing subclasses to provide their own specific implementation.