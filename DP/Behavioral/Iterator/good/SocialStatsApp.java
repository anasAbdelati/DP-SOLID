public class SocialStatsApp {
    public static void main(String[] args) {
        Facebook fb = new Facebook();
        fb.addProfile(new Profile("John Doe", "Facebook"));
        fb.addProfile(new Profile("Jane Smith", "Facebook"));

        // The Client doesn't know it's a List!
        ProfileIterator iterator = fb.createFriendsIterator("john@doe.com");

        System.out.println("Scanning network...");
        while (iterator.hasNext()) {
            Profile p = iterator.next();
            System.out.println("Found: " + p);
        }
    }
}