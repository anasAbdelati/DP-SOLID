/**
 * ARCHITECTURAL VIOLATIONS:
 * 1. Monolithic: One class handles auth, fraud, and validation.
 * 2. Fragile: Changing fraud logic risks breaking authentication.
 * 3. Not Scalable: Adding a 'RiskAssessment' check requires a new nested if-block.
 */
public class PaymentProcessorBad {
    public void process(String token, double amount, String input) {
        if (token.equals("123")) {
            if (!input.contains("DROP TABLE")) {
                if (amount < 10000) {
                    System.out.println("Payment Approved!");
                } else {
                    System.out.println("Fraud Alert!");
                }
            } else {
                System.out.println("Security Threat Detected!");
            }
        } else {
            System.out.println("Unauthorized!");
        }
    }
}