package bad;

/**
 * VIOLATION: This class has 3 reasons to change:
 * 1. Logic for calculating totals changes.
 * 2. The Database system changes (e.g., SQL to NoSQL).
 * 3. The Notification method changes (e.g., Email to SMS).
 */
public class Invoice {
    private double amount;
    private final String id;

    public Invoice(double amount, String id) {
        this.amount = amount;
        this.id = id;
    }

    // Responsibility 1: Business Logic
    public void calculateTotalWithTax() {
        this.amount = this.amount * 1.20;
    }

    // Responsibility 2: Persistence
    public void saveToDatabase() {
        System.out.println("Saving invoice " + id + " to database...");
    }

    // Responsibility 3: Notification
    public void sendEmail() {
        System.out.println("Sending email for invoice " + id);
    }
}
