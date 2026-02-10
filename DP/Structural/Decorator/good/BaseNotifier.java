public class BaseNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("CORE: Sending Email: " + message);
    }
}