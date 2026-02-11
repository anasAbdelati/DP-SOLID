# Factory Method Pattern

### Purpose
The Factory Method pattern defines an interface for creating an object, but lets subclasses decide which class to instantiate. It lets a class defer instantiation to subclasses.

### What it Solves
* **Tight Coupling:** It prevents your code from being hardcoded to concrete classes. You depend on an interface instead of a specific implementation.
* **The "New" Keyword Problem:** Scattering `new MyClass()` everywhere makes it impossible to swap implementations later without changing code in a hundred places.
* **Code Duplication:** It centralizes the instantiation logic, especially if creating the object requires complex setup or configuration.

### Factory Method vs. Abstract Factory (The Difference)
* **Factory Method:** Uses **Inheritance** and focus on creating **one** type of product.
* **Abstract Factory:** Uses **Composition** and focuses on creating **families** of related products (e.g., Mac buttons + Mac windows).

### Real-World Analogy
Think of a **Brand Name Franchise (e.g., McDonald's)**.
The "McDonald's Corporate" (The Creator) defines the menu and the process. However, the **Individual Franchise** (The Concrete Creator) is the one actually "instantiating" the burger. A franchise in India might create a `VeggieBurger`, while one in the US creates a `BeefBurger`. The customer (The Client) just asks for a "Burger" and doesn't care about the specific kitchen logic used to make it.

### When to use it?
* When a class can't anticipate the class of objects it must create.
* When a class wants its subclasses to specify the objects it creates.
* When you want to provide library users with a way to extend its internal components.

### Architecture Context
* **System Archi:** This is how **Dependency Injection (DI)** works under the hood. Frameworks like Spring use factories to instantiate your Beans based on configuration files or annotations.
* **Database ACID:** Think of a **Connection Factory**. Depending on your configuration, the factory might give you a `MySQLConnection` or an `OracleConnection`. Your business logic just calls `connection.commit()`, fulfilling the **Atomicity** requirement without knowing which DB engine is running.

### The Problematic
Imagine a **Logistics Management** system. Initially, you only have `Truck` transport. Your code is full of `new Truck()`. Suddenly, the company goes global and needs `Ship` transport. You now have to go through your entire codebase, find every `Truck` instantiation, and add an `if/else` block to handle `Ship`.

### The Solution
1. **Product Interface:** `Transport` (defines `deliver()`).
2. **Concrete Products:** `Truck`, `Ship`.
3. **Creator Class:** `Logistics` (defines the abstract `createTransport()` method).
4. **Concrete Creators:** `RoadLogistics`, `SeaLogistics`.