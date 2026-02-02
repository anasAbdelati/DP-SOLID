package good;

public class InvoiceRepository {
    public void save(Invoice invoice) {
        // This class only cares about how to talk to the DBMS
        System.out.println("DBMS: Saving invoice " + invoice.getId() + " to disk.");
    }
}
