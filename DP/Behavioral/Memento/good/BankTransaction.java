public class BankTransaction {
    private String status;
    private double amount;
    private int internalRiskRating;

    public BankTransaction(double amount) {
        this.amount = amount;
        this.status = "PENDING";
        this.internalRiskRating = 1; // Default low risk
    }

    public void applyRiskAdjustment(int newRating) {
        this.internalRiskRating = newRating;
        this.status = (newRating > 5) ? "FLAGGED" : "PENDING";
    }

    // Create the Memento
    public TransactionMemento createCheckpoint() {
        System.out.println("Transaction: Creating checkpoint. Status: " + status);
        return new TransactionMemento(status, amount, internalRiskRating);
    }

    // Restore from Memento
    public void rollback(TransactionMemento memento) {
        this.status = memento.getStatus();
        this.amount = memento.getAmount();
        this.internalRiskRating = memento.getInternalRiskRating();
        System.out.println("Transaction: Rollback complete. Status restored to: " + status);
    }

    @Override
    public String toString() {
        return String.format("Transaction[Amount: %.2f, Status: %s, Risk: %d]", 
                              amount, status, internalRiskRating);
    }
}