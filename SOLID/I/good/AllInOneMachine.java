package good;

// Complex machines can still combine interfaces
public class AllInOneMachine implements Printer, Scanner, Fax {
    @Override
    public void print() { System.out.println("Printing..."); }
    
    @Override
    public void scan() { System.out.println("Scanning..."); }
    
    @Override
    public void fax() { System.out.println("Faxing..."); }
}