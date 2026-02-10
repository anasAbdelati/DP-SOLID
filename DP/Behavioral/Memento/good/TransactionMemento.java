// Immutable snapshot. No setters. 
// Package-private or restricted access ensures encapsulation.
public final class TransactionMemento {
    private final String status;
    private final double amount;
    private final int internalRiskRating;

    public TransactionMemento(String status, double amount, int internalRiskRating) {
        this.status = status;
        this.amount = amount;
        this.internalRiskRating = internalRiskRating;
    }

    // These are only for the Originator to read back
    String getStatus() { return status; }
    double getAmount() { return amount; }
    int getInternalRiskRating() { return internalRiskRating; }
}