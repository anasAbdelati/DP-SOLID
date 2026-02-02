# S: Single Responsibility Principle (SRP)

### Definition
"A class should have one, and only one, reason to change."

### Why it is important
In architecture, SRP prevents the creation of **"God Classes"**—objects that do too much. When a class has multiple responsibilities:
1. **It is fragile:** Changing the database logic might accidentally break the business logic.
2. **It is hard to test:** You can't test one part of the logic without triggering all the others.
3. **It is hard to reuse:** If you want logic in another project, you are forced to take unrelated dependencies with it.

### The Problematic (The "Bad" Code)
We have an `Invoice` class that handles three different things:
1. Managing invoice data (Business Logic).
2. Saving the invoice to a Database (Persistence).
3. Sending an email notification (Communication).

This is a violation because if the Database schema changes, or if we switch from Email to SMS, we have to modify the same class.

### The Solution
We split the responsibilities into specialized classes:
1. `Invoice`: Purely holds data and business math.
2. `InvoiceRepository`: Handles the interaction with the DBMS (Database Management System).
3. `NotificationService`: Handles notifications.