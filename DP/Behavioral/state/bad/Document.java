/**
 * VIOLATION:
 * 1. Low Cohesion: Every method is full of "if-state == X" logic.
 * 2. OCP Violation: Adding a new state requires modifying every method.
 */
public class Document {
    private String state = "DRAFT";

    public void publish() {
        if (state.equals("DRAFT")) {
            state = "MODERATION";
            System.out.println("Document moved to Moderation.");
        } else if (state.equals("MODERATION")) {
            state = "PUBLISHED";
            System.out.println("Document is now Published.");
        } else if (state.equals("PUBLISHED")) {
            System.out.println("Already published. Doing nothing.");
        }
    }

    public void render() {
        if (state.equals("DRAFT")) {
            System.out.println("Rendering Draft preview...");
        } else if (state.equals("PUBLISHED")) {
            System.out.println("Rendering final document...");
        }
    }
}