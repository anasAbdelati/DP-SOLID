public class LoanAccount implements Account {
    public double interestRate;
    public double amountOwed;

    public LoanAccount(double rate, double amount) {
        this.interestRate = rate;
        this.amountOwed = amount;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}