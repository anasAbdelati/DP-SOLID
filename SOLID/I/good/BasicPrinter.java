package good;

// Lean and clean: Only implements what it actually does
public class BasicPrinter implements Printer {
    @Override
    public void print() {
        System.out.println("Printing simple document.");
    }
}