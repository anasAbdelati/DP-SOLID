# Iterator Pattern

### Purpose
The Iterator pattern provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation (List, Stack, Tree, etc.).

### What it Solves
* **Implementation Leaking:** It prevents the client from needing to know if a collection is an Array, a LinkedList, or a Hash. You can swap the data structure without breaking the client's `while` loop.
* **Traversal Bloat:** It keeps the collection class focused on *storing* data, while the Iterator focuses on *traversing* data (Single Responsibility Principle).
* **Multiple Concurrent Iterations:** You can have two different iterators at different positions on the same collection simultaneously without them interfering with each other.

### Iterator vs. Visitor (The Difference)
* **Iterator:** Used to **traverse** a collection linearly. It focuses on getting from element A to element B.
* **Visitor:** Used to **perform operations** on elements of a complex structure. It’s about *what you do* once you arrive at the element.

### Real-World Analogy
Think of a **TV Remote "Channel Surfing" button**.
The TV has a list of channels. Some might be digital, some analog, some streaming. You don't need to know the frequency or the source of the channel. You just press "Next." The Remote acts as the **Iterator**, keeping track of where you are in the list and giving you the next available channel.

### When to use it?
* When your collection has a complex data structure under the hood (like a Tree) and you want to hide this complexity from clients for security or simplicity.
* When you need to provide a uniform traversal interface for different types of structures.
* When you want to support multiple ways of traversing (e.g., Breadth-First vs. Depth-First).

### Architecture Context
* **System Archi:** This is the foundation of **Reactive Streams** and **Java Streams**. When you call `.filter()` or `.map()`, you are essentially building a chain of Iterators that pull data through a pipeline.
* **Database ACID:** In large-scale data retrieval, we use **Cursors**. A database cursor is a server-side Iterator. It allows a client to fetch 1 million rows in small batches (e.g., 100 at a time) to prevent **Out Of Memory (OOM)** errors, ensuring the system remains stable and available.

### The Problematic
Imagine a **Social Media Feed** aggregator. It collects posts from a `List` of Facebook posts and a `Fixed Array` of Twitter posts. If the `FeedPrinter` class has to write one loop for the List and another for the Array, the code becomes brittle. If you add LinkedIn (which uses a Set), you have to rewrite the printer logic again.

### The Solution
1. **Iterator Interface:** Defines `hasNext()` and `next()`.
2. **Aggregate Interface:** Defines a method `createIterator()`.
3. **Concrete Iterator:** Knows how to step through the specific collection.