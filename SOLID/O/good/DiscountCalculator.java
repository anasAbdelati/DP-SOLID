package good;

public class DiscountCalculator {
    /**
     * This method is OPEN for extension (pass any new implementation of Strategy)
     * but CLOSED for modification (the logic inside never has to change again).
     */
    public double calculate(double amount, DiscountStrategy strategy) {
        return strategy.apply(amount);
    }
}