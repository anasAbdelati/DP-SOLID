/**
 * ARCHITECTURAL VIOLATIONS:
 * 1. Broken Encapsulation: To save the state, we are forced to provide public getters/setters 
 * for sensitive fields like 'internalRiskRating'.
 * 2. Anemic Model: The 'History' class has to do the heavy lifting of copying data.
 * 3. Security Risk: Any part of the app can now modify the risk rating directly.
 */
class BankTransactionBad {
    private String status;
    private double amount;
    private int internalRiskRating; // Should be hidden logic

    // Forced to make these public to "save" state elsewhere
    public void setInternalRiskRating(int rating) { this.internalRiskRating = rating; }
    public int getInternalRiskRating() { return this.internalRiskRating; }
    
    public void setStatus(String status) { this.status = status; }
    public String getStatus() { return this.status; }
}