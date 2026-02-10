public class SavingsAccount implements Account {
    public double balance;

    public SavingsAccount(double balance) { this.balance = balance; }

    @Override
    public void accept(Visitor v) {
        // Double Dispatch Handshake
        v.visit(this);
    }
}