public class DraftState implements State {
    @Override
    public void publish(Document2 doc) {
        System.out.println("Moving from Draft to Moderation.");
        doc.setState(new ModerationState());
    }

    @Override
    public void render() {
        System.out.println("Rendering Draft: Greyed out version.");
    }
}