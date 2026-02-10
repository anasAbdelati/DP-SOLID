# Visitor Pattern

### Purpose
The Visitor pattern is a way of separating an **algorithm** from the **object structure** on which it operates. It allows you to add new operations to a collection of disparate objects without modifying their source code.

### What it Solves
1. **The Responsibility Dilemma:** It prevents "bloating" your data classes with unrelated logic. Instead of an `Invoice` class knowing how to generate PDFs, JSON, and XML, the `Invoice` just provides a "hook," and the `Visitor` handles the logic.
2. **Double Dispatch:** It solves the problem where a language (like Java) can't decide which method to run based on two types at once. The `accept()` method "handshakes" with the visitor to ensure the right logic runs for the right type.
3. **Open/Closed to the Extreme:** You can add a 10th export format or a 10th analysis tool to your system just by creating a new `Visitor` class. The existing `Element` classes remain "closed" for modification.

### Visitor vs. Decorator (The Difference)
* **Decorator:** Wraps a *single* object to "decorate" it with extra features (like adding a border to a window). The interface stays the same.
* **Visitor:** "Visits" an *entire tree* of different types of objects to perform a specific task (like calculating total weight of all parts in a machine). It often changes the output type.

### Real-World Analogy
Think of a **Tax Auditor (The Visitor)** visiting a **Company (The Structure)**.
The Company has different departments: HR, Tech, and Sales. The Auditor goes into each department. The departments don't change how they work; they just "accept" the Auditor and show them their books. The Auditor performs the "Audit" operation on each different department according to its specific rules.

### When to use it?
* When you have a structure containing many objects of different interfaces, and you want to perform operations on these objects that depend on their concrete classes.
* When you need to perform many unrelated operations on objects in an aggregate structure.
* When the object structure rarely changes, but you frequently want to define new operations over the structure.

### The Problematic
Imagine a `Bank`. It has `SavingsAccount` and `LoanAccount`. You want to calculate the "Interest" for the year. Then, you want to calculate the "Health Score." If you put `calculateInterest()` and `calculateHealth()` inside the account classes, every time the bank changes its interest rules, you have to risk breaking the core Account logic.

### The Solution
1. **Element Interface:** Every account has an `accept(Visitor v)` method.
2. **Visitor Interface:** Defines `visit(SavingsAccount)` and `visit(LoanAccount)`.
3. **Concrete Visitors:** One for `InterestCalculator`, one for `AuditReporter`.