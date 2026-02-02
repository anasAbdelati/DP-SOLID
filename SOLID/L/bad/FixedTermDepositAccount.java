package bad;

public class FixedTermDepositAccount extends BankingAccount {
    @Override
    public void withdraw(double amount) {
        // ERROR: This breaks the expectation that all BankingAccounts can withdraw.
        throw new UnsupportedOperationException("Withdrawals not allowed for Fixed Term accounts!");
    }
}
