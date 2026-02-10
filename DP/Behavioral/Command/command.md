# Command Pattern

### Purpose
The Command pattern turns a **request** into a **stand-alone object**. This object contains all the information needed to perform the action, including the method to call, the arguments, and the object that implements the method.

### What it Solves
1. **Coupling:** It decouples the object that invokes the operation (the Invoker) from the one that knows how to perform it (the Receiver).
2. **Callback logic:** It provides an object-oriented replacement for callbacks.
3. **Queueing/Scheduling:** Since requests are now objects, you can store them in a list, queue them, or send them over a network.
4. **Undo/Redo:** Because each command is an object, you can keep a "history stack" and call an `undo()` method on them in reverse order.

### Real-World Analogy
Think of a **Waiter** in a restaurant.
* You (the **Client**) give an order to the **Waiter** (the **Invoker**).
* The Waiter writes the order on a **Slip** (the **Command**).
* The Slip is just an object that contains the request.
* The Waiter hands the Slip to the **Chef** (the **Receiver**), who knows how to cook.
  The Waiter doesn't need to know how to cook; they just need to "invoke" the order by handing the slip to the chef.

### When to use it?
* When you want to parameterize objects by an action to perform.
* When you need to support **Undo** operations.
* When you want to queue or log requests—this is exactly how **Transaction Logs** work in a DBMS to protect data from crashes.
### The Problematic
Imagine a `RemoteControl` for a smart home. You have different devices: a `Light` and a `Stereo`.
Without the Command pattern, the `RemoteControl` would have hard-coded methods like `pressLightButton()` and `pressStereoButton()`. If you add a `Thermostat`, you have to modify the Remote's code. The Remote is tightly coupled to every device.

### The Solution
1. Create a `Command` interface with an `execute()` method.
2. Create concrete commands: `LightOnCommand`, `StereoOnCommand`.
3. The `RemoteControl` (Invoker) just holds a `Command` object. When a button is pressed, it calls `command.execute()`.
4. The Remote doesn't care if it's turning on a light or a nuclear reactor.