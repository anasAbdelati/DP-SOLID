package bad;

/**
 * VIOLATION: The child class breaks the parent's contract.
 */
public class AccountProcessor {
    public void process(BankingAccount account) {
        // This code expects ANY BankingAccount to work.
        // If passed a FixedTermDepositAccount, it crashes.
        account.withdraw(100);
    }
}
