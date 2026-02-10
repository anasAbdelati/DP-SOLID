public class NotificationApp {
    public static void main(String[] args) {
        // We start with a simple Email notifier
        Notifier myStack = new BaseNotifier();

        // At runtime, the user wants SMS
        boolean userWantsSMS = true; 
        if (userWantsSMS) {
            myStack = new SMSDecorator(myStack);
        }

        // And they also want Slack
        myStack = new SlackDecorator(myStack);

        // One call triggers the entire stack
        System.out.println("--- Triggering Stack ---");
        myStack.send("Server Down!");
    }
}