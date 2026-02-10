public class Document2 {
    private State state;

    public Document2() {
        this.state = new DraftState(); // Initial state
    }

    public void setState(State state) {
        this.state = state;
    }

    public void publish() {
        state.publish(this);
    }

    public void render() {
        state.render();
    }
}