import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatMediator {
    private List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String msg, User originator) {
        for (User user : users) {
            // Don't send the message back to the person who sent it
            if (user != originator) {
                user.receive(msg);
            }
        }
    }
}