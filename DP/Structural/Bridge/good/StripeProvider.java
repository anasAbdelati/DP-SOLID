class StripeProvider implements PaymentProvider {
    public void launchGateway() { System.out.println("Stripe: Initializing Webhook..."); }
    public void transfer(double amount) { System.out.println("Stripe: Charging $" + amount); }
}

