package good;

public class FixedTermDepositAccount extends Account {
    // This account is NOT a WithdrawableAccount.
    // It stays an Account but doesn't promise withdrawal logic it can't fulfill.
}