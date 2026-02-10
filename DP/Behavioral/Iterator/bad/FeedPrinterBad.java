import java.util.List;

/**
 * ARCHITECTURAL VIOLATIONS:
 * 1. High Coupling: The Client is forced to know that Facebook uses a List 
 * and Twitter uses an Array.
 * 2. Violation of OCP: Adding a new platform requires modifying the printFeed logic.
 * 3. Exposed Internals: The internal storage (List/Array) is exposed to the outside world.
 */
class FeedPrinterBad {
    public void printFeed(List<String> fbPosts, String[] twitterPosts) {
        // Loop for Facebook
        for (int i = 0; i < fbPosts.size(); i++) {
            System.out.println(fbPosts.get(i));
        }
        
        // Totally different loop for Twitter
        for (int j = 0; j < twitterPosts.length; j++) {
            System.out.println(twitterPosts[j]);
        }
    }
}