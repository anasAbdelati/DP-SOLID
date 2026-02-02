package good;

public class SeasonalDiscount implements DiscountStrategy {
    @Override
    public double apply(double amount) {
        return amount * 0.9;
    }
}
