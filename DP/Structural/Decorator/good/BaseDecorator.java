public abstract class BaseDecorator implements Notifier {
    protected Notifier wrapper;

    public BaseDecorator(Notifier notifier) {
        this.wrapper = notifier;
    }

    @Override
    public void send(String message) {
        wrapper.send(message);
    }
}