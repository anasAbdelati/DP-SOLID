public class PaymentGateway {
    public static void main(String[] args) {
        PaymentHandler chain = new AuthHandler();
        chain.setNext(new SanitizationHandler())
             .setNext(new FraudHandler());

        System.out.println("--- Scenario: Fraudulent Amount ---");
        chain.handle("SECRET_TOKEN", 999999, "Normal Transaction");
    }
}