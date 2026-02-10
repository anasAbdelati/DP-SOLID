# Bridge Pattern

### Purpose
The Bridge pattern decouples an abstraction from its implementation so that the two can vary independently. It uses composition instead of inheritance to avoid a "Class Explosion."

### What it Solves
* **The Cartesian Product Problem:** If you have 3 types of Remotes and 3 types of TVs, inheritance forces you to create 9 classes (SonyRemoteForSonyTV, SamsungRemoteForSonyTV, etc.). With a Bridge, you only need 3 + 3 = 6 classes.
* **Tight Coupling:** It prevents a change in the implementation (e.g., changing a Database driver) from requiring a re-compilation of the high-level logic (e.g., the User Interface).
* **Static Binding:** Inheritance binds an implementation at compile-time. The Bridge allows you to switch implementations at runtime.

### Bridge vs. Adapter (The Difference)
* **Adapter:** A "Rescue" pattern. It makes **existing** incompatible classes work together.
* **Bridge:** A "Planning" pattern. It is used **up-front** to separate a high-level concept from its platform-dependent details.



### Real-World Analogy
Think of a **Switch and a Lightbulb**.
The **Switch** is the "Abstraction" (it only knows how to turn 'On' or 'Off'). The **Lightbulb** is the "Implementation" (it could be LED, Incandescent, or Neon). You don't buy a "LED-Specific Switch." The Switch and the Lightbulb are connected by a socket (The Bridge). You can change the bulb to a different brand or technology without replacing the switch on your wall.

### When to use it?
* When you want to avoid a permanent binding between an abstraction and its implementation.
* When both the abstractions and their implementations should be extensible by subclassing.
* When changes in the implementation of an abstraction should have no impact on clients (no re-compilation).

### Architecture Context
* **System Archi:** This is how **Operating Systems** handle Device Drivers. The OS provides a high-level "Print" command (Abstraction). Each printer manufacturer provides a "Driver" (Implementation). The OS doesn't care how the printer works internally.
* **Database ACID:** Think of **Spring Data JPA**. Your `UserRepository` is the Abstraction. Whether it's talking to a MySQL, PostgreSQL, or H2 database (the Implementation) is bridged at runtime via the Dialect.

### The Problematic
Imagine a **Payment System**. You have different **Payment Types** (Card, Crypto) and different **Payment Providers** (Stripe, PayPal).
If you use inheritance, you get: `StripeCardPayment`, `StripeCryptoPayment`, `PayPalCardPayment`, `PayPalCryptoPayment`.
If you add a third provider (Square), you must create 2 new classes. If you add a third payment type (Bank Transfer), you must create 3 more. This is an exponential nightmare.

### The Solution
1. **Abstraction:** High-level logic (e.g., `Payment`). It holds a reference to the implementation.
2. **Refined Abstraction:** Specific versions of the logic (e.g., `UrgentPayment`).
3. **Implementor (Interface):** The bridge to the "dirty" details (e.g., `PaymentProvider`).
4. **Concrete Implementor:** Specific platform logic (e.g., `Stripe`, `PayPal`).