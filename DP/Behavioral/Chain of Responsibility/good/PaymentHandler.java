public abstract class PaymentHandler {
    private PaymentHandler next;

    public PaymentHandler setNext(PaymentHandler next) {
        this.next = next;
        return next;
    }

    public abstract boolean handle(String token, double amount, String input);

    protected boolean checkNext(String token, double amount, String input) {
        if (next == null) return true;
        return next.handle(token, amount, input);
    }
}