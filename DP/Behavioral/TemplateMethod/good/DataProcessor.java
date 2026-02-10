public abstract class DataProcessor {
    
    // The Template Method is 'final' so subclasses can't break the sequence
    public final void process() {
        openFile();
        parseData();
        saveData();
    }

    private void openFile() {
        System.out.println("Opening file... (Common logic)");
    }

    // This is the step that varies
    protected abstract void parseData();

    private void saveData() {
        System.out.println("Saving to Database... (Common logic)");
    }
}