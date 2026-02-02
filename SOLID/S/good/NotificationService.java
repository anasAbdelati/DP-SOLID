package good;

public class NotificationService {
    public void sendEmail(Invoice invoice) {
        // This class only cares about email protocols
        System.out.println("Notification: Email sent for invoice " + invoice.getId());
    }
}
