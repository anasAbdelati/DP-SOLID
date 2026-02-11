# Singleton Pattern

### Purpose
The Singleton pattern ensures that a class has only one instance and provides a global point of access to it.

### What it Solves
* **Shared Resource Conflict:** Prevents multiple instances from fighting over a single resource (e.g., Database Connection Pools, Loggers).
* **Global State Management:** Provides a centralized place to store configuration settings.
* **Memory Waste:** Prevents the creation of unnecessary duplicate objects.

### Singleton vs. Static Class (The Difference)
* **Static Class:** Hard to mock, no polymorphism, initialized immediately by ClassLoader.
* **Singleton:** Supports Lazy Loading, implements interfaces, and can be passed as a regular object.



### Real-World Analogy
Think of the **President of a Country**. There is only one President at a time. No matter where you are, when you refer to "The President," you refer to the same individual. You don't create a new one for every question.

### When to use it?
* When exactly one instance of a class is needed to coordinate actions.
* When you need strict control over global variables.

### Architecture Context
* **System Archi:** This is how **Spring Framework** manages beans by default.
* **Database ACID:** Think of a **Global Lock Manager**. To ensure **Isolation**, you need one authority to grant or deny locks. Two managers would cause corruption.

### The Problematic
Imagine a **Database Connection Manager**. If every class calls `new DatabaseConnection()`, a high-traffic app will open 5,000 connections and crash the DB server. Also, updates to settings in one instance won't be visible to others.

### The Solution
1. **Private Constructor:** Prevents direct instantiation.
2. **Private Static Instance:** Holds the unique copy.
3. **Public Static Method:** Provides access and handles Lazy Initialization.