public class User {
    private ChatMediator mediator;
    private String name;

    public User(ChatMediator med, String name) {
        this.mediator = med;
        this.name = name;
    }

    public void send(String msg) {
        System.out.println(this.name + ": Sending -> " + msg);
        mediator.sendMessage(msg, this);
    }

    public void receive(String msg) {
        System.out.println(this.name + ": Message received -> " + msg);
    }
}