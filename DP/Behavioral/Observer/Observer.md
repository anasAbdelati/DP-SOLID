# Observer Pattern

### Purpose
The Observer pattern defines a one-to-many dependency between objects so that when one object (the **Subject**) changes state, all its dependents (**Observers**) are notified and updated automatically.

### What it Solves
1. **Tight Coupling:** It prevents the Subject from needing to know the specific classes of its observers. It only knows they follow a specific "Subscriber" interface.
2. **Polling Inefficiency:** Instead of observers constantly asking "Is there new data?", the Subject pushes data to them only when it changes.
3. **Hard-coded Dependencies:** You can add or remove subscribers at runtime without modifying the Subject's code.

### Real-World Analogy
Think of a **YouTube Channel**.
* The **Channel** is the **Subject**.
* The **Subscribers** are the **Observers**.
  The YouTuber doesn't call every subscriber individually to say "Hey, I posted a video." Instead, the subscribers "hit the bell icon." When a video is uploaded, YouTube automatically sends a notification to everyone on that list. If you "Unsubscribe," you simply get removed from the list and stop receiving updates.

### When to use it?
* When a change to one object requires changing others, and you don't know how many objects need to be changed.
* When an object should be able to notify others without making assumptions about who those objects are.
* In UI development (like **Angular**) where the view needs to update whenever the underlying data changes.

### The Problematic
Imagine a `WeatherStation` that tracks temperature. You want to display this temperature on a `PhoneApp` and a `WindowDisplay`.
Without the Observer pattern, the `WeatherStation` would need a hard-coded reference to the `PhoneApp` and `WindowDisplay` classes. Every time you add a new type of display (like a `Website`), you have to modify the `WeatherStation` code, violating the **Open/Closed Principle**.

### The Solution
1. Create a `Subject` interface with methods to `add()`, `remove()`, and `notifyObservers()`.
2. Create an `Observer` interface with an `update()` method.
3. The `WeatherStation` (Subject) maintains a simple **List** of `Observer` interfaces. When the temperature changes, it loops through the list and calls `update()` on each one.