# L: Liskov Substitution Principle (LSP)

### Definition
"Subtypes must be substitutable for their base types."

### Why it is important
LSP ensures that inheritance is used correctly. If a Child class cannot do everything the Parent class promised, the "Contract" is broken.
1. **Prevents Runtime Crashes:** You won't get unexpected `UnsupportedOperationException` errors.
2. **Promotes Polymorphism:** You can treat all child objects as the parent type without needing `if (obj instanceof Child)` checks.
3. **Consistency:** It ensures that the logic remains predictable across the entire class hierarchy.

### The Problematic (The "Bad" Code)
We have a base class `BankingAccount`. It has a method `withdraw()`.
We then create a `FixedTermDepositAccount`. In the real world, you cannot withdraw from this account until a certain date.
If we make it a child of `BankingAccount` and throw an Exception in the `withdraw()` method, we have violated LSP. Any code expecting a generic account will crash when it tries to process a withdrawal.

### The Solution
We refactor the hierarchy. We recognize that not all accounts are "Withdrawal-ready."
1. We create a more general base class `Account`.
2. We create a specific interface or subclass `WithdrawableAccount` for accounts that support money removal.
3. Now, the code that performs withdrawals only accepts `WithdrawableAccount`, ensuring it never encounters an account that "breaks" the withdrawal contract.