class CardPayment extends Payment {
    public CardPayment(PaymentProvider provider) { super(provider); }

    @Override
    public void collectPayment(double amount) {
        System.out.println("Logic: Processing Card Transaction...");
        provider.launchGateway();
        provider.transfer(amount);
    }
}

