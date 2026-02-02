# I: Interface Segregation Principle (ISP)

### Definition
"Clients should not be forced to depend upon interfaces that they do not use."

### Why it is important
This principle targets the problem of **"Fat Interfaces."** 1. **Reduces Waste:** You avoid writing "empty" methods (throwing exceptions or doing nothing) just to satisfy a compiler.
2. **Decoupling:** If you change a method in a giant interface, you force every single class implementing that interface to re-compile, even if they don't use that method.
3. **Clarity:** Smaller, specialized interfaces act as better documentation for what a class actually does.

### The Problematic (The "Bad" Code)
We have a `SmartDevice` interface with methods for `print()`, `fax()`, and `scan()`.
If we create a `BasicPrinter` class, it is forced to implement `fax()` and `scan()` even though it physically cannot perform those tasks. This creates "Dead Code" and a misleading API.

### The Solution
We split the "Fat" interface into three specific interfaces: `Printer`, `Scanner`, and `Fax`.
1. A simple printer only implements `Printer`.
2. An All-in-One machine can implement all three.
3. This respects the "Contract" because a class only promises what it can actually deliver.