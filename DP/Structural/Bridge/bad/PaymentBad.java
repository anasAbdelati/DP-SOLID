/**
 * ARCHITECTURAL VIOLATIONS:
 * 1. Class Explosion: We are multiplying PaymentTypes by Providers.
 * 2. Rigid: If we want to add 'Revolut' as a provider, we have to create 
 * 'RevolutCard' and 'RevolutCrypto' classes.
 * 3. Logic Duplication: Stripe logic is repeated across multiple subclasses.
 */
abstract class PaymentBad {
    abstract void process();
}

class StripeCardPaymentBad extends PaymentBad {
    void process() { System.out.println("Processing Card via Stripe API..."); }
}

class PayPalCardPaymentBad extends PaymentBad {
    void process() { System.out.println("Processing Card via PayPal API..."); }
}

class StripeCryptoPaymentBad extends PaymentBad {
    void process() { System.out.println("Processing Crypto via Stripe API..."); }
}