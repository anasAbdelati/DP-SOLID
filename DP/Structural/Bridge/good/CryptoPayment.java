class CryptoPayment extends Payment {
    public CryptoPayment(PaymentProvider provider) {
        super(provider);
    }

    @Override
    public void collectPayment(double amount) {
        System.out.println("Logic: Verifying Wallet Address...");
        provider.transfer(amount);
    }
}
