package good;

public class BankingService {
    /**
     * Now this method is safe. It only accepts WithdrawableAccount.
     * We can substitute RegularAccount here, and it works.
     * FixedTermDepositAccount cannot even be passed here (compiler error),
     * preventing runtime crashes.
     */
    public void withdrawMoney(WithdrawableAccount account, double amount) {
        account.withdraw(amount);
    }
}
