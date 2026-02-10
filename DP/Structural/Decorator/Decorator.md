# Decorator Pattern

### Purpose
The Decorator pattern attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

### What it Solves
* **Class Explosion:** Prevents the need to create a new subclass for every possible combination of features.
* **Open/Closed Principle:** You can add new behaviors to an object without modifying its existing code.
* **Runtime Customization:** Unlike inheritance, which happens at compile-time, decorators allow you to "decorate" an object based on user input while the app is running.

### Decorator vs. Proxy (The Difference)
* **Proxy:** Usually manages the **lifecycle** of the object (Lazy loading, Access control). It rarely adds "new" business features; it just guards the existing ones.
* **Decorator:** Focuses on **adding new features**. It takes a "basic" object and makes it "premium" by adding logic before or after the core execution.

### Real-World Analogy
Think of **Winter Clothing**.
You are the "Core Object." When it's cold, you don't undergo surgery to become a "PersonWithSweater" (Inheritance). You put on a **Sweater (Decorator)**. If it’s raining, you put on a **Raincoat (another Decorator)** over the sweater. Each layer adds a new "feature" (warmth, waterproof) but you still have the "same interface" (you can still walk, talk, and eat).

### When to use it?
* When you need to add responsibilities to individual objects dynamically and transparently, without affecting other objects.
* When extension by subclassing is impractical (too many combinations).
* When you want to "stack" behaviors (e.g., Encryption + Compression + Logging).

### Architecture Context
* **System Archi:** This is exactly how **Java I/O Streams** work. When you write `new BufferedReader(new FileReader("file.txt"))`, you are decorating a raw file reader with "Buffering" capabilities.
* **Database ACID:** Think of **Query Decorators**. You might have a basic `SelectQuery`. You can decorate it with a `PaginationDecorator` (adding `LIMIT/OFFSET`) and then a `CachingDecorator`. Each layer modifies the final SQL string or the result set handling.

### The Problematic
Imagine a **Notification System**.
Initially, you just send **Email**. Then the business wants **SMS**. Then **Slack**. Then **Email + SMS**. Then **SMS + Slack**.
If you use inheritance, you end up with:
`SMSNotification extends EmailNotification` (Wait, what if I don't want Email?)
`SMSAndSlackNotification extends SlackNotification`...
It becomes a maintenance nightmare. If the `Email` logic changes, you risk breaking 15 subclasses.

### The Solution
1. **Component Interface:** `Notifier` (method `send()`).
2. **Concrete Component:** `EmailNotifier` (the "base" object).
3. **Base Decorator:** Implements `Notifier` and wraps another `Notifier`.
4. **Concrete Decorators:** `SMSDecorator`, `SlackDecorator`.