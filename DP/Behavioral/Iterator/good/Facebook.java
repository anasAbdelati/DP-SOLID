import java.util.ArrayList;
import java.util.List;

public class Facebook implements SocialNetwork {
    private List<Profile> profiles = new ArrayList<>();

    public void addProfile(Profile p) { profiles.add(p); }

    @Override
    public ProfileIterator createFriendsIterator(String profileEmail) {
        // In a real app, this would filter by email. 
        // Returning the iterator hides that we use a List.
        return new FacebookIterator(profiles);
    }

    @Override
    public ProfileIterator createCoworkersIterator(String profileEmail) {
        return null; // Implementation omitted
    }
}