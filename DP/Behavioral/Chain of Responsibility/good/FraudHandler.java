public class FraudHandler extends PaymentHandler {
    @Override
    public boolean handle(String token, double amount, String input) {
        if (amount > 50000) {
            System.out.println("Chain Aborted: Fraud risk - amount too high.");
            return false;
        }
        System.out.println("Fraud check passed...");
        return checkNext(token, amount, input);
    }
}