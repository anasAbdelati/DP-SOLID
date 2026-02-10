import java.util.List;

public class FacebookIterator implements ProfileIterator {
    private List<Profile> profiles;
    private int currentPosition = 0;

    public FacebookIterator(List<Profile> profiles) {
        this.profiles = profiles;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < profiles.size();
    }

    @Override
    public Profile next() {
        if (!hasNext()) return null;
        return profiles.get(currentPosition++);
    }
}