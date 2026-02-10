/**
 * VIOLATION: Single Responsibility & Open/Closed Principle.
 * The Account classes are "polluted" with business algorithms that 
 * change much more often than the account data itself.
 */
interface AccountBad {
    void calculateInterest();
    void generateMonthlyReport();
    void runRegulatoryAudit(); // Every new feature requires breaking these classes open.
}

class SavingsAccountBad implements AccountBad {
    private double balance;
    public void calculateInterest() { /* Savings logic */ }
    public void generateMonthlyReport() { /* Savings report */ }
    public void runRegulatoryAudit() { /* Savings audit */ }
}

class LoanAccountBad implements AccountBad {
    private double debt;
    public void calculateInterest() { /* Loan interest logic */ }
    public void generateMonthlyReport() { /* Loan report */ }
    public void runRegulatoryAudit() { /* Loan audit */ }
}