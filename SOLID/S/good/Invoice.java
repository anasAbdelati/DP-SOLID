package good;

public class Invoice {
    private double amount;
    private String id;

    public Invoice(double amount, String id) {
        this.amount = amount;
        this.id = id;
    }

    public void calculateTotalWithTax() {
        this.amount = this.amount * 1.20;
    }

    public String getId() { return id; }
    public double getAmount() { return amount; }
}
