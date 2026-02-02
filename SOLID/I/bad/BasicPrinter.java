package bad;

class BasicPrinter implements SmartDevice {
    @Override
    public void print() {
        System.out.println("Printing document...");
    }

    @Override
    public void fax() {
        // ERROR: I can't fax! Forced to provide an empty or failing method.
        throw new UnsupportedOperationException("Fax not supported");
    }

    @Override
    public void scan() {
        // ERROR: I can't scan!
        throw new UnsupportedOperationException("Scan not supported");
    }
}
