/**
 * VIOLATION: Tight Coupling.
 * Each user must know about every other specific user.
 */
public class UserBad {
    private String name;
    // Problem: Adding a new user means updating everyone else's references.
    private UserBad friend1;
    private UserBad friend2;

    public UserBad(String name) { this.name = name; }

    public void sendMessage(String msg) {
        System.out.println(this.name + " sending: " + msg);
        if(friend1 != null) friend1.receive(msg);
        if(friend2 != null) friend2.receive(msg);
    }

    public void receive(String msg) {
        System.out.println(this.name + " received: " + msg);
    }
}