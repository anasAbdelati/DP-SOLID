# Proxy Pattern

### Purpose
The Proxy pattern provides a surrogate or placeholder for another object to control access to it.

### What it Solves
* **Remote Proxy (The Network Gap):** Hides the fact that an object lives on a different server. You call a local method, and the Proxy handles the network sockets.
* **Virtual Proxy (Memory Management):** Prevents loading 2GB of data into RAM until the absolute second it is needed.
* **Protection Proxy (Security):** Acts as a firewall. It intercepts calls and checks for API keys or JWT tokens before letting the request hit the business logic.
* **Smart Reference:** Performs extra housekeeping (like counting references or locking an object) when it is accessed.

### Proxy vs. Adapter (The Difference)
* **Adapter:** Changes the **interface** so two incompatible things can talk.
* **Proxy:** Keeps the **exact same interface** but controls **how and when** you talk to the real object.

### Real-World Analogy
Think of a **Diplomatic Bodyguard**.
A foreign Ambassador (The Real Subject) is in town. You (The Client) want to talk to him. You don't just walk up and grab his shoulder. You talk to the **Bodyguard (The Proxy)**. The Bodyguard has the "same interface" (he speaks for the Ambassador). He checks if you have an appointment (Security), makes sure the Ambassador isn't busy (Concurrency), and only then relays your message.

### When to use it?
* When you are using a heavy third-party service that you want to "Lazy Load."
* When you need to add a layer of Security/Auth to a legacy class you aren't allowed to modify.
* When the "Real Object" lives on a remote server (RMI, RPC, or gRPC).

### Architecture Context
* **System Archi:** This is the core of **Spring AOP (Aspect Oriented Programming)**. When you put `@Transactional` on a method, Spring wraps your bean in a Proxy. The Proxy starts the DB transaction, calls your method, and then commits. You never see the "Real Bean."
* **Database ACID:** Think of **Connection Pooling**. When you call `connection.close()`, you aren't actually closing the physical TCP socket to the DB (that's expensive). You are calling a Proxy that just returns the connection to the "pool" for the next guy. This ensures **Availability**.

### The Problematic
Imagine a **Remote Trading Terminal**.
The `TradeExecutor` is a class that handles multi-million dollar stock buys. It connects via a heavy Socket to the Stock Exchange.
In the **Bad Code**, every time a developer creates a `TradeExecutor` object, it opens a live socket and starts consuming \$500/hour in bandwidth/connection fees—even if they never actually place a trade! Plus, there is zero authentication; if you have the object, you can spend the company's money.

### The Solution
1. **Subject Interface:** `ITradeExecutor` (defines `placeTrade`).
2. **Real Subject:** `HighFrequencyTradeExecutor` (expensive, dangerous, network-heavy).
3. **Proxy:** `TradeProxy`. It checks if the user is logged in and only opens the expensive network socket the moment `placeTrade` is actually called.