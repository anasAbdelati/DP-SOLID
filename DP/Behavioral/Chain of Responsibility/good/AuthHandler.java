public class AuthHandler extends PaymentHandler {
    @Override
    public boolean handle(String token, double amount, String input) {
        if (!"SECRET_TOKEN".equals(token)) {
            System.out.println("Chain Aborted: Invalid API Token.");
            return false;
        }
        System.out.println("Auth passed...");
        return checkNext(token, amount, input);
    }
}