# Chain of Responsibility Pattern

### Purpose
The Chain of Responsibility pattern decouples the sender of a request from its potential receivers by giving multiple objects a chance to handle the request. It links the receiving objects in a chain and passes the request along until an object handles it or the chain ends.

### What it Solves
* **The "If-Else" Hell:** It eliminates massive, monolithic conditional blocks used to determine which logic should process a specific request.
* **Dynamic Workflow Orchestration:** It allows you to add, remove, or reorder processing steps at runtime without touching the client code.
* **Single Responsibility Principle (SRP):** Instead of one "God Class" handling authentication, logging, validation, and caching, each concern is isolated into its own handler.

### Real-World Analogy
Think of a **Technical Support Hotline**.  
You call in (The Request). First, you hit the **Automated Bot** (Level 1). If it’s a simple password reset, the bot handles it. If it’s complex, the bot "passes" you to a **Human Representative** (Level 2). If the human can't solve your server outage, they escalate you to a **Senior Engineer** (Level 3). You, the caller, just want a solution; you don't care who in the chain provides it.

### When to use it?
* When more than one object may handle a request, and the handler isn't known beforehand.
* When you want to issue a request to one of several objects without specifying the receiver explicitly.
* When the set of objects that can handle a request should be specified dynamically.

### Architecture Context
* **System Archi:** This is the backbone of **Middleware** and **Interceptors**. Spring Security filters and Express.js middlewares are pure Chain of Responsibility implementations.
* **Database ACID:** In a complex transaction, you can view the "Validation -> Locking -> Execution -> Logging" sequence as a chain. If the `LockingHandler` fails to acquire a row lock, it breaks the chain, preventing the `ExecutionHandler` from violating **Consistency** or **Isolation**.

### The Problematic
Imagine a **Banking Payment Gateway**. Every transaction must be:
1. Authenticated (Valid API Key).
2. Sanitized (No SQL injection).
3. Fraud-Checked (Amount threshold).

If you write this in one method, you create a "Big Ball of Mud." Adding a fifth check (e.g., Geo-fencing) requires modifying and re-testing the entire sensitive payment logic.

### The Solution
1. **Handler Interface:** Defines a `setNext()` and a `handle()` method.
2. **Concrete Handlers:** `AuthHandler`, `FraudHandler`, `SanitizationHandler`.
3. **Client:** Builds the chain and kicks off the first link.