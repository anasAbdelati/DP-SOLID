public class BankingApp {
    public static void main(String[] args) {
        BankTransaction tx = new BankTransaction(10000.0);
        TransactionHistory history = new TransactionHistory();

        // 1. Save Initial State
        history.save(tx);

        // 2. Analyst tries a risky adjustment
        System.out.println("Analyst: Increasing risk rating...");
        tx.applyRiskAdjustment(9);
        System.out.println("Current State: " + tx);

        // 3. Decision: This looks wrong, let's rollback
        System.out.println("Analyst: Decision rejected. Rolling back.");
        history.undo(tx);

        System.out.println("Final State: " + tx);
    }
}