public class PublishedState implements State {
    @Override
    public void publish(Document2 doc) {
        System.out.println("Already published. No action taken.");
    }

    @Override
    public void render() {
        System.out.println("Rendering Final: High-quality version.");
    }
}