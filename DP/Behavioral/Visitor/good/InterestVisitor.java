public class InterestVisitor implements Visitor {
    @Override
    public void visit(SavingsAccount savings) {
        System.out.println("Adding 2% interest to balance: " + (savings.balance * 0.02));
    }

    @Override
    public void visit(LoanAccount loan) {
        System.out.println("Calculating loan interest: " + (loan.amountOwed * loan.interestRate));
    }
}