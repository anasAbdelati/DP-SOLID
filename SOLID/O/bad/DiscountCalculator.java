package bad;

/**
 * VIOLATION: This class is NOT closed for modification.
 * Every time a new discount type is added, we must modify this existing code.
 */
public class DiscountCalculator {
    public double applyDiscount(double amount, String type) {
        if (type.equalsIgnoreCase("VIP")) {
            return amount * 0.8; // 20% off
        } else if (type.equalsIgnoreCase("SEASONAL")) {
            return amount * 0.9; // 10% off
        }
        // PROBLEM: Adding a "FLASH_SALE" requires adding another 'else if' here.
        return amount;
    }
}