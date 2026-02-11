public abstract class Logistics {
    // This is the "Factory Method"
    public abstract Transport createTransport();

    public void planDelivery() {
        // The creator doesn't know WHICH transport it's using!
        Transport t = createTransport();
        t.deliver();
    }
}