/**
 * VIOLATION: Massive Code Duplication.
 * Both classes repeat the "Open" and "Save" logic.
 * If the "Save" logic changes, we must edit both classes.
 */
class CSVProcessorBad {
    public void process() {
        System.out.println("Opening file...");
        System.out.println("Parsing CSV rows...");
        System.out.println("Saving to Database...");
    }
}

class PDFProcessorBad {
    public void process() {
        System.out.println("Opening file...");
        System.out.println("Parsing PDF text...");
        System.out.println("Saving to Database...");
    }
}