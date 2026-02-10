class PayPalProvider implements PaymentProvider {
    public void launchGateway() {
        System.out.println("PayPal: Redirecting to Express Checkout...");
    }
    public void transfer(double amount) {
        System.out.println("PayPal: Sending $" + amount);
    }
}
