public class RemoteControl {
    private Command slot; // High-level abstraction

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void pressButton() {
        slot.execute();
    }
}