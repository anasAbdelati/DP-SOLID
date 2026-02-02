# O: Open/Closed Principle (OCP)

### Definition
"Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification."

### Why it is important
In professional environments, once a piece of code is tested and deployed, you want to avoid touching it to add new features. If you modify the original class:
1. **You risk breaking existing logic:** A small change in an `if/else` block can cause unexpected bugs.
2. **You force re-testing:** Every change requires the entire class to be re-validated.
3. **Rigidity:** The code becomes harder to maintain as more "special cases" are added over time.

### The Problematic (The "Bad" Code)
We have a `DiscountCalculator` class. Initially, it only handles "VIP" discounts. When we want to add "Seasonal" or "Flash Sale" discounts, we are forced to go back into the `calculate` method and add more `if/else` or `switch` statements. This means the class is **not closed for modification**.

### The Solution
We use an **Interface** (the "extension").
1. We create a `DiscountStrategy` interface.
2. For every new discount type, we create a **new class** that implements this interface.
3. The main calculator now works with the interface, meaning we can add 100 new discount types without ever changing the calculator's code again.