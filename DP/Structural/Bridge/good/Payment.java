public abstract class Payment {
    // Composition: The Bridge to the implementation
    protected PaymentProvider provider;

    protected Payment(PaymentProvider provider) {
        this.provider = provider;
    }

    public abstract void collectPayment(double amount);
}