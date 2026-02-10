/**
 * ARCHITECTURAL VIOLATIONS:
 * 1. Class Explosion: For every new combination, we need a new class.
 * 2. Static logic: You cannot decide to add SMS at runtime; it's hardcoded in the type.
 * 3. Fragile: 'SMSAndSlack' depends on 'Slack' which depends on 'Email'. 
 * A bug in Email crashes the entire hierarchy.
 */
class EmailNotification {
    public void send(String msg) { System.out.println("Sending Email: " + msg); }
}

class SMSAndEmailNotification extends EmailNotification {
    @Override
    public void send(String msg) {
        super.send(msg);
        System.out.println("Sending SMS: " + msg);
    }
}

class SlackSMSAndEmailNotification extends SMSAndEmailNotification {
    @Override
    public void send(String msg) {
        super.send(msg);
        System.out.println("Sending Slack: " + msg);
    }
}