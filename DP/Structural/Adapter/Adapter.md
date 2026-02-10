# Adapter Pattern

### Purpose
The Adapter pattern allows objects with incompatible interfaces to collaborate. It acts as a wrapper that converts the calls from one interface into a format that the second interface understands.

### What it Solves
* **The Legacy Gap:** It allows you to use old, proven code (Legacy) within a modern system that expects a different interface.
* **3rd-Party Incompatibility:** If you swap one external library (e.g., Stripe) for another (e.g., PayPal), you don't have to rewrite your whole app—just swap the Adapter.
* **Format Translation:** It handles the "translation" of data types (e.g., converting a `List` to an `Enumeration` or `XML` to `JSON`).

### Adapter vs. Decorator (The Difference)
* **Decorator:** Enhances an object's **behavior** but keeps the **same interface**.
* **Adapter:** Changes the **interface** so it becomes compatible with a different one. It doesn't usually add new features; it just "maps" them.



### Real-World Analogy
Think of a **Power Plug Adapter**.
You have a laptop with a **US Plug** (The Client). You are in a hotel in **France** (The Service). The wall socket expects two round pins, but you have three flat ones. You don't rewire your laptop or the hotel's electricity. You buy an **Adapter**. The laptop plugs into the Adapter, and the Adapter plugs into the wall. The Adapter "translates" the physical interface.

### When to use it?
* When you want to use an existing class, but its interface does not match the one you need.
* When you want to create a reusable class that cooperates with unrelated or unforeseen classes (classes that don't necessarily have compatible interfaces).
* When you need to use several existing subclasses, but it’s impractical to adapt their interface by sub-classing every one.

### Architecture Context
* **System Archi:** This is the core of **Hexagonal Architecture (Ports and Adapters)**. Your business logic stays pure in the center, and you use Adapters to talk to Databases, External APIs, or Message Queues.
* **Database ACID:** Think of **JDBC Drivers**. Java provides a standard `Connection` interface. Every database (MySQL, PostgreSQL, Oracle) has different internal protocols. The JDBC Driver is the **Adapter** that translates standard Java calls into database-specific commands.

### The Problematic
Imagine a **Modern Banking App** that displays stock prices. It expects all data in **JSON**.
You decide to integrate a **Legacy Financial Engine** (3rd party) that provides extremely accurate data, but it only outputs **XML**. Since you cannot modify the 3rd-party library and you don't want to pollute your clean JSON-based UI with XML parsing logic, you are stuck.

### The Solution
1. **Target Interface:** The interface your modern app speaks (JSON-based).
2. **Adaptee:** The legacy/external class that needs adapting (XML-based).
3. **Adapter:** A class that implements the Target Interface but contains an instance of the Adaptee. It translates the XML data into JSON inside its methods.