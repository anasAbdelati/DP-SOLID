package good;

public abstract class WithdrawableAccount extends Account {
    public void withdraw(double amount) {
        this.balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }
}
