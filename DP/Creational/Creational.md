# Creational Design Patterns

### What are they?
Creational patterns are all about **object instantiation**. They decouple a system from how its objects are created, composed, and represented.

### Why use them?
They provide mechanisms to create objects in a manner suitable to the situation, which can be more flexible than simple direct instantiation.
* **Control:** They prevent the "Wild West" of `new` keywords scattered everywhere, allowing you to control the lifecycle and quantity of objects.
* **Flexibility:** They allow the system to decide *which* concrete class to instantiate at runtime without hardcoding it.
* **Complexity Management:** They simplify the construction of complex, multi-part objects.