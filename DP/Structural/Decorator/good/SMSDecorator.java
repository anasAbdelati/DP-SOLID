class SMSDecorator extends BaseDecorator {
    public SMSDecorator(Notifier notifier) { super(notifier); }

    @Override
    public void send(String message) {
        super.send(message); // Call the wrapped object
        System.out.println("DECORATOR: Sending SMS: " + message);
    }
}

class SlackDecorator extends BaseDecorator {
    public SlackDecorator(Notifier notifier) { super(notifier); }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("DECORATOR: Sending Slack message...");
    }
}