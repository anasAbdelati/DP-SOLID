# D: Dependency Inversion Principle (DIP)

### Definition
1. "High-level modules should not depend on low-level modules. Both should depend on abstractions."
2. "Abstractions should not depend on details. Details should depend on abstractions."

### Why it is important
DIP is the ultimate cure for **Tight Coupling**.
1. **Flexibility:** You can switch a database, a cache system, or an email provider without touching your core Business Logic.
2. **Testability:** You can easily "Mock" a database or an API for unit testing.
3. [cite_start]**Architecture:** It forces you to think about "Interfaces" (What the system does) before "Implementation" (How it does it). [cite: 598, 599]

### The Problematic (The "Bad" Code)
We have a `PasswordReminder` class. Inside its constructor, it creates a `new MySQLConnection()`.
This is a **Hard-Dependency**. The high-level reminder is "stuck" to the low-level MySQL implementation. [cite_start]If you want to use **PostgreSQL** or **InterSystems IRIS**, you have to modify the `PasswordReminder` class. [cite: 47, 487, 490]

### The Solution
We "invert" the dependency.
1. Create a `DBConnection` interface.
2. Make `MySQLConnection` implement that interface.
3. The `PasswordReminder` now asks for a `DBConnection` in its constructor (Dependency Injection).
4. [cite_start]Now, the `PasswordReminder` doesn't care which DB you use; it only cares that it gets a connection that works. [cite: 53, 54, 55]