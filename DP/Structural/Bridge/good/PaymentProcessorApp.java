public class PaymentProcessorApp {
    public static void main(String[] args) {
        // We can mix and match at runtime!
        // Case A: Card Payment via Stripe
        Payment payment1 = new CardPayment(new StripeProvider());
        payment1.collectPayment(150.0);

        System.out.println("\n--- Switching Context ---\n");

        // Case B: Crypto Payment via PayPal (Same logic, different bridge)
        Payment payment2 = new CryptoPayment(new PayPalProvider());
        payment2.collectPayment(500.0);
    }
}