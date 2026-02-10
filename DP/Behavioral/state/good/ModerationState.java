public class ModerationState implements State {
    @Override
    public void publish(Document2 doc) {
        System.out.println("Moderation successful. Moving to Published.");
        doc.setState(new PublishedState());
    }

    @Override
    public void render() {
        System.out.println("Rendering Moderation: Showing 'Pending Review' watermark.");
    }
}