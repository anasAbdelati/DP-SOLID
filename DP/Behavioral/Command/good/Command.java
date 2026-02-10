public interface Command {
    void execute();
    void undo(); // Command pattern makes undo logic easy
}