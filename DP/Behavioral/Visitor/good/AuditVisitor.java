public class AuditVisitor implements Visitor {
    @Override
    public void visit(SavingsAccount savings) {
        System.out.println("Auditing Savings: Checking if balance is positive.");
    }

    @Override
    public void visit(LoanAccount loan) {
        System.out.println("Auditing Loan: Checking collateral for amount: " + loan.amountOwed);
    }
}