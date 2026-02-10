// This is the "Bridge" to the platform-specific logic
public interface PaymentProvider {
    void launchGateway();
    void transfer(double amount);
}