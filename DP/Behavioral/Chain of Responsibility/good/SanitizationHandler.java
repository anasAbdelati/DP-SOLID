public class SanitizationHandler extends PaymentHandler {
    @Override
    public boolean handle(String token, double amount, String input) {
        if (input.toUpperCase().contains("DROP")) {
            System.out.println("Chain Aborted: SQL Injection detected.");
            return false;
        }
        System.out.println("Sanitization passed...");
        return checkNext(token, amount, input);
    }
}